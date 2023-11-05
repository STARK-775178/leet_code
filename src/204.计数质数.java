/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode.cn/problems/count-primes/description/
 *
 * algorithms
 * Medium (37.16%)
 * Likes:    1107
 * Dislikes: 0
 * Total Accepted:    262.7K
 * Total Submissions: 707.2K
 * Testcase Example:  '10'
 *
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 0
 * 输出：0
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：n = 1
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= n <= 5 * 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {

        // //暴力检索优化
        // int count = 0;
        // for(int i = 2; i < n; i++){
        //     if(isPrime(i)){
        //         count++;
        //     }
        // }
        // return count;
        
        /**
         * 埃氏筛
         */
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for(int i = 2; i * i < n; i++){
            if(isPrime[i]){
                for(int j = i * i; j < n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
        /**
         * 暴力搜索超时
         */
        // int ans = 0;
        // boolean flag = true;
        // for(int i = 2; i < n; i++){
        //     flag = true;
        //     for(int j = 2; j * j <= i; j++){
        //         if(i % j == 0){
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if(flag){
        //         ans++;
        //     }
        // }
        // return ans;

        
    
    }

    boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

}
// @lc code=end

