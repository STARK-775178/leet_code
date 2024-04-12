/*
* @lc app=leetcode.cn id=166 lang=java
*
* [166] 分数到小数
*
* https://leetcode.cn/problems/fraction-to-recurring-decimal/description/
*
* algorithms
* Medium (33.45%)
* Likes:    483
* Dislikes: 0
* Total Accepted:    67.4K
* Total Submissions: 201.3K
* Testcase Example:  '1\n2'
*
* 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
* 
* 如果小数部分为循环小数，则将循环的部分括在括号内。
* 
* 如果存在多个答案，只需返回 任意一个 。
* 
* 对于所有给定的输入，保证 答案字符串的长度小于 10^4 。
* 
* 
* 
* 示例 1：
* 
* 
* 输入：numerator = 1, denominator = 2
* 输出："0.5"
* 
* 
* 示例 2：
* 
* 
* 输入：numerator = 2, denominator = 1
* 输出："2"
* 
* 
* 示例 3：
* 
* 
* 输入：numerator = 4, denominator = 333
* 输出："0.(012)"
* 
* 
* 
* 
* 提示：
* 
* 
* -2^31 <= numerator, denominator <= 2^31 - 1
* denominator != 0
* 
* 
*/

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();

        Long remainder;

        if(numerator==0){
            return "0";
        }
        if(numerator==denominator){
            return "1";
        }

        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }

        long num = Math.abs(Long.valueOf(numerator));
        long den = Math.abs(Long.valueOf(denominator));
        
        sb.append(String.valueOf(num/den));

        remainder = num%den;

        if(remainder==0){
            return sb.toString();
        }


        sb.append(".");

        Map<Long,Integer> map = new HashMap<>();
        
        while(remainder!=0){
            if(map.containsKey(remainder)){
                sb.insert(map.get(remainder),"(");
                sb.append(")");
                break;
            }
            map.put(remainder,sb.length());
            remainder*=10;
            sb.append(String.valueOf(remainder/den));
            remainder%=den;
        }

        return sb.toString();
        
    }
}
// @lc code=end
