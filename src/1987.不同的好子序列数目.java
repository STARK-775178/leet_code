/*
 * @lc app=leetcode.cn id=1987 lang=java
 *
 * [1987] 不同的好子序列数目
 *
 * https://leetcode.cn/problems/number-of-unique-good-subsequences/description/
 *
 * algorithms
 * Hard (51.16%)
 * Likes:    56
 * Dislikes: 0
 * Total Accepted:    2.7K
 * Total Submissions: 5.3K
 * Testcase Example:  '"001"'
 *
 * 给你一个二进制字符串 binary 。 binary 的一个 子序列 如果是 非空 的且没有 前导 0 （除非数字是 "0" 本身），那么它就是一个 好
 * 的子序列。
 * 
 * 请你找到 binary 不同好子序列 的数目。
 * 
 * 
 * 比方说，如果 binary = "001" ，那么所有 好 子序列为 ["0", "0", "1"] ，所以 不同 的好子序列为 "0" 和 "1" 。
 * 注意，子序列 "00" ，"01" 和 "001" 不是好的，因为它们有前导 0 。
 * 
 * 
 * 请你返回 binary 中 不同好子序列 的数目。由于答案可能很大，请将它对 10^9 + 7 取余 后返回。
 * 
 * 一个 子序列 指的是从原数组中删除若干个（可以一个也不删除）元素后，不改变剩余元素顺序得到的序列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：binary = "001"
 * 输出：2
 * 解释：好的二进制子序列为 ["0", "0", "1"] 。
 * 不同的好子序列为 "0" 和 "1" 。
 * 
 * 
 * 示例 2：
 * 
 * 输入：binary = "11"
 * 输出：2
 * 解释：好的二进制子序列为 ["1", "1", "11"] 。
 * 不同的好子序列为 "1" 和 "11" 。
 * 
 * 示例 3：
 * 
 * 输入：binary = "101"
 * 输出：5
 * 解释：好的二进制子序列为 ["1", "0", "1", "10", "11", "101"] 。
 * 不同的好子序列为 "0" ，"1" ，"10" ，"11" 和 "101" 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= binary.length <= 10^5
 * binary 只含有 '0' 和 '1' 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {

    }
}
// @lc code=end

