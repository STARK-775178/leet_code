/*
 * @lc app=leetcode.cn id=464 lang=java
 *
 * [464] 我能赢吗
 *
 * https://leetcode.cn/problems/can-i-win/description/
 *
 * algorithms
 * Medium (40.81%)
 * Likes:    535
 * Dislikes: 0
 * Total Accepted:    40.4K
 * Total Submissions: 98.9K
 * Testcase Example:  '10\n11'
 *
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100
 * 的玩家，即为胜者。
 * 
 * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
 * 
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 * 
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家能稳赢则返回
 * true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：maxChoosableInteger = 10, desiredTotal = 11
 * 输出：false
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入：maxChoosableInteger = 10, desiredTotal = 0
 * 输出：true
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入：maxChoosableInteger = 10, desiredTotal = 1
 * 输出：true
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= maxChoosableInteger <= 20
 * 0 <= desiredTotal <= 300
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //当maxChoosableInteger大于等于desiredTotal时，先手必胜
        if (desiredTotal <= maxChoosableInteger)
            return true;
        //当所有可选数字的和小于desiredTotal时，先手必败
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
            return false;
        /*
         *state表示当前可选数字的状态，1表示已选，0表示未选
         * HashMap用于记忆化搜索 map的key是state，value是boolean  表示当前状态是否能赢
         * 
         * 
         */ 
        return dfs(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
    }
    //state 表示当前可选数字的状态，1表示已选，0表示未选
    private boolean dfs(int maxChoosableInteger, int desiredTotal, int state, Map<Integer, Boolean> map) {
        //如果已经搜索过，直接返回结果
        if (map.containsKey(state))
            return map.get(state);
        //尝试每个数字作为当前选择
        for (int i = 1; i <= maxChoosableInteger; i++) {
            //当前数字已经被选过，跳过  if条件成立，说明当前数字已经被选过，原因是state的第i位为1
            if ((state & (1 << i)) != 0)
                continue;
            //如果当前选择大于等于目标值，直接返回true。!dfs(maxChoosableInteger, desiredTotal - i, state | (1 << i), map) 表示对手输了
            if (i >= desiredTotal || !dfs(maxChoosableInteger, desiredTotal - i, state | (1 << i), map)) {
                //记录状态并返回true
                map.put(state, true);
                return true;
            }
        }
        //这一步是关键，如果所有的选择都会导致对手获胜，则记录状态并返回false，记录状态是为了避免重复搜索
        map.put(state, false);
        return false;
    }
}
// @lc code=end
