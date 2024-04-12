/*
 * @lc app=leetcode.cn id=423 lang=java
 *
 * [423] 从英文中重建数字
 *
 * https://leetcode.cn/problems/reconstruct-original-digits-from-english/description/
 *
 * algorithms
 * Medium (60.75%)
 * Likes:    207
 * Dislikes: 0
 * Total Accepted:    41K
 * Total Submissions: 67.5K
 * Testcase Example:  '"owoztneoer"'
 *
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "fviefuro"
 * 输出："45"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 10^5
 * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"]
 * 这些字符之一
 * s 保证是一个符合题目要求的字符串
 * 
 * 
 */

// @lc code=start
class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case 'z': count[0]++; break;
                case 'w': count[2]++; break;
                case 'x': count[6]++; break;
                case 's': count[7]++; break; // 7-6
                case 'g': count[8]++; break;
                case 'u': count[4]++; break;
                case 'f': count[5]++; break; // 5-4
                case 'h': count[3]++; break; // 3-8
                case 'i': count[9]++; break; // 9-8-5-6
                case 'o': count[1]++; break; // 1-0-2-4
            }
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

