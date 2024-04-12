/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (71.92%)
 * Likes:    1607
 * Dislikes: 0
 * Total Accepted:    308.8K
 * Total Submissions: 429.4K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Trie（发音类似 "try"）或者说 前缀树
 * 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 
 * 请你实现 Trie 类：
 * 
 * 
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回
 * false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true
 * ；否则，返回 false 。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * 
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 10^4 次
 * 
 * 
 */

// @lc code=start
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
            int index = (word.charAt(i)-'a');
            //判断是否有第i个开头
            if(temp.children[index] == null){
                Trie trie = new Trie();
                temp.children[index]  = trie;
                temp = trie;
            }else{
                temp = temp.children[index];
            }
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++) {
            int index = (word.charAt(i)-'a');
            if(temp.children[index]==null){
                return false;
            }else{                
                temp = temp.children[index];
                if(i == word.length()-1){
                    if(temp.isEnd == true){
                        return true;
                    }else{
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
            int index = (prefix.charAt(i)-'a');
            if(temp.children[index] == null){
                return false;
            }else{                
                temp = temp.children[index];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

