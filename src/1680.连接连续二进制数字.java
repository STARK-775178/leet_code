/*
 * @lc app=leetcode.cn id=1680 lang=java
 *
 * [1680] 连接连续二进制数字
 *
 * https://leetcode.cn/problems/concatenation-of-consecutive-binary-numbers/description/
 *
 * algorithms
 * Medium (50.80%)
 * Likes:    48
 * Dislikes: 0
 * Total Accepted:    8.8K
 * Total Submissions: 17.3K
 * Testcase Example:  '1'
 *
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 10^9 + 7 取余的结果。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 1
 * 输出：1
 * 解释：二进制的 "1" 对应着十进制的 1 。
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 3
 * 输出：27
 * 解释：二进制下，1，2 和 3 分别对应 "1" ，"10" 和 "11" 。
 * 将它们依次连接，我们得到 "11011" ，对应着十进制的 27 。
 * 
 * 
 * 示例 3：
 * 
 * 输入：n = 12
 * 输出：505379714
 * 解释：连接结果为 "1101110010111011110001001101010111100" 。
 * 对应的十进制数字为 118505380540 。
 * 对 10^9 + 7 取余后，结果为 505379714 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 10^5
 * 
 * 
 */

// @lc code=start

import java.math.BigDecimal;

class Solution {
    public int concatenatedBinary(int n) {
        //方法一：直接计算
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < n; i++) {
        //     sb.append(Integer.toBinaryString(i+1));
        //     // sb.append();
        // }
        // //将sb二进制字符串转换为十进制
        // BigDecimal res = new BigDecimal(0);
        // for (int i = 0; i < sb.length(); i++) {
        //     res = res.multiply(new BigDecimal(2)).add(new BigDecimal(sb.charAt(i) - '0'));
        // }
        // return res.remainder(new BigDecimal(1000000007)).intValue();
        
        //方法二：位运算
        int MOD = 1000000007;
        int length = 0;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            //判断i是否是2的幂次方  举例 当i=8时 二进制为1000  i-1=7 二进制为0111  两者相与为0 说明i是2的幂次方
            //当i=9时 二进制为1001  i-1=8 二进制为1000  两者相与不为0 说明i不是2的幂次方
            //左移时，每次遇到2的幂次方，length+1
            if ((i & (i - 1)) == 0) {
                length++;
            }
            res = ((res << length) + i) % MOD;
        }
        return (int)res;
    }
}
// @lc code=end

