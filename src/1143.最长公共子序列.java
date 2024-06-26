/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 *
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (64.97%)
 * Likes:    1480
 * Dislikes: 0
 * Total Accepted:    395.6K
 * Total Submissions: 608.9K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 
 * 一个字符串的 子序列
 * 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 
 * 
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 
 * 
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：text1 = "abcde", text2 = "ace" 
 * 输出：3  
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * text1 和 text2 仅由小写英文字符组成。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /**
         * 方法一 使用递归 超时
         * Time Limit Exceeded
            18/47 cases passed (N/A)
            Testcase
            "mhunuzqrkzsnidwbun"
            "szulspmhwpazoxijwbq"
         */
        // return dfs(text1.length() - 1, text2.length() - 1, text1, text2);

        /**
         * 
         * 方法二 使用记忆化搜索
         * Accepted
         * 47/47 cases passed (21 ms)
         * Your runtime beats 39.01 % of java submissions
         * Your memory usage beats 5.27 % of java submissions (47.8 MB)
         */
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {

            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];

    }

    private int dfs(int t1, int t2, String text1, String text2) {
        if (t1 == -1 || t2 == -1) {
            return 0;
        } else if (text1.charAt(t1) == text2.charAt(t2)) {
            return dfs(t1 - 1, t2 - 1, text1, text2) + 1;
        } else {
            return Math.max(dfs(t1 - 1, t2, text1, text2), dfs(t1, t2 - 1, text1, text2));
        }
    }
}
// @lc code=end
