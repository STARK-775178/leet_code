/*
 * @lc app=leetcode.cn id=523 lang=java
 *
 * [523] 连续的子数组和
 *
 * https://leetcode.cn/problems/continuous-subarray-sum/description/
 *
 * algorithms
 * Medium (28.70%)
 * Likes:    551
 * Dislikes: 0
 * Total Accepted:    102.8K
 * Total Submissions: 357.9K
 * Testcase Example:  '[23,2,4,6,7]\n6'
 *
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 
 * 
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 
 * 
 * 如果存在，返回 true ；否则，返回 false 。
 * 
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 0 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) return false;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        
        for (int i = 2; i <= n; i++) {
            set.add(preSum[i - 2] % k);
            if (set.contains(preSum[i] % k)) return true;
        }
        return false;

    }
    
}
// @lc code=end

