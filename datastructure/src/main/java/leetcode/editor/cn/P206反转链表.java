//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1236 👎 0


package leetcode.editor.cn;

import java.util.List;

//Java：反转链表
public class P206反转链表{
    public static void main(String[] args) {
        Solution solution = new P206反转链表().new Solution();
        // TO TEST
    }
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        /**
         * 方法一：递归解决反转问题。只要将head后面的反转之后将原head.next的next指向head就行
         */
        if (head == null || head.next == null){
            return head;
        }
        /**
         * 1->2->3->4  当前1为head，先反转1后面的，reverseList(head.next),反转后变为4->3->2,新的head为4
         * 之后将原来head结点（1）的next（2）的next指向原head（1）,每个节点都反转一次，时间复杂度O(n),空间复杂度
         * 由于递归调用，为o（n）
         *//*
        //递归反转后面的元素
        ListNode newHead = reverseList(head.next);
        //将新的头结点的下一个指向原头结点
        head.next.next = head;
        head.next = null;
        return newHead;*/

        //方法二：迭代法解决问题
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode temp = cur.next;
        while (temp != null){
            //首先要保存当前节点的下个节点的下个节点

            //将当前节点的下一个节点指向当前节点前驱节点
            cur.next = pre;
            //当前节点前置节点与当前节点断开
            pre.next = null;
            //指针移动到下一个节点
            pre = cur;
            cur = temp;
        }
        return cur;


        



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
