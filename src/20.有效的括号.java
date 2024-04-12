/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode.cn/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (43.91%)
 * Likes:    4416
 * Dislikes: 0
 * Total Accepted:    1.8M
 * Total Submissions: 4M
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "()"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "()[]{}"
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "(]"
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 仅由括号 '()[]{}' 组成
 * 
 * 
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        // int[] nums= new int[3];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.add(s.charAt(i));
            }else{
                if(stack.size()==0){
                    return false;
                }
                if(s.charAt(i)==')'){
                    if(stack.pop()!='('){
                        return false;
                    }
                }else if(s.charAt(i)==']'){
                    if(stack.pop()!='['){
                        return false;
                    }
                }else if(s.charAt(i)=='}'){
                    if(stack.pop()!='{'){
                        return false;
                    }
                }
            }
            // if(s.charAt(i)=='('){
            //     nums[0]++;
            // }else if(s.charAt(i)=='['){
            //     nums[1]++;
            // }else if(s.charAt(i)=='{'){
            //     nums[2]++;
            // }
            // if(s.charAt(i)==')'){
            //     if(--nums[0]==-1){
            //         return false;
            //     }
            // }else if(s.charAt(i)==']'){
            //     if(--nums[1]==-1){
            //         return false;
            //     }
            // }else if(s.charAt(i)=='}'){
            //     if(--nums[2]==-1){
            //         return false;
            //     }
            // }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

