/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode.cn/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (43.68%)
 * Likes:    642
 * Dislikes: 0
 * Total Accepted:    479.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '"Hello World"'
 *
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        /**
         * Accepted
         * 58/58 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 58.04 % of java submissions (39.6 MB)
         */
        // 方法一从后往前遍历
        int ans = 0;
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) != ' ') {
        if (flag == false) {
        flag = true;
        }
        ans++;
        } else {
        if (flag == false) {
        continue;
        }
        return ans;
        }
        }
        return ans;
        /**
         * Accepted
         * 58/58 cases passed (1 ms)
         * Your runtime beats 30.79 % of java submissions
         * Your memory usage beats 11.4 % of java submissions (39.8 MB)
         */
        // 方法二使用String 的split
        // String[] strs = s.split(" ");
        // if (strs.length == 0) {
        // return 0;
        // }
        // return strs[strs.length - 1].length();

        // 方法三使用String 的trim
        /**
         * Accepted
         * 58/58 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 59.03 % of java submissions (39.6 MB)
         */
        // s = s.trim();
        // int ans = 0;
        // for (int i = s.length() - 1; i >= 0; i--) {
        // if (s.charAt(i) != ' ') {
        // ans++;
        // } else {
        // break;
        // }
        // }
        // return ans;
        /**
         * Accepted
         * 58/58 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 29.2 % of java submissions (39.7 MB)
         */
        // 方法四使用String 的trim和lastIndexOf
        // s = s.trim();
        // return s.length() - s.lastIndexOf(" ") - 1;
        
    }
}
// @lc code=end
