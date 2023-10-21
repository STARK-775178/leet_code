/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (53.62%)
 * Likes:    1856
 * Dislikes: 0
 * Total Accepted:    466.4K
 * Total Submissions: 871.5K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组 nums ，
 * 找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * -10^9 
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        // 先排序，从前往后找最长连续上升序列即可。该思路简单有效，但是复杂度已经至少有O(nlogn)O(nlogn)O(nlogn)。实现起来也比较简单，在此不讨论该解法。
        // 遍历数组中的每个元素num，然后以num为起点，每次+1向后遍历num+1,num+2,num+3...，判断这些元素是否存在于数组中。假设找到的最大的连续存在的元素为num+x，那么这个连续序列的长度即为x+1。最后将每个num所开始序列长度取个最大值即可。
        // 这个思路很通俗易懂，实现成代码
        // 74/74 cases passed (454 ms)
        // Your runtime beats 6.52 % of java submissions
        // Your memory usage beats 52.08 % of java submissions (58.2 MB)
        // if (nums.length == 0) {
        // return 0;
        // }
        // nums = Arrays.stream(nums)
        // .sorted().toArray();
        // int temp = 1, result = 1;
        // for (int i = 0; i < nums.length - 1; i++) {
        // if (nums[i] == nums[i + 1]) {
        // continue;
        // }
        // if (nums[i] == nums[i + 1] - 1) {
        // temp++;
        // } else {
        // // 停止递增
        // if (temp > result) {
        // result = temp;
        // }
        // temp = 1;
        // }
        // }
        // if (temp > result) {
        // result = temp;
        // }
        // return result;

        /**
         * 哈希表法
         * 74/74 cases passed (26 ms)
         * Your runtime beats 61.04 % of java submissions
         * Your memory usage beats 44.59 % of java submissions (58.5 MB)
         */
        Set<Integer> set = new HashSet<>();

        for (Integer integer : nums) {
            set.add(integer);
        }
        int temp = 0;
        int result = 0;
        for (Integer integer : set) {
            temp = integer;
            if (!set.contains(temp - 1)) {
                while (set.contains(temp + 1)) {
                    temp++;
                }
            }
            result = Math.max(result, temp - integer + 1);
        }
        return result;
    }
}
// @lc code=end
