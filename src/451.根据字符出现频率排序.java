/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 *
 * https://leetcode.cn/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (72.08%)
 * Likes:    505
 * Dislikes: 0
 * Total Accepted:    133.4K
 * Total Submissions: 185K
 * Testcase Example:  '"tree"'
 *
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * 
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= s.length <= 5 * 10^5
 * s 由大小写英文字母和数字组成
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        /**
         * Accepted
         * 33/33 cases passed (26 ms)
         * Your runtime beats 12.99 % of java submissions
         * Your memory usage beats 7.93 % of java submissions (44.4 MB)
         */
        // hash表
        // 统计每个字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        // 根据value排序并返回一个String
        return map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).map(e -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
            return sb.toString();
        }).collect(Collectors.joining());




    }
}
// @lc code=end
