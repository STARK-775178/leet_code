/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 *
 * https://leetcode.cn/problems/non-decreasing-subsequences/description/
 *
 * algorithms
 * Medium (51.85%)
 * Likes:    756
 * Dislikes: 0
 * Total Accepted:    161.9K
 * Total Submissions: 312.2K
 * Testcase Example:  '[4,6,7,7]'
 *
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums,int start ,List<Integer> path,List<List<Integer>> res){
        if(path.size()>1){
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = start; i < nums.length; i++) {
            if(set.contains(nums[i])){
                continue;
            }
            if(path.size()==0||nums[i]>=path.get(path.size()-1)){
                set.add(nums[i]);
                path.add(nums[i]);
                dfs(nums, i+1, path, res);
                path.remove(path.size()-1);
            }

        }
    }

   

}
// @lc code=end

