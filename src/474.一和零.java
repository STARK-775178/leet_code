/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 *
 * https://leetcode.cn/problems/ones-and-zeroes/description/
 *
 * algorithms
 * Medium (65.67%)
 * Likes:    1093
 * Dislikes: 0
 * Total Accepted:    186.5K
 * Total Submissions: 283.9K
 * Testcase Example:  '["10","0001","111001","1","0"]\n5\n3'
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 
 * 
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1
 * ，大于 n 的值 3 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // 使用三维dp数组
        // int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        // for (int i = 1; i <= strs.length; i++) {
        //     int zeroOneCount[] = new int[2];
        //     for (char c : strs[i - 1].toCharArray()) {
        //         zeroOneCount[c - '0']++;
        //     }
        //     for (int j = 0; j <= m; j++) {
        //         for (int j2 = 0; j2 <= n; j2++) {
        //             dp[i][j][j2] = dp[i - 1][j][j2];
        //             if (j >= zeroOneCount[0] && j2 >= zeroOneCount[1]) {
        //                 dp[i][j][j2] = Math.max(dp[i - 1][j][j2],
        //                         dp[i - 1][j - zeroOneCount[0]][j2 - zeroOneCount[1]] + 1);
        //             }
        //         }
        //     }
        // }
        // return dp[strs.length][m][n];



        // 优化为二维数组
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[2];
            for (char c : strs[i].toCharArray()) {
                count[c - '0']++;
            }
            // 从后往前遍历
            for (int j = m; j >= count[0]; j--) {
                for (int j2 = n; j2 >= count[1]; j2--) {
                    dp[j][j2] = Math.max(dp[j][j2], dp[j - count[0]][j2 - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
    
}
// @lc code=end
