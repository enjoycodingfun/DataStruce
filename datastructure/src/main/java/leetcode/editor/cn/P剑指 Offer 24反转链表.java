//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 145 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：反转链表
public class P剑指 Offer 24反转链表{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 24反转链表().new Solution();
        // TO TEST
        }
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode reverseList(ListNode head) {
        //return recursion(head);
        return iterator(head);

    }

    /**
     * 迭代法反转链表
     * @param head
     * @return
     */
    private ListNode iterator(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    private ListNode recursion(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
