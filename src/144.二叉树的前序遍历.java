/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (71.38%)
 * Likes:    1179
 * Dislikes: 0
 * Total Accepted:    963.1K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 100] 内
 * -100 
 * 
 * 
 * 
 * 
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start

import java.util.List;
import java.util.Stack;

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

    List<Integer> res = new ArrayList();

    public List<Integer> preorderTraversal(TreeNode root) {
        /**
         * 递归法
         * Accepted
         * 70/70 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 72.36 % of java submissions (39.5 MB)
         */
        // preOrder(root, res);
        // return res;
        /**
         * 迭代法
         * Accepted
         * 70/70 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 97.08 % of java submissions (39.3 MB)
         */

        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return res;

    }

    private void preOrder(TreeNode root, List res) {
        if (root != null) {
            res.add(root.val);
            preOrder(root.left, res);
            preOrder(root.right, res);
        }
    }

}
// @lc code=end
