/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 *
 * https://leetcode.cn/problems/rotate-list/description/
 *
 * algorithms
 * Medium (41.33%)
 * Likes:    1015
 * Dislikes: 0
 * Total Accepted:    346.8K
 * Total Submissions: 839.4K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        /**
         * Accepted
         * 232/232 cases passed (7 ms)
         * Your runtime beats 4.9 % of java submissions
         * Your memory usage beats 5.07 % of java submissions (41.4 MB)
         */
        if (head == null)
            return null;
        // 获得链表长度
        ListNode head_length = head;
        int length = 1;
        while (head_length.next != null) {
            length++;
            head_length = head_length.next;
        }
        System.out.println("length" + length);
        k = k % length;
        System.out.println("k" + k);
        if (k == 0)
            return head;

        
        ListNode h = head;
        ListNode pre_k = head;

        for (int i = 0; i < k; i++) {
            head = head.next;
        }

        while (head.next != null) {
            pre_k = pre_k.next;
            head = head.next;
        }

        ListNode res = pre_k.next;
        pre_k.next = null;
        head.next = h;

        return res;
    }
}
// @lc code=end
