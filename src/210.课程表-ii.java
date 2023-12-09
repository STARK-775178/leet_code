/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 *
 * https://leetcode.cn/problems/course-schedule-ii/description/
 *
 * algorithms
 * Medium (57.74%)
 * Likes:    902
 * Dislikes: 0
 * Total Accepted:    211.9K
 * Total Submissions: 367K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中
 * prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * 
 * 
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 
 * 
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 
 * 示例 3：
 * 
 * 
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    /**
     * Accepted
     * 45/45 cases passed (4 ms)
     * Your runtime beats 68.36 % of java submissions
     * Your memory usage beats 23.22 % of java submissions (44 MB)
     */
    Stack<Integer> stack = new Stack<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] visited = new int[numCourses];
        List<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(i, new ArrayList<Integer>());
        }
        for (int[] prerequisites2 : prerequisites) {
            edges.get(prerequisites2[1]).add(prerequisites2[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, edges);
            }
        }

        if (stack.size() != numCourses) {
            return new int[0];
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private void dfs(int i, int visited[], List<ArrayList<Integer>> edges) {
        visited[i] = 1;

        List<Integer> list = edges.get(i);
        for (int j = 0; j < list.size(); j++) {
            if (visited[list.get(j)] == 0) {
                dfs(list.get(j), visited, edges);
            } else if (visited[list.get(j)] == 1) {
                return;
            }
        }
        visited[i] = 2;
        stack.push(i);
    }
}
// @lc code=end
