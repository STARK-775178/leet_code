/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 *
 * https://leetcode.cn/problems/course-schedule/description/
 *
 * algorithms
 * Medium (53.86%)
 * Likes:    1829
 * Dislikes: 0
 * Total Accepted:    355.6K
 * Total Submissions: 660.2K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi]
 * ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 
 * 
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 
 * 
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 
 * 示例 2：
 * 
 * 
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 * 
 * 
 */

// @lc code=start

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    /**
     * Accepted
     * 52/52 cases passed (3 ms)
     * Your runtime beats 91.46 % of java submissions
     * Your memory usage beats 27.17 % of java submissions (42.9 MB)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // edges代表每个课程的后续课程
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        // 为edges添加后续课程
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;

        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                // 如果在dfs中发现不可行，直接返回
                if (!valid) {
                    return;
                }
                // 如果在dfs中发现已经搜索过，直接返回
            } else if (visited[v] == 1) {
                //valid = false的原因是，如果在dfs中发现已经搜索过，说明有环，不可行
                valid = false;
                return;
            }
        }
        // 0: 未搜索 1: 搜索中 2: 已完成
        visited[u] = 2;
    }

}
// @lc code=end
