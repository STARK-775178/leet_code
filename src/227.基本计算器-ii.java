/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 *
 * https://leetcode.cn/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (44.67%)
 * Likes:    736
 * Dislikes: 0
 * Total Accepted:    159.2K
 * Total Submissions: 356.4K
 * Testcase Example:  '"3+2*2"'
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 
 * 整数除法仅保留整数部分。
 * 
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2^31, 2^31 - 1] 的范围内。
 * 
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "3+2*2"
 * 输出：7
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = " 3/2 "
 * 输出：1
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 3 * 10^5
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 2^31 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * 
 * 
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        int len = s.length();
        //num用来记录当前数字，sign用来记录当前符号
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            //如果是数字，连续读取到num中
            if(Character.isDigit(c)){
                //减去'0'是为了把char转化为int *10是为了把之前的数字扩大10倍,扩大十倍是因为可能是多位数
                num = num * 10 + c - '0';
            }
            //如果不是数字，就是符号，或者是最后一个字符
            if((!Character.isDigit(c) && c != ' ') || i == len - 1){
                //如果是加号或者减号，就把当前数字压入栈中
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                //如果是乘号或者除号，就把栈顶元素取出，和当前数字运算，再压入栈中
                }else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                //更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }

        }
        //把栈中所有结果求和就是答案
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
// @lc code=end

