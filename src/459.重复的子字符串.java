/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 *
 * https://leetcode.cn/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (51.42%)
 * Likes:    1114
 * Dislikes: 0
 * Total Accepted:    228.3K
 * Total Submissions: 444.4K
 * Testcase Example:  '"abab"'
 *
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "aba"
 * 输出: false
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 由小写英文字母组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // //返回s+s的子串中去掉首尾元素后是否包含s，如果包含则说明s是由重复子串构成的，否则不是
        // // return (s + s).indexOf(s, 1) != s.length();
        // int n = s.length();
        // //从1开始枚举子串长度是因为子串长度必须是s长度的因数
        // for(int i = 1; i * 2 <= n; i++){
        //     //判断子串长度是否是s长度的因数
        //     if(n % i == 0){
        //         boolean match = true;
        //         for(int j = i; j < n; j++){
        //             //判断子串是否由重复的子串构成 j - i是因为j是从i开始的
        //             if(s.charAt(j) != s.charAt(j - i)){
        //                 match = false;
        //                 break;
        //             }
        //         }
        //         if(match){
        //             return true;
        //         }
        //     }
        // }
        // return false;


        //存在字符串数组strs[],求strs[]数组的最长公共后缀
        String[] strs = new String[3];
        strs[0] = "abcabc";
        strs[1] = "adsabc";
        strs[2] = "xxabc";
        int len = strs.length;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            minLen = Math.min(minLen, strs[i].length());
        }
        //不使用其他方法，求strs[]数组的最长公共后缀
        String res = "";
        for(int i = 0; i < minLen; i++){
            char c = strs[0].charAt(i);
            boolean match = true;
            for(int j = 1; j < len; j++){
                if(strs[j].charAt(i) != c){
                    match = false;
                    break;
                }
            }
            if(match){
                res += c;
            }else{
                break;
            }
        }



    }
}
// @lc code=end

