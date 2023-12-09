/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 *
 * https://leetcode.cn/problems/find-the-difference/description/
 *
 * algorithms
 * Easy (66.05%)
 * Likes:    433
 * Dislikes: 0
 * Total Accepted:    179.4K
 * Total Submissions: 271.7K
 * Testcase Example:  '"abcd"\n"abcde"'
 *
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * 
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 
 * 请找出在 t 中被添加的字母。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "", t = "y"
 * 输出："y"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        // 位运算
        /**
         * Accepted
         * 54/54 cases passed (4 ms)
         * Your runtime beats 20.32 % of java submissions
         * Your memory usage beats 46.73 % of java submissions (39.7 MB)
         */
        int ans = 0;
        String temp = s + t;
        for (int i = 0; i < temp.length(); i++) {
            ans ^= temp.charAt(i);
        }

        System.out.println(ans);

        return (char) ans;
    }
}
// @lc code=end
