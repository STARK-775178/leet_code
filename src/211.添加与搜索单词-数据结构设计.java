/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 *
 * https://leetcode.cn/problems/design-add-and-search-words-data-structure/description/
 *
 * algorithms
 * Medium (49.87%)
 * Likes:    557
 * Dislikes: 0
 * Total Accepted:    83.6K
 * Total Submissions: 167.7K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n' +
  '[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 
 * 实现词典类 WordDictionary ：
 * 
 * 
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些
 * '.' ，每个 . 都可以表示任何一个字母。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入：
 * 
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * 
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // 返回 False
 * wordDictionary.search("bad"); // 返回 True
 * wordDictionary.search(".ad"); // 返回 True
 * wordDictionary.search("b.."); // 返回 True
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= word.length <= 25
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 10^4 次 addWord 和 search
 * 
 * 
 */

// @lc code=start

import java.util.*;




class WordDictionary {
    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        Trie temp = this.trie;       
        return dfs(temp,0,word);
    }
    public boolean dfs(Trie trie,int index,String word){
        if(index == word.length()){
            return trie.isEnd;
        }
        char ch = word.charAt(index);
        if(ch == '.'){
            for (Trie children : trie.children) {
                if(children != null && dfs(children, index+1, word)){
                    return true;
                }
            }
        }else{
            if(trie.children[ch-'a'] != null){
                return dfs(trie.children[ch-'a'], index+1, word);
            }
        }
        return false;
    }
    // Map<Integer, List<String>> map;

    // public WordDictionary() {
    // map = new HashMap<>();
    // }

    // public void addWord(String word) {
    // map.put(word.length(), map.getOrDefault(word.length(), new
    // ArrayList<String>()));
    // map.get(word.length()).add(word);
    // }

    // public boolean search(String word) {
    // if (!map.containsKey(word.length())) {
    // return false;
    // }
    // List<String> list = map.get(word.length());
    // for (int i = 0; i < list.size(); i++) {
    // if (isEqual(list.get(i), word)) {
    // return true;
    // }
    // }
    // return false;
    // }

    // public boolean isEqual(String string, String word) {

    // for (int i = 0; i < word.length(); i++) {
    // if (word.charAt(i) == '.' || string.charAt(i) == word.charAt(i)) {
    // if (i == word.length() - 1) {
    // return true;
    // }
    // continue;
    // }
    // if (string.charAt(i) != word.charAt(i)) {
    // break;
    // }
    // }
    // return false;

    // }

    class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String word) {
            Trie temp = this;
            for (int i = 0; i < word.length(); i++) {
                int index = (word.charAt(i) - 'a');
                // 判断是否有第i个开头
                if (temp.children[index] == null) {
                    Trie trie = new Trie();
                    temp.children[index] = trie;
                    temp = trie;
                } else {
                    temp = temp.children[index];
                }
            }
            temp.isEnd = true;
        }

        public boolean search(String word) {
            Trie temp = this;
            for (int i = 0; i < word.length(); i++) {
                int index = (word.charAt(i) - 'a');
                if (temp.children[index] == null) {
                    return false;
                } else {
                    temp = temp.children[index];
                    if (i == word.length() - 1) {
                        if (temp.isEnd == true) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            Trie temp = this;
            for (int i = 0; i < prefix.length(); i++) {
                int index = (prefix.charAt(i) - 'a');
                if (temp.children[index] == null) {
                    return false;
                } else {
                    temp = temp.children[index];
                }
            }
            return true;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end
