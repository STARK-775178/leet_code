/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3 的幂
 *
 * https://leetcode.cn/problems/power-of-three/description/
 *
 * algorithms
 * Easy (51.11%)
 * Likes:    324
 * Dislikes: 0
 * Total Accepted:    224.5K
 * Total Submissions: 439.1K
 * Testcase Example:  '27'
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 27
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 0
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：n = 9
 * 输出：true
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：n = 45
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -2^31 <= n <= 2^31 - 1
 * 
 * 
 * 
 * 
 * 进阶：你能不使用循环或者递归来完成本题吗？
 * 
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        /**
         * 方法一 循环
         * Accepted
         * 21040/21040 cases passed (11 ms)
         * Your runtime beats 9.79 % of java submissions
         * Your memory usage beats 5.22 % of java submissions (42.1 MB)
         */
        // if (n == 1)
        //     return true;
        // while (n >= 3) {
        //     if (n % 3 != 0) {
        //         return false;
        //     }
        //     n = n / 3;
        //     if (n == 1)
        //         return true;
        // }
        // return false;


        /**
         * Accepted
            21040/21040 cases passed (9 ms)
            Your runtime beats 42.24 % of java submissions
            Your memory usage beats 40.63 % of java submissions (41.7 MB)
         */
        // long temp = 1;

        // while (temp<=n) {
        //     if(n==temp) return true;
        //     temp = temp * 3;
        // }
        // return false;


        //进阶：你能不使用循环或者递归来完成本题吗？
        return n > 0 && 1162261467 % n == 0;
        



    }
}
// @lc code=end
