/*
 * @lc app=leetcode.cn id=2653 lang=java
 *
 * [2653] 滑动子数组的美丽值
 *
 * https://leetcode.cn/problems/sliding-subarray-beauty/description/
 *
 * algorithms
 * Medium (35.85%)
 * Likes:    41
 * Dislikes: 0
 * Total Accepted:    5.5K
 * Total Submissions: 15.4K
 * Testcase Example:  '[1,-1,-3,-2,3]\n3\n2'
 *
 * 给你一个长度为 n 的整数数组 nums ，请你求出每个长度为 k 的子数组的 美丽值 。
 * 
 * 一个子数组的 美丽值 定义为：如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数，否则美丽值为 0 。
 * 
 * 请你返回一个包含 n - k + 1 个整数的数组，依次 表示数组中从第一个下标开始，每个长度为 k 的子数组的 美丽值 。
 * 
 * 
 * 
 * 子数组指的是数组中一段连续 非空 的元素序列。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,-1,-3,-2,3], k = 3, x = 2
 * 输出：[-1,-2,-2]
 * 解释：总共有 3 个 k = 3 的子数组。
 * 第一个子数组是 [1, -1, -3] ，第二小的数是负数 -1 。
 * 第二个子数组是 [-1, -3, -2] ，第二小的数是负数 -2 。
 * 第三个子数组是 [-3, -2, 3] ，第二小的数是负数 -2 。
 * 
 * 示例 2：
 * 
 * 输入：nums = [-1,-2,-3,-4,-5], k = 2, x = 2
 * 输出：[-1,-2,-3,-4]
 * 解释：总共有 4 个 k = 2 的子数组。
 * [-1, -2] 中第二小的数是负数 -1 。
 * [-2, -3] 中第二小的数是负数 -2 。
 * [-3, -4] 中第二小的数是负数 -3 。
 * [-4, -5] 中第二小的数是负数 -4 。
 * 
 * 示例 3：
 * 
 * 输入：nums = [-3,1,2,-3,0,-3], k = 2, x = 1
 * 输出：[-3,0,-3,-3,-3]
 * 解释：总共有 5 个 k = 2 的子数组。
 * [-3, 1] 中最小的数是负数 -3 。
 * [1, 2] 中最小的数不是负数，所以美丽值为 0 。
 * [2, -3] 中最小的数是负数 -3 。
 * [-3, 0] 中最小的数是负数 -3 。
 * [0, -3] 中最小的数是负数 -3 。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == nums.length 
 * 1 <= n <= 10^5
 * 1 <= k <= n
 * 1 <= x <= k 
 * -50 <= nums[i] <= 50 
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        // 超时
        // int[] arrays = new int[nums.length - k + 1];
        // // 滑动窗口
        // for (int i = 0; i < nums.length - k + 1; i++) {
        // PriorityQueue<Integer> queue = new PriorityQueue<>();
        // for (int j = i; j < i + k; j++) {
        // if (nums[j] < 0) {
        // queue.add(nums[j]);
        // }
        // }
        // if (queue.size() < x) {
        // arrays[i] = 0;
        // continue;
        // }
        // int count = 0;
        // while (count < x - 1) {
        // queue.poll();
        // count++;
        // }
        // arrays[i] = queue.poll();

        // }
        // return arrays;
        /**
         * Accepted
         * 717/717 cases passed (1763 ms)
         * Your runtime beats 5.14 % of java submissions
         * Your memory usage beats 89.71 % of java submissions (58.7 MB)
         */
        // int[] result = new int[nums.length - k + 1];// 存放返回结果

        // Map<Integer, Integer> nmap = new TreeMap<>();// key 数字 ： value 个数

        // for (int i = 0; i < nums.length; i++) { // 遍历每一个数字

        // if (!nmap.containsKey(nums[i])) {// 集合中不包含这个数字

        // nmap.put(nums[i], 1);

        // } else {

        // nmap.put(nums[i], nmap.get(nums[i]) + 1);// 集合中包含这个数字,对其 value + 1

        // }

        // if (i >= k - 1) {

        // int j = 0;

        // for (int key : nmap.keySet()) {

        // j += nmap.get(key);

        // if (j >= x) {

        // result[i - k + 1] = key < 0 ? key : 0;

        // break;

        // }

        // }

        // if (nmap.get(nums[i - k + 1]) == 1) {// 集合中包含 1 个这个数字

        // nmap.remove(nums[i - k + 1]);

        // } else {

        // nmap.put(nums[i - k + 1], nmap.get(nums[i - k + 1]) - 1);// 集合中包含多个这个数字,对其
        // value - 1

        // }

        // }

        // }

        // return result;
        /**
         * Accepted
         * 717/717 cases passed (51 ms)
         * Your runtime beats 31.43 % of java submissions
         * Your memory usage beats 73.14 % of java submissions (58.9 MB)
         */
        //维护count数组，count[i]表示数字i出现的次数
        int[] result = new int[nums.length - k + 1];// 存放返回结果
        int[] count = new int[101];// 数字范围是 -50 ~ 50,共计 101 个
        for (int i = 0; i < nums.length; i++) { // 遍历每一个数字
            count[nums[i] + 50]++;// 存入一个数
            if (i >= k - 1) {// 存入了 k 个数
                for (int j = 0, c = 0; j < 50 && c < x; j++) {
                    c += count[j]; // 记录到达第几小
                    if (c >= x) { // 到达第 x 小
                        result[i - k + 1] = j - 50;// j 是数组下标，实际值需要 -50
                    }
                }
                count[nums[i - k + 1] + 50]--; // 下一步后面将增加一个数，此时去掉前面的一个数
            }
        }
        return result;
    }

}
// @lc code=end
