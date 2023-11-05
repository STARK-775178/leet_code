/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 *
 * https://leetcode.cn/problems/arranging-coins/description/
 *
 * algorithms
 * Easy (45.15%)
 * Likes:    288
 * Dislikes: 0
 * Total Accepted:    126.4K
 * Total Submissions: 279.9K
 * Testcase Example:  '5'
 *
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        /**
         * 方法一
         * Accepted
         * 1335/1335 cases passed (6 ms)
         * Your runtime beats 33.09 % of java submissions
         * Your memory usage beats 80.72 % of java submissions (38.5 MB)
         */
        // int ans = 0;
        // while (n >= 0) {
        // ans++;
        // n = n - ans;
        // }
        // return ans < 0 ? 0 : ans - 1;

        /**
         * 二分法
         * Accepted
         * 1335/1335 cases passed (1 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 53.59 % of java submissions (38.6 MB)
         */

        long left = 1;
        long right = n;
        long mid = (left + right+1) / 2;
        while (left < right) {
            mid = (left + right + 1) / 2;
            if ((mid * (mid + 1)) / 2 <= n) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return (int) left;
    }
}
// @lc code=end
