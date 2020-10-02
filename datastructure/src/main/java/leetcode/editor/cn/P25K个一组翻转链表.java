//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 758 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：K 个一组翻转链表
public class P25K个一组翻转链表{
    public static void main(String[] args) {
        Solution solution = new P25K个一组翻转链表().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/k-ge-yi-zu-fan-zhuan-lian-biao
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return head;
        }
        //迭代法K个一组反转链表
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null){
                return head;
            }
            end = end.next;
        }
        //迭代反转这一部分
        ListNode newHead = this.reverse(start,end);
        start.next = reverseKGroup(end,k);
        return newHead;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        //迭代法反转链表,反转[start,end）之间的链表
        ListNode pre = null;
        ListNode cur = start;
        while (cur != end){
            ListNode next = cur.next;
            cur.next = pre;
            //后移
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
