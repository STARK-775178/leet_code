/*
 * @lc app=leetcode.cn id=2241 lang=java
 *
 * [2241] 设计一个 ATM 机器
 *
 * https://leetcode.cn/problems/design-an-atm-machine/description/
 *
 * algorithms
 * Medium (37.13%)
 * Likes:    15
 * Dislikes: 0
 * Total Accepted:    7.6K
 * Total Submissions: 20.3K
 * Testcase Example:  '["ATM","deposit","withdraw","deposit","withdraw","withdraw"]\n' +
  '[[],[[0,0,1,2,1]],[600],[[0,1,0,1,1]],[600],[550]]'
 *
 * 一个 ATM 机器，存有 5 种面值的钞票：20 ，50 ，100 ，200 和 500 美元。初始时，ATM
 * 机是空的。用户可以用它存或者取任意数目的钱。
 * 
 * 取款时，机器会优先取 较大 数额的钱。
 * 
 * 
 * 比方说，你想取 $300 ，并且机器里有 2 张 $50 的钞票，1 张 $100 的钞票和1 张 $200 的钞票，那么机器会取出 $100 和
 * $200 的钞票。
 * 但是，如果你想取 $600 ，机器里有 3 张 $200 的钞票和1 张 $500 的钞票，那么取款请求会被拒绝，因为机器会先取出 $500
 * 的钞票，然后无法取出剩余的 $100 。注意，因为有 $500 钞票的存在，机器 不能 取 $200 的钞票。
 * 
 * 
 * 请你实现 ATM 类：
 * 
 * 
 * ATM() 初始化 ATM 对象。
 * void deposit(int[] banknotesCount) 分别存入 $20 ，$50，$100，$200 和 $500 钞票的数目。
 * int[] withdraw(int amount) 返回一个长度为 5 的数组，分别表示 $20 ，$50，$100 ，$200 和 $500
 * 钞票的数目，并且更新 ATM 机里取款后钞票的剩余数量。如果无法取出指定数额的钱，请返回 [-1] （这种情况下 不 取出任何钞票）。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：
 * ["ATM", "deposit", "withdraw", "deposit", "withdraw", "withdraw"]
 * [[], [[0,0,1,2,1]], [600], [[0,1,0,1,1]], [600], [550]]
 * 输出：
 * [null, null, [0,0,1,0,1], null, [-1], [0,1,0,0,1]]
 * 
 * 解释：
 * ATM atm = new ATM();
 * atm.deposit([0,0,1,2,1]); // 存入 1 张 $100 ，2 张 $200 和 1 张 $500 的钞票。
 * atm.withdraw(600);        // 返回 [0,0,1,0,1] 。机器返回 1 张 $100 和 1 张 $500
 * 的钞票。机器里剩余钞票的数量为 [0,0,0,2,0] 。
 * atm.deposit([0,1,0,1,1]); // 存入 1 张 $50 ，1 张 $200 和 1 张 $500 的钞票。
 * ⁠                         // 机器中剩余钞票数量为 [0,1,0,3,1] 。
 * atm.withdraw(600);        // 返回 [-1] 。机器会尝试取出 $500 的钞票，然后无法得到剩余的 $100
 * ，所以取款请求会被拒绝。
 * ⁠                         // 由于请求被拒绝，机器中钞票的数量不会发生改变。
 * atm.withdraw(550);        // 返回 [0,1,0,0,1] ，机器会返回 1 张 $50 的钞票和 1 张 $500
 * 的钞票。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * banknotesCount.length == 5
 * 0 <= banknotesCount[i] <= 10^9
 * 1 <= amount <= 10^9
 * 总共 最多有 5000 次 withdraw 和 deposit 的调用。
 * 函数 withdraw 和 deposit 至少各有 一次 调用。
 * 
 * 
 */

// @lc code=start
class ATM {
    long[] count; // 记录每种面值的钱数
    int[] val; // 记录每种币的面值，方便下面操作

    public ATM() {
        count = new long[5]; // 记录每种面值的钱数
        val = new int[]{20, 50, 100, 200, 500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; ++i) {
            count[i] += banknotesCount[i]; // 更新每种币的数量
        }
    }

    public int[] withdraw(int amount) {
        int[] arr = new int[5]; // 记录每种币的消耗量
        for (int i = 4; i >= 0; --i) {
            // 从面值大的开始取，因为要优先取较大数额的钱
            int num = (int) Math.min(count[i], amount / val[i]);
            arr[i] = num;
            amount -= num * val[i]; // 更新amount的值
        }
        if (amount != 0) { // 说明将所有面值都遍历后，不能取出钱
            return new int[]{-1};
        }
        // 更新账户里面的币的数量，注意这个更新操作不能放在上面的for循环里面，因为上面的循环不能保证正常能取出钱，只有取出钱才更新数量
        for (int i = 0; i < 5; ++i) {
            count[i] -= arr[i];
        }
        return arr;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
// @lc code=end

