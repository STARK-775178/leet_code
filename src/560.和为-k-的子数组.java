/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 *
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (44.47%)
 * Likes:    2210
 * Dislikes: 0
 * Total Accepted:    388.5K
 * Total Submissions: 874.4K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 
 * 子数组是数组中元素的连续非空序列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * 
 * 
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int dp[] = new int[nums.length+1];
        dp[0] = 0;
        int res = 0;
        for(int i = 1; i <= nums.length; i++){
            dp[i] = dp[i-1] + nums[i-1];
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j <= nums.length; j++){
                if(dp[j] - dp[i] == k){
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

