/*
 * @lc app=leetcode.cn id=2575 lang=java
 *
 * [2575] 找出字符串的可整除数组
 *
 * https://leetcode.cn/problems/find-the-divisibility-array-of-a-string/description/
 *
 * algorithms
 * Medium (33.57%)
 * Likes:    46
 * Dislikes: 0
 * Total Accepted:    22.2K
 * Total Submissions: 53.9K
 * Testcase Example:  '"998244353"\n3'
 *
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * 
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 * 
 * 
 * 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
 * 否则，div[i] = 0
 * 
 * 
 * 返回 word 的可整除数组。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：word = "998244353", m = 3
 * 输出：[1,1,0,0,0,1,1,0,0]
 * 解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：word = "1010", m = 10
 * 输出：[0,1,0,1]
 * 解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 10^5
 * word.length == n
 * word 由数字 0 到 9 组成
 * 1 <= m <= 10^9
 * 
 * 
 */

// @lc code=start
import java.math.*;
import java.util.*;

class Solution {
    public int[] divisibilityArray(String word, int m) {
        //暴力解法 超时
        // int[] ans = new int[word.length()];

        // for (int i = 0; i < word.length(); i++) {
        //     BigInteger num = new BigInteger(word.substring(0, i + 1));
        //     if (num.mod(BigInteger.valueOf(m)).equals(BigInteger.ZERO)) {
        //         ans[i] = 1;
        //     }
        // }
        // return ans;
        
        //优化
        char[] s = word.toCharArray();

        int[] ans = new int[s.length];

        long x = 0;

        for (int i = 0; i < s.length; i++) {

            x = (x * 10 + (s[i] - '0')) % m;

            if (x == 0) {

                ans[i] = 1;

            }

        }

        return ans;

    }
}
// @lc code=end
