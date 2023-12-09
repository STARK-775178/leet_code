/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 *
 * https://leetcode.cn/problems/insert-interval/description/
 *
 * algorithms
 * Medium (42.62%)
 * Likes:    837
 * Dislikes: 0
 * Total Accepted:    181.8K
 * Total Submissions: 426.3K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 示例 3：
 * 
 * 
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * intervals[i].length == 2
 * 0 
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /**
         * Accepted
         * 156/156 cases passed (1 ms)
         * Your runtime beats 96.36 % of java submissions
         * Your memory usage beats 49.55 % of java submissions (42.8 MB)
         */
        int[][] res = new int[intervals.length + 1][2];
        // 用来记录结果集的下标
        int index = 0;
        // 用来遍历intervals数组
        int i = 0;
        // 如果新区间的右边界小于当前区间的左边界，说明新区间在当前区间的左边，直接将当前区间加入结果集
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[index++] = intervals[i++];
        }
        // 如果新区间的左边界大于当前区间的右边界，说明新区间在当前区间的右边，直接将当前区间加入结果集
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // 如果新区间的右边界大于等于当前区间的左边界，说明新区间和当前区间有交集，更新新区间的左边界为当前区间的左边界
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            // 如果新区间的左边界小于等于当前区间的右边界，说明新区间和当前区间有交集，更新新区间的右边界为当前区间的右边界
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // 将更新后的新区间加入结果集
        res[index++] = newInterval;
        // 将剩余的区间加入结果集
        while (i < intervals.length) {
            res[index++] = intervals[i++];
        }
        // 返回结果集去除多余的空间
        return Arrays.copyOf(res, index);
    }
}
// @lc code=end
