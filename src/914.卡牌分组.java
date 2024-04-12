/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 *
 * https://leetcode.cn/problems/x-of-a-kind-in-a-deck-of-cards/description/
 *
 * algorithms
 * Easy (37.18%)
 * Likes:    292
 * Dislikes: 0
 * Total Accepted:    62.9K
 * Total Submissions: 169.2K
 * Testcase Example:  '[1,2,3,4,4,3,2,1]'
 *
 * 给定一副牌，每张牌上都写着一个整数。
 * 
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * 
 * 
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 
 * 
 * 仅当你可选的 X >= 2 时返回 true。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：deck = [1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：deck = [1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= deck.length <= 10^4
 * 0 <= deck[i] < 10^4
 * 
 * 
 */

// @lc code=start

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c: deck) {
            count[c]++;
        }

        List<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                values.add(count[i]);
            }
        }

        for (int X = 2; X <= N; ++X) {
            if (N % X == 0) {
                boolean flag = true;
                for (int v: values) {
                    if (v % X != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }
}

// @lc code=end

