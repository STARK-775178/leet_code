/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode.cn/problems/next-permutation/description/
 *
 * algorithms
 * Medium (38.69%)
 * Likes:    2380
 * Dislikes: 0
 * Total Accepted:    473.1K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3]'
 *
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 
 * 
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 
 * 
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列
 * 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 
 * 
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 
 * 
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 
 * 必须 原地 修改，只允许使用额外常数空间。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int min = Integer.MAX_VALUE;
                int cur = nums[i - 1];
                // int index = i;
                // 找到i-1且大于i-1的数后面最小的数
                for (int j = i; j < nums.length; j++) {
                    if(nums[j] > cur){
                        // if(min>nums[j]){
                        //     min = nums[j];
                            // index = j;
                        // }
                        min = Math.min(min, nums[j]);
                    }
                }
                nums[i - 1] = min;
                // 交换i-1和最小的数
                // nums[index] = cur;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == min) {
                        nums[j] = cur;
                        break;
                    }
                }
                // i后面的数进行从小到大排序
                Arrays.sort(nums, i, nums.length);
                return;
            }
        }
        // 循环完成仍没有交换，手动交换为最小排列
        Arrays.sort(nums);
    }
}
// @lc code=end
