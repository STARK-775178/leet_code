/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode.cn/problems/word-search/description/
 *
 * algorithms
 * Medium (46.44%)
 * Likes:    1720
 * Dislikes: 0
 * Total Accepted:    468K
 * Total Submissions: 1M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false
 * 。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCCED"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "SEE"
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCB"
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == board.length
 * n = board[i].length
 * 1 
 * 1 
 * board 和 word 仅由大小写英文字母组成
 * 
 * 
 * 
 * 
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 * 
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        /**
         * Accepted
         * 86/86 cases passed (143 ms)
         * Your runtime beats 63.66 % of java submissions
         * Your memory usage beats 47.61 % of java submissions (39.6 MB)
         */
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = dfs(board, visited, i, j, 0, word);
                if (flag)
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, int start, String word) {
        // 如果已经找到了，就不用再找了
        if (start == word.length())
            return true;
        // 如果越界了，就不用再找了
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        // 如果已经访问过了，就不用再找了
        if (visited[i][j])
            return false;
        // 如果不相等，就不用再找了
        if (board[i][j] != word.charAt(start))
            return false;
        // 如果相等，就继续向其他方向进行查找
        visited[i][j] = true;
        // 向四个方向进行查找。如果四个方向都找不到，就不用再找了
        boolean flag = dfs(board, visited, i + 1, j, start + 1, word) || dfs(board, visited, i - 1, j, start + 1, word)
                || dfs(board, visited, i, j + 1, start + 1, word) || dfs(board, visited, i, j - 1, start + 1, word);
        // 回溯
        visited[i][j] = false;
        return flag;
    }
}
// @lc code=end
