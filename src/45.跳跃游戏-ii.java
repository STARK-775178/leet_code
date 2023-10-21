/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode.cn/problems/jump-game-ii/description/
 *
 * algorithms
 * Medium (44.86%)
 * Likes:    2314
 * Dislikes: 0
 * Total Accepted:    566.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j]
 * 处:
 * 
 * 
 * 0 <= j <= nums[i] 
 * i + j < n
 * 
 * 
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        // int i = 0;
        // int result = 0;
        // int max = 0;
        // int step = 0;
        // while (i < nums.length - 1) {
        //     // 如果后续没有比当前大的，直接跳到最大的
        //     step = nums[i];
        //     max = nums[i];
        //     // 如果有比当前大的，替换step
        //     for (int j = 1; j <= nums[i]; j++) {
        //         if (i + j >= nums.length - 1) {
        //             return result + 1;
        //         }
        //         if (max <= ((nums[i + j])+j)) {
        //             step = j;
        //             max = nums[i + j];
        //         }
        //     }
        //     i = i + step;
        //     result++;
        // }
        // return result;
        // 贪心算法
        int result = 0;
        int max = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 找到最大的
            max = Math.max(max, nums[i] + i);
            // 如果到达了边界，就更新边界
            if (i == end) {
                end = max;
                result++;
            }
        }
        return result;
    }
}
// @lc code=end
