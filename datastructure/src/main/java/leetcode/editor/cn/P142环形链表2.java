//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针 
// 👍 632 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：环形链表 II
public class P142环形链表2 {
    public static void main(String[] args) {
        Solution solution = new P142环形链表2().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //经典的快慢指针问题，首先要通过快慢指针找到环的相遇点
        ListNode meet = this.findmeet(head);
        if (meet == null){
            return null;
        }
        //注意这里条件比较的是引用地址，不是值，别犯傻了
        while (head!= meet){
            head = head.next;
            meet = meet.next;
        }
        return head;
        
    }

    private ListNode findmeet(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        /**while (slow!=null && fast.next!=null && slow != fast){
         slow = slow.next;
         fast = fast.next.next;
         }
         return slow;
         */
        while (slow!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null){
                return null;
            }
            if (slow == fast){
                return slow;
            }
        }
        return null;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
