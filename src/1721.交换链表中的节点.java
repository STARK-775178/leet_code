/*
 * @lc app=leetcode.cn id=1721 lang=java
 *
 * [1721] 交换链表中的节点
 *
 * https://leetcode.cn/problems/swapping-nodes-in-a-linked-list/description/
 *
 * algorithms
 * Medium (63.64%)
 * Likes:    92
 * Dislikes: 0
 * Total Accepted:    22.4K
 * Total Submissions: 35.3K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你链表的头节点 head 和一个整数 k 。
 * 
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：head = [1,2,3], k = 2
 * 输出：[1,2,3]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目是 n
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        ListNode pre = head;

        for (int i = 1; i < k; i++) {
            temp = temp.next;
        }
        
        ListNode kNode = temp;
        while(temp.next!=null){
            temp = temp.next;
            pre = pre.next;
        }
        
        //交换pre 和 temp的val
        int tempVal = pre.val;
        pre.val = kNode.val;
        kNode.val = tempVal;



        return head;
    }
}
// @lc code=end

