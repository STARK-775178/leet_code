/*
 * @lc app=leetcode.cn id=1347 lang=java
 *
 * [1347] 制造字母异位词的最小步骤数
 *
 * https://leetcode.cn/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/
 *
 * algorithms
 * Medium (76.59%)
 * Likes:    49
 * Dislikes: 0
 * Total Accepted:    13.1K
 * Total Submissions: 17.2K
 * Testcase Example:  '"bab"\n"aba"'
 *
 * 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
 * 
 * 返回使 t 成为 s 的字母异位词的最小步骤数。
 * 
 * 字母异位词 指字母相同，但排列不同（也可能相同）的字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输出：s = "bab", t = "aba"
 * 输出：1
 * 提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
 * 
 * 
 * 示例 2：
 * 
 * 输出：s = "leetcode", t = "practice"
 * 输出：5
 * 提示：用合适的字符替换 t 中的 'p', 'r', 'a', 'i' 和 'c'，使 t 变成 s 的字母异位词。
 * 
 * 
 * 示例 3：
 * 
 * 输出：s = "anagram", t = "mangaar"
 * 输出：0
 * 提示："anagram" 和 "mangaar" 本身就是一组字母异位词。 
 * 
 * 
 * 示例 4：
 * 
 * 输出：s = "xxyyzz", t = "xxyyzz"
 * 输出：0
 * 
 * 
 * 示例 5：
 * 
 * 输出：s = " ", t = "family"
 * 输出：4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s 和 t 只包含小写英文字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minSteps(String s, String t) {
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i = 0; i < s.length(); i++){
        //     map.put((int)s.charAt(i),map.getOrDefault((int)s.charAt(i),0)+1);
        //     map.put((int)t.charAt(i),map.getOrDefault((int)t.charAt(i),0)-1);
        // }
        // int res = 0;
        // for(int key : map.keySet()){
        //     res += Math.abs(map.get(key));
        // }
        // if(res%2 == 0){
        //     return res/2;
        // }else{
        //     return (res+1)/2;
        // }
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        int res = 0;
        for(int i = 0; i < 26; i++){
            if(arr[i] > 0){
                res += arr[i];
            }
        }
        return res;

    }
}
// @lc code=end

