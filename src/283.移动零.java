/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode.cn/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (63.61%)
 * Likes:    2227
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 1.9M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [0]
 * 输出: [0]
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 * 
 * 
 * 进阶：你能尽量减少完成的操作次数吗？
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        /**
         * Accepted
         * 74/74 cases passed (1 ms)
         * Your runtime beats 99.97 % of java submissions
         * Your memory usage beats 56.16 % of java submissions (44 MB)
         */
        // 记录0的个数
        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        // //如果是0，count++
        // if (nums[i] == 0) {
        // count++;
        // //如果不是0，将当前元素向前移动count个位置
        // } else {
        // nums[i - count] = nums[i];
        // }

        // }
        // for (int i = nums.length - count; i < nums.length; i++) {
        // nums[i] = 0;
        // }

        // 双指针法
        /**
         * Accepted
         * 74/74 cases passed (68 ms)
         * Your runtime beats 6.09 % of java submissions
         * Your memory usage beats 16.73 % of java submissions (44.1 MB)
         */
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] == 0) {
                for (int i = left; i < right; i++) {
                    nums[i] = nums[i + 1];
                }
                nums[right] = 0;
                right--;
            } else {
                left++;
            }
        }
    }
}
// @lc code=end
