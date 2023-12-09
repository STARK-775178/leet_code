/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (53.03%)
 * Likes:    1129
 * Dislikes: 0
 * Total Accepted:    625.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明：叶子节点是指没有子节点的节点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数的范围在 [0, 10^5] 内
 * -1000 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        /**
         * Accepted
         * 53/53 cases passed (10 ms)
         * Your runtime beats 23.07 % of java submissions
         * Your memory usage beats 5.1 % of java submissions (60.9 MB)
         */
        // 使用深度优先遍历
        if (root == null) {
            return 0;
        }
        // 如果左子树为空，那么最小深度就是右子树的最小深度+1
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        // 如果右子树为空，那么最小深度就是左子树的最小深度+1
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        // 如果左右子树都不为空，那么最小深度就是左右子树的最小深度的较小值+1
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
// @lc code=end
