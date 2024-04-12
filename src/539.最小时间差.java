/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 *
 * https://leetcode.cn/problems/minimum-time-difference/description/
 *
 * algorithms
 * Medium (65.68%)
 * Likes:    251
 * Dislikes: 0
 * Total Accepted:    66.6K
 * Total Submissions: 101.4K
 * Testcase Example:  '["23:59","00:00"]'
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= timePoints.length <= 2 * 10^4
 * timePoints[i] 格式为 "HH:MM"
 * 
 * 
 */

// @lc code=start

import java.util.List;

import java.util.stream.Collectors;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        //鸽巢原理
        if(timePoints.size() > 1440) return 0;
        List<Integer> list = timePoints.stream().map((point)->{
                    String[] strs = point.split(":");
                    Integer hours = Integer.parseInt(strs[0]);
                    Integer mins = Integer.parseInt(strs[1]);
                    return hours*60+mins;
                }).sorted().collect(Collectors.toList());
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min,list.get(i)-list.get(i-1));
        }
        // 24*60 = 1440 1440-最后一个时间+第一个时间的含义是：第一个时间到最后一个时间的时间差
        min = Math.min(min,1440-list.get(list.size()-1)+list.get(0));

        return min;
        
        
    }
}
// @lc code=end
