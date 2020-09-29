//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 638 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：两两交换链表中的节点
public class P24两两交换链表中的节点 {

    public static void main(String[] args) {
        Solution solution = new P24两两交换链表中的节点().new Solution();
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

        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //使用递归，时间复杂度O（N），空间复杂度O(N)
            /*ListNode pre = head;
            ListNode cur = head.next;
            ListNode newhead = this.swapPairs(cur.next);
            cur.next = pre;
            pre.next = newhead;
            return cur;*/
            //使用迭代，先创建哨兵节点,时间复杂度O（n），空间复杂度O（1）
            ListNode sentinel = new ListNode(0);
            //这一步是为了返回最后的结果
            ListNode res = sentinel;
            while (head != null && head.next != null){
                //哨兵节点指向头结点的下一个节点
                sentinel.next = head.next;
                //头结点指向下下一个节点
                head.next = head.next.next;
                //头结点的下一个节点指向头结点
                sentinel.next.next = head;
                //头结点及哨兵节点转移到下一对(哨兵节点此时指向调转后的head)
                sentinel = sentinel.next.next;
                head = head.next;
            }
            return res.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
