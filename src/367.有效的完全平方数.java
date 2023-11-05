/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode.cn/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (44.83%)
 * Likes:    546
 * Dislikes: 0
 * Total Accepted:    243.6K
 * Total Submissions: 543.5K
 * Testcase Example:  '16'
 *
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * 
 * 不能使用任何内置的库函数，如  sqrt 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：num = 14
 * 输出：false
 * 解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= num <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        /**
         * Accepted
         * 71/71 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 5.13 % of java submissions (38.4 MB)
         */
        // 方法一：调用Math方法
        // double sqrt = Math.sqrt(num);
        // if (sqrt - (int) (sqrt) != 0) {
        // return false;
        // } else {
        // return true;
        // }
        // 方法二：穷举法
        /**
         * Accepted
         * 71/71 cases passed (1 ms)
         * Your runtime beats 11.18 % of java submissions
         * Your memory usage beats 77.61 % of java submissions (37.9 MB)
         */
        // int i = 0;
        // long ii = 0;
        // while (ii <= num) {
        // if (ii == num) {
        // return true;
        // } else {
        // i++;
        // ii = (long) i * i;
        // }
        // }
        // return false;

        // 方法三 二分法
        /**
         * Accepted
         * 71/71 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 65.35 % of java submissions (38 MB)
         */
        int left = 0;
        int right = num;
        int mid = (left + right) / 2;
        while (right >= left) {
            if ((long) mid * mid < num) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else if ((long) mid * mid > num) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
