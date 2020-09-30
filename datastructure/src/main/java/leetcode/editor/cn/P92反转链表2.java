//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 532 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：反转链表 II
public class P92反转链表2 {

    public static void main(String[] args) {
        Solution solution = new P92反转链表2().new Solution();
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
    /**
     * todo 迭代法需要写，另外本体需要多刷
     */
    class Solution {
        //记录要反转的节点n的下一个节点，因为反转后原来的head的下一个节点要指向postEnd
        ListNode postEnd = null;

        public ListNode reverseBetween(ListNode head, int m, int n) {
            //下面采用递归的方式来解决
            if (m == 1){
                //此时相当于从头开始到n节点反转
                return this.reverse(head,n);
            }
            //递归，从下个节点开始反转
            head.next = reverseBetween(head.next,m-1,n-1);
            return head;
        }

        private ListNode reverse(ListNode head, int n) {
            if (n == 1){
                postEnd = head.next;
                return head;
            }
            //假如从head节点的下一个节点开始反转，就是需要反转n-1个
            ListNode newHead = reverse(head.next,n-1);
            //反转之后将head的下一个的下一个指向head,而head指向n后面的那个节点
            head.next.next = head;
            head.next = postEnd;
            return newHead;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


