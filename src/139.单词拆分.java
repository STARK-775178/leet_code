/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 *
 * https://leetcode.cn/problems/word-break/description/
 *
 * algorithms
 * Medium (55.00%)
 * Likes:    2433
 * Dislikes: 0
 * Total Accepted:    542.4K
 * Total Submissions: 985K
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅由小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] 表示字符串 s 的前 i 个字符能否拆分成 wordDict 中的单词
        boolean[] dp = new boolean[s.length() + 1];
        // 初始化
        dp[0] = true;
        // 遍历字符串
        for (int i = 1; i <= s.length(); i++) {
            // 遍历字典
            for (String word : wordDict) {
                // 如果当前字符串长度大于字典中的单词长度
                if (i >= word.length()) {
                    // 如果当前字符串以字典中的单词结尾
                    if (s.substring(i - word.length(), i).equals(word)) {
                        // 如果前 i - word.length() 个字符能够拆分成 wordDict 中的单词
                        if (dp[i - word.length()]) {
                            // 则前 i 个字符也能够拆分成 wordDict 中的单词
                            dp[i] = true;
                            // 结束当前循环
                            break;
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }

}
// @lc code=end
