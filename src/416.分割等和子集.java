/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 *
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (52.26%)
 * Likes:    1951
 * Dislikes: 0
 * Total Accepted:    480.3K
 * Total Submissions: 918.5K
 * Testcase Example:  '[1,5,11,5]'
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 
 * 
 */

// @lc code=start

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= target)
            dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {

                if (j >= nums[i])
                    // 选或者不选
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                else
                    // 不选
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[nums.length - 1][target];
    }
}
// @lc code=end
