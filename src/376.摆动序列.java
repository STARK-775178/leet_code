/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 *
 * https://leetcode.cn/problems/wiggle-subsequence/description/
 *
 * algorithms
 * Medium (46.71%)
 * Likes:    1066
 * Dislikes: 0
 * Total Accepted:    209.2K
 * Total Submissions: 448.2K
 * Testcase Example:  '[1,7,4,9,2,5]'
 *
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列
 * 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * 
 * 
 * 
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * 
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5]
 * 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 
 * 
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * 
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。
 * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,2,3,4,5,6,7,8,9]
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 * 
 * 
 * 进阶：你能否用 O(n) 时间复杂度完成此题?
 * 
 */

// @lc code=start
class Solution {

    public int wiggleMaxLength(int[] nums) {
        /*
         * Accepted
         * 31/31 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 5.04 % of java submissions (39.5 MB)
         */
        // 获取输入数组的长度
        int n = nums.length;

        // 如果长度小于2，表示没有子序列，直接返回长度
        if (n < 2)
            return n;

        // 用于存储递增和递减子序列长度的数组
        int[] up = new int[n];
        int[] down = new int[n];

        // 初始化up和down数组的第一个元素为1
        up[0] = down[0] = 1;

        // 从第二个元素开始遍历输入数组
        for (int i = 1; i < n; i++) {
            // 比较当前元素和前一个元素，以确定趋势
            if (nums[i] > nums[i - 1]) {
                // 如果当前元素大于前一个元素
                // 更新递增子序列的长度, 递增子序列的长度为前一个递增子序列的长度和前一个递减子序列的长度加1的最大值
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                // 递减子序列的长度保持不变
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                // 如果当前元素小于前一个元素
                // 更新递减子序列的长度
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
                // 递增子序列的长度保持不变
                up[i] = up[i - 1];
            } else {
                // 如果当前元素等于前一个元素
                // 递增和递减子序列的长度都保持不变
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }

        // 返回最终递增和递减子序列的最大长度
        return Math.max(up[n - 1], down[n - 1]);
    }

}
// @lc code=end
