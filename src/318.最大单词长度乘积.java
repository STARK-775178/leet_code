/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 *
 * https://leetcode.cn/problems/maximum-product-of-word-lengths/description/
 *
 * algorithms
 * Medium (72.11%)
 * Likes:    507
 * Dislikes: 0
 * Total Accepted:    92.2K
 * Total Submissions: 127.9K
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j])
 * 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出：16 
 * 解释：这两个单词为 "abcw", "xtfn"。
 * 
 * 示例 2：
 * 
 * 
 * 输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出：4 
 * 解释：这两个单词为 "ab", "cd"。
 * 
 * 示例 3：
 * 
 * 
 * 输入：words = ["a","aa","aaa","aaaa"]
 * 输出：0 
 * 解释：不存在这样的两个单词。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 * 
 * 
 */

// @lc code=start

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxProduct(String[] words) {
        int res = 0;

        // 1 暴力法
        /**
         * Accepted
         * 168/168 cases passed (2164 ms)
         * Your runtime beats 5.01 % of java submissions
         * Your memory usage beats 6.83 % of java submissions (45 MB)
        //  */
        // for (int i = 0; i < words.length; i++) {
        //     String s1 = words[i];
        //     for (int j = i + 1; j < words.length; j++) {
        //         String s2 = words[j];
        //         if (isUnique(s1, s2)) {
        //             res = Math.max(res, s1.length() * s2.length());
        //         }
        //     }
        // }
        // return res;


        // 2 使用排序并剪枝
        /**
         * Accepted
           168/168 cases passed (218 ms)
           Your runtime beats 11.96 % of java submissions
           Your memory usage beats 39.83 % of java submissions (43.3 MB)
         */
        //从大到小排序
        // Arrays.sort(words, (a, b) -> b.length() - a.length());
        // for (int i = 0; i < words.length; i++) {
        //     String s1 = words[i];
        //     for (int j = i + 1; j < words.length; j++) {
        //         String s2 = words[j];
        //         if (s1.length() * s2.length() <= res) {
        //             break;
        //         }
        //         if (isUnique(s1, s2)) {
        //             res = Math.max(res, s1.length() * s2.length());
        //         }
        //     }
        // }

        // return res;
        
        // 3 使用位运算
        /**
         * Accepted
           168/168 cases passed (13 ms)
            Your runtime beats 48.84 % of java submissions
            Your memory usage beats 8.97 % of java submissions (44.6 MB)
         */
        int[] masks = new int[words.length];
        int[] lens = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            masks[i] = mask;
            lens[i] = words[i].length();
        }
        for (int i = 0; i < words.length; i++) {
            int mask1 = masks[i];
            int len1 = lens[i];
            for (int j = i + 1; j < words.length; j++) {
                int mask2 = masks[j];
                int len2 = lens[j];
                if ((mask1 & mask2) == 0) {
                    res = Math.max(res, len1 * len2);
                }
            }
        }
        return res;


    }

    private boolean isUnique(String s1, String s2) {
        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (arr[s2.charAt(i) - 'a'] > 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
