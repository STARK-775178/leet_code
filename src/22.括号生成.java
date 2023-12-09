/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.50%)
 * Likes:    3455
 * Dislikes: 0
 * Total Accepted:    769.3K
 * Total Submissions: 992.5K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：["()"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */

// @lc code=start

import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        // List<String> list = new ArrayList<String>();

        // // 生成所有可能的括号组合
        // generateAll(new char[2 * n], 0, list);

        // return list;
        // }

        // private void generateAll(char[] current, int pos, List<String> list) {
        // if (pos == current.length) {
        // if (valid(current)) {
        // list.add(new String(current));
        // }
        // } else {
        // current[pos] = '(';
        // generateAll(current, pos + 1, list);
        // current[pos] = ')';
        // generateAll(current, pos + 1, list);
        // }
        // }

        // private boolean valid(char[] current) {
        // int balance = 0;
        // for (char c : current) {
        // if (c == '(') {
        // balance++;
        // } else {
        // balance--;
        // }
        // if (balance < 0) {
        // return false;
        // }
        // }

        // return balance == 0;
        // }
        /**
         * Accepted
         * 8/8 cases passed (2 ms)
         * Your runtime beats 25 % of java submissions
         * Your memory usage beats 29.97 % of java submissions (42.2 MB)
         */
        List<String> list = new ArrayList<String>();
        dfs("", n, list);
        return list;
    }

    private void dfs(String cur, int n, List<String> list) {
        if (cur.length() == 2 * n) {
            list.add(cur);
            return;
        }

        int left = 0, right = 0;
        for (char c : cur.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }
        }

        if (left < n) {
            dfs(cur + "(", n, list);
        }

        if (right < left) {
            dfs(cur + ")", n, list);
        }

    }

}
// @lc code=end
