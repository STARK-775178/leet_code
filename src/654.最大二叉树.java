/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 *
 * https://leetcode.cn/problems/maximum-binary-tree/description/
 *
 * algorithms
 * Medium (82.15%)
 * Likes:    770
 * Dislikes: 0
 * Total Accepted:    236.7K
 * Total Submissions: 288.1K
 * Testcase Example:  '[3,2,1,6,0,5]'
 *
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * 
 * 
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 
 * 
 * 返回 nums 构建的 最大二叉树 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * ⁠   - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * ⁠       - 空数组，无子节点。
 * ⁠       - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * ⁠           - 空数组，无子节点。
 * ⁠           - 只有一个元素，所以子节点是一个值为 1 的节点。
 * ⁠   - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * ⁠       - 只有一个元素，所以子节点是一个值为 0 的节点。
 * ⁠       - 空数组，无子节点。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 找到最大值及其索引
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        // 分割数组
        int[] left = Arrays.copyOfRange(nums, 0, index);
        int[] right = Arrays.copyOfRange(nums, index + 1, nums.length);
        // 创建根节点
        TreeNode root = new TreeNode(max,null,null);

        createTree(root, left, right);
        return root;

    }

    private void createTree(TreeNode root, int[] left_nums, int[] right_nums) {
        if (left_nums.length == 0) {
            root.left = null;
        } else {
            // 分割数组
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (int i = 0; i < left_nums.length; i++) {
                if (left_nums[i] > max) {
                    max = left_nums[i];
                    index = i;
                }
            }
            // 分割数组
            int[] n_left = Arrays.copyOfRange(left_nums, 0, index);
            int[] n_right = Arrays.copyOfRange(left_nums, index + 1, left_nums.length);
            // 创建新节点
            TreeNode maxNode = new TreeNode(max,null,null);
            root.left = maxNode;
            createTree(maxNode, n_left, n_right);
        }
        if (right_nums.length == 0) {
            root.right = null;
        } else {
            // 分割数组
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (int i = 0; i < right_nums.length; i++) {
                if (right_nums[i] > max) {
                    max = right_nums[i];
                    index = i;
                }
            }
            // 分割数组
            int[] n_left = Arrays.copyOfRange(right_nums, 0, index);
            int[] n_right = Arrays.copyOfRange(right_nums, index + 1, right_nums.length);
            // 创建新节点
            TreeNode maxNode = new TreeNode(max,null,null);
            root.right = maxNode;
            createTree(maxNode, n_left, n_right);
        }
    }

}
// @lc code=end
