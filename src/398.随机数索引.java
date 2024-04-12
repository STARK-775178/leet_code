/*
 * @lc app=leetcode.cn id=398 lang=java
 *
 * [398] 随机数索引
 *
 * https://leetcode.cn/problems/random-pick-index/description/
 *
 * algorithms
 * Medium (69.19%)
 * Likes:    274
 * Dislikes: 0
 * Total Accepted:    59.1K
 * Total Submissions: 85.4K
 * Testcase Example:  '["Solution","pick","pick","pick"]\n[[[1,2,3,3,3]],[3],[1],[3]]'
 *
 * 给你一个可能含有 重复元素 的整数数组 nums ，请你随机输出给定的目标数字 target 的索引。你可以假设给定的数字一定存在于数组中。
 * 
 * 实现 Solution 类：
 * 
 * 
 * Solution(int[] nums) 用数组 nums 初始化对象。
 * int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i
 * 。如果存在多个有效的索引，则每个索引的返回概率应当相等。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入
 * ["Solution", "pick", "pick", "pick"]
 * [[[1, 2, 3, 3, 3]], [3], [1], [3]]
 * 输出
 * [null, 4, 0, 2]
 * 
 * 解释
 * Solution solution = new Solution([1, 2, 3, 3, 3]);
 * solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
 * solution.pick(1); // 返回 0 。因为只有 nums[0] 等于 1 。
 * solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * target 是 nums 中的一个整数
 * 最多调用 pick 函数 10^4 次
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class Solution {
    /**
     * Accepted
     * 15/15 cases passed (79 ms)
     * Your runtime beats 47.08 % of java submissions
     * Your memory usage beats 20.17 % of java submissions (54.7 MB)
     */
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            List<Integer> list = map.get(nums[i]);
            list.add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int rand = new Random().nextInt(list.size());
        return list.get(rand);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end
