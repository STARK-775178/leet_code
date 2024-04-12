/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (71.56%)
 * Likes:    2266
 * Dislikes: 0
 * Total Accepted:    625.5K
 * Total Submissions: 874K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder
 * 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder,0,preorder.length-1,0,preorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder,int ps,int pe,int is,int ie){
        if(ps>pe){
            return null;
        }
        int val = preorder[ps];
        TreeNode root = new TreeNode(val);
        //找到val在中序遍历的index
        int index = 0;
        for (int i = is; i <= ie; i++) {
            if(inorder[i]==val){
                index = i;
                break;
            }
        }
        int leftSize = index-is;
        root.left = buildTree(preorder, inorder,ps+1,ps+leftSize,is,index-1);
        //ps+leftSize+1是右子树的根节点
        root.right = buildTree(preorder, inorder,ps+leftSize+1,pe,index+1,ie);
        return root;
    }
}
// @lc code=end

