/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 *
 * https://leetcode.cn/problems/is-subsequence/description/
 *
 * algorithms
 * Easy (52.27%)
 * Likes:    981
 * Dislikes: 0
 * Total Accepted:    368K
 * Total Submissions: 704K
 * Testcase Example:  '"abc"\n"ahbgdc"'
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 
 * 
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 
 * 进阶：
 * 
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T
 * 的子序列。在这种情况下，你会怎样改变代码？
 * 
 * 致谢：
 * 
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * 0 
 * 两个字符串都只由小写字符组成。
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean isSubsequence(String s, String t) {
        // int sIndex = 0;
        // int tIndex = 0;
        // if(s.length()==0){
        // return true;
        // }
        // while (sIndex < s.length() && tIndex < t.length()) {
        // if (s.charAt(sIndex) == t.charAt(tIndex)) {
        // sIndex++;
        // tIndex++;
        // if(sIndex==s.length()) return true;
        // } else {
        // tIndex++;
        // }
        // }
        // return false;

        // 动态规划
        int[][] dp = new int[t.length() + 1][26];

        // dp[i][j] 代表t字符串 第i个字符后面 j第一次出现的索引

        // 初始化
        for (int i = 0; i < 26; i++) {
            dp[t.length()][i] = Integer.MAX_VALUE;
        }

        // 从后往前遍历
        for (int i = t.length() - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == 'a' + j)
                    dp[i][j] = i;
                else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        // 对s进行匹配
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dp[index][s.charAt(i) - 'a'] == Integer.MAX_VALUE)
                return false;
            index = dp[index][s.charAt(i) - 'a'] + 1;
        }

        return true;

    }
}
// @lc code=end
