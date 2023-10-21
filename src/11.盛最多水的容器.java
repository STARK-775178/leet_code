/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode.cn/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (60.07%)
 * Likes:    4630
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 1.8M
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 返回容器可以储存的最大水量。
 * 
 * 说明：你不能倾斜容器。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 示例 2：
 * 
 * 
 * 输入：height = [1,1]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * 
 * 
 */

// @lc code=start


class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int temp = 0;

        // 暴力解法
        // 获得所有组合的值并返回最大值
        // 超时哩 悲
        // for (int i = 0; i < height.length; i++) {
        //     for (int j = (height.length/2); j < height.length; j++) {
        //         temp = getV(i, j, height[i], height[j]);
        //         if(temp>result){
        //             result = temp;
        //         }
        //     }
        // }
        // return result;
        // 二分法
        // 从两边向中间遍历
        // 两边较小的一边向中间移动
        // 两边相等时，两边都向中间移动
        int left = 0;
        int right = height.length-1;
        while(left<right){
            temp = getV(left, right, height[left], height[right]);
            if(temp>result){
                result = temp;
            }
            if(height[left]<height[right]){
                left++;
            }else if(height[left]>height[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }
        return result;
    }

    public int getV(int x1,int x2,int y1,int y2){
        return (x2-x1)*(y1<y2?y1:y2);
    }
}
// @lc code=end

