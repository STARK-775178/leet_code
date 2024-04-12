/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * https://leetcode.cn/problems/word-ladder/description/
 *
 * algorithms
 * Hard (48.55%)
 * Likes:    1348
 * Dislikes: 0
 * Total Accepted:    206.9K
 * Total Submissions: 426K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 ->
 * s2 -> ... -> sk：
 * 
 * 
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 
 * 
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列
 * 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. 将wordList转换为set
        HashSet<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        List<String> visited = new ArrayList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        // 获取所有可以替换的char
        List<Character> charList = new ArrayList<>();
        // char[] beginChars = beginWord.toCharArray();
        // for (int i = 0; i < beginChars.length; i++) {
        // if (!charList.contains(beginChars[i])) {
        // charList.add(beginChars[i]);
        // }
        // }
        // for (String wordList2 : wordList) {
        // char[] charArray = wordList2.toCharArray();
        // for (int i = 0; i < charArray.length; i++) {
        // if (!charList.contains(charArray[i])) {
        // charList.add(charArray[i]);
        // }
        // }
        // }
        for (int i = 'a'; i <= 'z'; i++) {
            charList.add((char) i);
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return step+1;
                }
                char[] charArray = word.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    char oldChar = word.charAt(j);
                    // 对每一个字母进行替换
                    for (int j2 = 0; j2 < charList.size(); j2++) {
                        charArray[j] = charList.get(j2);
                        String newString = new String(charArray);
                        if (wordSet.contains(newString) && !visited.contains(newString)) {
                            visited.add(newString);
                            queue.offer(newString);
                        }
                        charArray[j] = oldChar;
                    }

                }

            }
            step++;
        }
        return 0;
    }
}
// @lc code=end
