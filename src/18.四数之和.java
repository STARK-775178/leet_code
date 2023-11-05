/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode.cn/problems/4sum/description/
 *
 * algorithms
 * Medium (36.72%)
 * Likes:    1780
 * Dislikes: 0
 * Total Accepted:    520.4K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a],
 * nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 
 * 
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * 
 * 你可以按 任意顺序 返回答案 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        /**
         * Accepted
         * 294/294 cases passed (76 ms)
         * Your runtime beats 6.63 % of java submissions
         * Your memory usage beats 8.23 % of java submissions (43.3 MB)
         */
        //两个for循环加一个双指针
        Arrays.sort(nums);
        int left = 0;
        int leftNext = 0;
        int right = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                leftNext = j + 1;
                right = nums.length - 1;
                while (leftNext < right) {
                    if ((long) nums[leftNext] + nums[j] + nums[right] + nums[i] - target > 0) {
                        right--;
                    } else if ((long) nums[leftNext] + nums[j] + nums[right] + nums[i] - target < 0) {
                        leftNext++;
                    } else if ((long) nums[leftNext] + nums[j] + nums[right] + nums[i] - target == 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(nums[i]);
                        arrayList.add(nums[leftNext]);
                        arrayList.add(nums[right]);
                        arrayList.add(nums[j]);
                        if (!list.contains(arrayList)) {
                            list.add(arrayList);
                        }
                        right--;
                        leftNext++;
                    }

                }
            }
        }
        return list;

    }
}
// @lc code=end
