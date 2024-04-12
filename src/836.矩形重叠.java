/*
 * @lc app=leetcode.cn id=836 lang=java
 *
 * [836] 矩形重叠
 *
 * https://leetcode.cn/problems/rectangle-overlap/description/
 *
 * algorithms
 * Easy (49.32%)
 * Likes:    302
 * Dislikes: 0
 * Total Accepted:    52K
 * Total Submissions: 105.4K
 * Testcase Example:  '[0,0,2,2]\n[1,1,3,3]'
 *
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于
 * x 轴，左右边平行于 y 轴。
 * 
 * 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * 
 * 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * rect1.length == 4
 * rect2.length == 4
 * -10^9 <= rec1[i], rec2[i] <= 10^9
 * rec1 和 rec2 表示一个面积不为零的有效矩形
 * 
 * 
 */

// @lc code=start
// class Solution {
//     public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
//         return a(rec1,rec2)||a(rec2,rec1);
//     }
//     private boolean check(int x, int y, int[] rec) {
//         if (x >= rec[0] && x < rec[2] && y >= rec[1] && y < rec[3]) {
//             return true;
//         }    
//         return false;
//     }

//     boolean a(int[] rec1, int[] rec2){
//         //检测第二个rec的四个点是否在rec1中
//         int point1x = rec1[0];
//         int point1y = rec1[1];

//         int point2x = rec1[2];
//         int point2y = rec1[3];

//         int point3x = rec1[0];
//         int point3y = rec1[3];

//         int point4x = rec1[2];
//         int point4y = rec1[1];

//         return check(point1x,point1y,rec2)||check(point2x,point2y,rec2)||check(point3x,point3y,rec2)||check(point4x,point4y,rec2);
//     }
// }
class Solution {                                
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //返回 两个矩形不重叠的情况 情况有四种
        //1. rec1在rec2的左边
        //2. rec1在rec2的下边
        //3. rec1在rec2的右边   
        //4. rec1在rec2的上边
        return !(rec1[2] <= rec2[0] ||   // left
                 rec1[3] <= rec2[1] ||   // bottom
                 rec1[0] >= rec2[2] ||   // right
                 rec1[1] >= rec2[3]);    // top
    }

    
}
// @lc code=end

