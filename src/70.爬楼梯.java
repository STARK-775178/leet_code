/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode.cn/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (54.15%)
 * Likes:    3324
 * Dislikes: 0
 * Total Accepted:    1.3M
 * Total Submissions: 2.4M
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 45
 * 
 * 
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // 递归
        // Time Limit Exceeded
        // 31/45 cases passed (N/A)
        // Testcase
        // 45
        // Expected Answer
        // 1836311903
        // if (n == 1 || n == 2)
        // return n;
        // return climbStairs(n - 1) + climbStairs(n - 2);
        /**
         * Accepted
         * 45/45 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 98.99 % of java submissions (37.6 MB)
         */
        Map map = new HashMap<Integer, Integer>();
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) {
                map.put(i, i);
            } else {
                map.put(i, (int) map.get(i - 1) + (int) map.get(i - 2));
            }
        }
        return (int) map.get(n);

        
    }
}
// @lc code=end
