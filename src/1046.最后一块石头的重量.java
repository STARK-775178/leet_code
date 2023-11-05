/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 *
 * https://leetcode.cn/problems/last-stone-weight/description/
 *
 * algorithms
 * Easy (65.39%)
 * Likes:    289
 * Dislikes: 0
 * Total Accepted:    96.8K
 * Total Submissions: 148.2K
 * Testcase Example:  '[2,7,4,1,8,1]'
 *
 * 有一堆石头，每块石头的重量都是正整数。
 * 
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x 。那么粉碎的可能结果如下：
 * 
 * 
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 
 * 
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Arrays.sort(stones);
        // int len = stones.length;
        // while (len>1) {
        // if(stones[len-1]==stones[len-2]){
        // stones[len-1]=0;
        // stones[len-2]=0;
        // len-=2;
        // }else{
        // stones[len-2]=stones[len-1]-stones[len-2];
        // stones[len-1]=0;
        // len--;
        // }
        // Arrays.sort(stones,0,len);
        // }
        // return stones[0];

        // 优先队列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b-a);
        
        for (int  a : stones) {
            priorityQueue.offer(a);
        }

        while (priorityQueue.size()>1) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            if(a!=b){
                priorityQueue.offer(a-b);
            }
        }
        return priorityQueue.size()==0?0:priorityQueue.poll();
    }
}
// @lc code=end
