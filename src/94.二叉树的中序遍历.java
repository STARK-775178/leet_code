/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Easy (76.31%)
 * Likes:    1973
 * Dislikes: 0
 * Total Accepted:    1.3M
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
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
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start

import java.util.List;

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
    List<Integer> ret = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        /**
         * 递归法中序遍历
         * Accepted
         * 70/70 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 70.13 % of java submissions (39.5 MB)
         */
        // if (root != null) {
        // inorderTraversal(root.left);
        // ret.add(root.val);
        // inorderTraversal(root.right);
        // }
        // return ret;

        // Accepted
        // 迭代法中序遍历
        // 70/70 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 5.08 % of java submissions (40.1 MB)
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            // 先遍历左子树
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 左子树遍历完毕，开始遍历右子树
            cur = stack.pop();
            ret.add(cur.val);
            cur = cur.right;
        }
        return ret;
    }
}
// @lc code=end
