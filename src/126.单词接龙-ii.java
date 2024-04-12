/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 *
 * https://leetcode.cn/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (37.13%)
 * Likes:    705
 * Dislikes: 0
 * Total Accepted:    58.3K
 * Total Submissions: 157K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord ->
 * s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * 
 * 
 * 
 * 
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList
 * 中的单词。
 * sk == endWord
 * 
 * 
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord
 * 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk]
 * 的形式返回。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * 解释：存在 2 种最短的转换序列：
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"]
 * 输出：[]
 * 解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= beginWord.length <= 5
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 500
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有单词 互不相同
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 1. 将wordList转换为set
        HashSet<String> wordSet = new HashSet<>(wordList);
        // 2. 如果endWord不在wordSet中，直接返回空列表
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }
        // 3. 将beginWord和endWord加入wordSet
        wordSet.add(beginWord);
        wordSet.add(endWord);
        // 4. 构建图
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        for (String word : wordSet) {
            graph.put(word, new ArrayList<>());
        }
        for (String word : wordSet) {
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (wordSet.contains(newWord)) {
                        graph.get(word).add(newWord);
                    }
                }
            }
        }
        // 5. BFS
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add(beginWord);
        HashMap<String, Integer> distance = new HashMap<>();
        distance.put(beginWord, 0);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (String nextWord : graph.get(word)) {
                if (!distance.containsKey(nextWord)) {
                    distance.put(nextWord, distance.get(word) + 1);
                    queue.add(nextWord);
                }
            }
        }
        // 6. DFS
        List<List<String>> res = new ArrayList<>();
        dfs(beginWord, endWord, graph, distance, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(String beginWord, String endWord, HashMap<String, ArrayList<String>> graph, HashMap<String, Integer> distance, List<String> path, List<List<String>> res) {
        path.add(beginWord);
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
        } else {
            for (String nextWord : graph.get(beginWord)) {
                if (distance.get(nextWord) == distance.get(beginWord) + 1) {
                    dfs(nextWord, endWord, graph, distance, path, res);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    
}
// @lc code=end
