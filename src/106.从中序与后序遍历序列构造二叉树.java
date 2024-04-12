/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (72.25%)
 * Likes:    1205
 * Dislikes: 0
 * Total Accepted:    369.4K
 * Total Submissions: 511.4K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder
 * 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder,0,postorder.length-1,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] inorder,int[] postorder,int ps,int pe,int is,int ie){
        //终止条件
        if(ps>pe){
            return null;
        }
        int val = postorder[pe];
        TreeNode root = new TreeNode(val);
        //找到val在中序遍历的位置
        int index = 0;
        for (int i = is; i <= ie; i++) {
            if(inorder[i]==val){
                index = i;
                break;
            }
        }
        int leftSize = index - is;
        //进行递归
        //ps+leftSize-1是左子树的根节点
        root.left = buildTree(inorder, postorder,ps,ps+leftSize-1,is,index-1);
        root.right = buildTree(inorder, postorder,ps+leftSize,pe-1,index+1,ie);
        return root;
    }
}
// @lc code=end

