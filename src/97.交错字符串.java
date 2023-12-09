/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 *
 * https://leetcode.cn/problems/interleaving-string/description/
 *
 * algorithms
 * Medium (44.62%)
 * Likes:    942
 * Dislikes: 0
 * Total Accepted:    127.7K
 * Total Submissions: 286K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * 
 * 
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 +
 * ...
 * 
 * 
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * 
 * 
 * 
 * 
 * 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它?
 * 
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // dp[i][j] 表示 s1 的前 i 个元素和 s2 的前 j 个元素是否能交错组成 s3 的前 i+j 个元素
        // dp[i][j] = (dp[i-1][j] && s1[i-1] == s3[i+j-1]) || (dp[i][j-1] && s2[j-1] ==
        // s3[i+j-1])
        // dp[0][0] = true
        // dp[0][j] = dp[0][j-1] && s2[j-1] == s3[j-1]
        // dp[i][0] = dp[i-1][0] && s1[i-1] == s3[i-1]
        // 时间复杂度 O(mn) 空间复杂度 O(mn)
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length())
            return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始化
        dp[0][0] = true;
        
        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <=n; j++) {
                int p = i + j - 1;
                
                if (i > 0) {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }

            }
        }

        return dp[m][n];
    }
}
// @lc code=end
