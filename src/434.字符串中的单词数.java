/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 *
 * https://leetcode.cn/problems/number-of-segments-in-a-string/description/
 *
 * algorithms
 * Easy (38.30%)
 * Likes:    222
 * Dislikes: 0
 * Total Accepted:    98.1K
 * Total Submissions: 256.1K
 * Testcase Example:  '"Hello, my name is John"'
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 
 * 示例:
 * 
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        //方法一 调用api
        // if(s == null || s.trim().length() == 0) return 0;
        //多个空格的情况
        // String[] strs = s.trim().split("\\s+");
        // return strs.length;
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                continue;
            }
            if((i-1>=0 && s.charAt(i-1)==' '&&s.charAt(i)!=' ')||(i==0)&&s.charAt(i)!=' '){
                count++;
            }
        }
        return count;


    }
}
// @lc code=end

