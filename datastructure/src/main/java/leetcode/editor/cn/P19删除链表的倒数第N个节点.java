//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1005 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：删除链表的倒数第N个节点
public class P19删除链表的倒数第N个节点{
    public static void main(String[] args) {
        Solution solution = new P19删除链表的倒数第N个节点().new Solution();
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
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 思路：使用快慢指针，开始都指向head，之后快指针走n-1步，到达第n个节点，假如链表总长为L，那么剩下的节点就是
         * L-n,接下来快慢指针同时往前走，直到快指针走到链表尾部，这时候走了剩下的L-n步，慢指针所指的刚好是倒数第n个节点
         */
        if(head == null || head.next ==null){
            return null;
        }
        //定义一个哨兵节点，防止head被删除后不方便返回新的头结点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        int num = 0;
        //快指针先走n步
        while (num != n){
            fast = fast.next;
            num ++;
        }
        //接下来快慢指针同时往后走，直到快指针走到结尾(此时取的是倒数第n+1个位置)
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
