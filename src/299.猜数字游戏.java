/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 *
 * https://leetcode.cn/problems/bulls-and-cows/description/
 *
 * algorithms
 * Medium (57.50%)
 * Likes:    302
 * Dislikes: 0
 * Total Accepted:    85.8K
 * Total Submissions: 149.1K
 * Testcase Example:  '"1807"\n"7810"'
 *
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * 
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 * 
 * 
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 
 * 
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 * 
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 * 
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：secret = "1807", guess = "7810"
 * 输出："1A3B"
 * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1807"
 * ⁠ |
 * "7810"
 * 
 * 示例 2：
 * 
 * 
 * 输入：secret = "1123", guess = "0111"
 * 输出："1A1B"
 * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1123"        "1123"
 * ⁠ |      or     |
 * "0111"        "0111"
 * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= secret.length, guess.length <= 1000
 * secret.length == guess.length
 * secret 和 guess 仅由数字组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        /**
         * Accepted
         * 152/152 cases passed (7 ms)
         * Your runtime beats 24.21 % of java submissions
         * Your memory usage beats 17.24 % of java submissions (40.5 MB)
         * 利用计数数据计算，遍历两次数据，先遍历一遍将bulls存入，再遍历一次通过条件
         * if (secretCount[guess.charAt(i) - 48]
         * > 0) {
         * cows++;
         * secretCount[guess.charAt(i) - 48]--;
         * guessCount[guess.charAt(i) - 48]--;
         * }计算cows。
         */

        // int[] secretCount = new int[10];
        // int[] guessCount = new int[10];

        // int bulls = 0;
        // int cows = 0;

        // // 初始化计数数组
        // for (int i = 0; i < secret.length(); i++) {
        // secretCount[secret.charAt(i) - 48]++;
        // guessCount[guess.charAt(i) - 48]++;
        // }

        // // 从左往右遍历，检查是否相同
        // for (int i = 0; i < secret.length(); i++) {
        // if ((secret.charAt(i) == guess.charAt(i))
        // && (secretCount[secret.charAt(i) - 48] > 0)
        // && (guessCount[guess.charAt(i) - 48] > 0)) {
        // bulls++;
        // secretCount[secret.charAt(i) - 48]--;
        // guessCount[guess.charAt(i) - 48]--;
        // }
        // }

        // for (int i = 0; i < secret.length(); i++) {
        // if ((secret.charAt(i) != guess.charAt(i))) {
        // if (secretCount[guess.charAt(i) - 48] > 0) {
        // cows++;
        // secretCount[guess.charAt(i) - 48]--;
        // guessCount[guess.charAt(i) - 48]--;
        // }
        // }
        // }

        // return bulls + "A" + cows + "B";

        /**
         * Accepted
         * 152/152 cases passed (5 ms)
         * Your runtime beats 61.83 % of java submissions
         * Your memory usage beats 58 % of java submissions (40.2 MB)
         */
        int[] map = new int[10];
        int a = 0, b = 0;
        for (int i = 0; i < secret.length(); i++) {
            map[secret.charAt(i) - '0']++;
        }
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
                map[guess.charAt(i) - '0']--;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) && map[guess.charAt(i) - '0'] > 0) {
                b++;
                map[guess.charAt(i) - '0']--;
            }
        }
        return a + "A" + b + "B";
    }
}
// @lc code=end
