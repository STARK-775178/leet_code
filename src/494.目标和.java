/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 *
 * https://leetcode.cn/problems/target-sum/description/
 *
 * algorithms
 * Medium (48.42%)
 * Likes:    1815
 * Dislikes: 0
 * Total Accepted:    398.7K
 * Total Submissions: 823.5K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 
 * 
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 
 * 
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1], target = 1
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 0-1背包问题
        // 问题转化为：找到nums的一个子集P，使得sum(P) = (target + sum(nums)) / 2
        for (int x : nums)
            target += x;

        if (target < 0 || target % 2 == 1)
            return 0;

        target /= 2;

        int n = nums.length;

        // n+1 行 target+1列 原因是 0行0列是边界条件
        int[][] f = new int[n][target + 1];
        
        //初始化第一列
        for (int i = 0; i < nums.length; i++) {
            f[i][0] = 1;
        }

        //初始化第一行
        if (nums[0] <= target) {
            f[0][nums[0]] = 1;
        }
       

        //从第二行第二列开始填表
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                //如果背包容量j小于物品重量nums[i]，则不能装入背包
                if (j < nums[i]) {
                    f[i][j] = f[i - 1][j];
                } else {
                    //如果背包容量j大于等于物品重量nums[i]，则考虑是否装入背包
                    f[i][j] = f[i - 1][j] + f[i - 1][j - nums[i]];
                }
            }
        }

        return f[n - 1][target];

    }
}
// @lc code=end
