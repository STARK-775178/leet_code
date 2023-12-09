/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 *
 * https://leetcode.cn/problems/gray-code/description/
 *
 * algorithms
 * Medium (75.49%)
 * Likes:    656
 * Dislikes: 0
 * Total Accepted:    123.9K
 * Total Submissions: 164.2K
 * Testcase Example:  '2'
 *
 * n 位格雷码序列 是一个由 2^n 个整数组成的序列，其中：
 * 
 * 每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
 * 第一个整数是 0
 * 一个整数在序列中出现 不超过一次
 * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * 
 * 
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 2
 * 输出：[0,1,3,2]
 * 解释：
 * [0,1,3,2] 的二进制表示是 [00,01,11,10] 。
 * - 00 和 01 有一位不同
 * - 01 和 11 有一位不同
 * - 11 和 10 有一位不同
 * - 10 和 00 有一位不同
 * [0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
 * - 00 和 10 有一位不同
 * - 10 和 11 有一位不同
 * - 11 和 01 有一位不同
 * - 01 和 00 有一位不同
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：[0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 16
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        // 暴力法，在n-1的基础上，分别在前面加0和1
        // Accepted
        // 16/16 cases passed (208 ms)
        // Your runtime beats 5.14 % of java submissions
        // Your memory usage beats 7.18 % of java submissions (52.8 MB)
        List<String> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        list.add("0");
        list.add("1");
        for (int i = 0; i < n - 1; i++) {
            int length = list.size();
            for (int j = 0; j < length; j++) {
                list.set(j, "0" + list.get(j));
            }
            for (int j = length - 1; j >= 0; j--) {
                list.add("1" + list.get(j).substring(1));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            res.add(Integer.parseInt(list.get(i), 2));
        }
        return res;

        // 递归
        // Accepted
        // 16/16 cases passed (7 ms)
        // Your runtime beats 43.09 % of java submissions
        // Your memory usage beats 12.43 % of java submissions (48.4 MB)
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int length = res.size();
            for (int j = length - 1; j >= 0; j--) {
                res.add(res.get(j) | 1 << i);
                // 1 << i 表示1向左移动i位
                // | 表示按位或 按位或的规则是：两个二进制位中只要有一个为1，结果就为1
            }
        }
        return res;

    }
}
// @lc code=end
