/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 *
 * https://leetcode.cn/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (54.70%)
 * Likes:    564
 * Dislikes: 0
 * Total Accepted:    163.3K
 * Total Submissions: 298.5K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * 
 * 
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 
 * 
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * 
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序
 * 返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 10^5
 * s[i]=='A'、'C'、'G' or 'T'
 * 
 * 
 */

// @lc code=start

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    List<String> res = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    public List<String> findRepeatedDnaSequences(String s) {
        // 方法一，暴力法，超时
        // Time Limit Exceeded
        // 30/31 cases passed (N/A)
        // if (s.length() < 10)
        //     return res;
        // for (int i = 0; i < s.length() - 9; i++) {
        //     String str = s.substring(i, i + 10);
        //     if (temp.contains(str) && !res.contains(str)) {
        //         res.add(str);
        //     }
        //     if (!temp.contains(str)) {
        //         temp.add(str);
        //     }
        // }
        // return res;

        // 方法二，滑动窗口,实际上是暴力法的优化，优化点在于，不需要每次都去判断是否包含，只需要判断是否重复即可
        // Time Limit Exceeded
        // 30/31 cases passed (N/A)
        // int left = 0, right = 10;
        // while (right < s.length()) {
        //     String str = s.substring(left, right);
        //      //判断s的子串是否包含str，如果包含，且res中不包含str，则加入res
        //     if (s.substring(left + 1).contains(str) && !res.contains(str)) {
        //         res.add(str);
        //     }
        //     left++;
        //     right++;
        // }
        // return res;

        // 方法三，滑动窗口+hashset
        // Accepted
        // 31/31 cases passed (15 ms)
        // Your runtime beats 94.84 % of java submissions
        // Your memory usage beats 5 % of java submissions (51.1 MB)
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (!set.add(str)) {
                res.add(str);
            }
        }

        return new ArrayList<>(res);

    }
}
// @lc code=end
