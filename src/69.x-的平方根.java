/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 *
 * https://leetcode.cn/problems/sqrtx/description/
 *
 * algorithms
 * Easy (38.41%)
 * Likes:    1466
 * Dislikes: 0
 * Total Accepted:    808.7K
 * Total Submissions: 2.1M
 * Testcase Example:  '4'
 *
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：x = 4
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= x <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        /**
         * 暴力搜索
         * Accepted
         * 1017/1017 cases passed (41 ms)
         * Your runtime beats 5.6 % of java submissions
         * Your memory usage beats 69.09 % of java submissions (38.4 MB)
         */
        // int i;
        // for (i = 0; i <= x; i++) {
        // if ((long) i * i == x) {
        // return i;
        // } else if ((long) i * i > x) {
        // return i - 1;
        // }
        // }
        // return i;

        // 二分法
        // 1017/1017 cases passed (1 ms)
        // Your runtime beats 94.42 % of java submissions
        // Your memory usage beats 35.01 % of java submissions (38.6 MB)
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;

    }
}
// @lc code=end
