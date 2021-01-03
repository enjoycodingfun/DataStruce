//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4975 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：两数相加
public class P2两数相加{
    public static void main(String[] args) {
        Solution solution = new P2两数相加().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return method1(l1,l2);

    }

    private ListNode method1(ListNode l1, ListNode l2) {
        //创建哨兵节点
        ListNode head = new ListNode(0);
        ListNode pre = head;
        int plus = 0;//用来保存上一位的进位数字
        //注意循环条件一定要加plus != 0,因为像[9,9,9,9,9,9,9]+[9,9,9,9]进位到最后一位的时候只有plus进位等于1，此时l1和l2
        //都是null了，如果不加plus ！=0这个条件就会丢失最后一位进位
        while (l1 != null || l2 != null || plus != 0){
            int v1 = l1 == null?0:l1.val;
            int v2 = l2 == null?0:l2.val;
            int curVal = (v1+v2+plus)%10;
            plus = (v1+v2+plus)/10;
            ListNode curNode = new ListNode(curVal);
            pre.next = curNode;
            //开始下一轮循环
            pre = curNode;
            l1 = l1 == null?null:l1.next;
            l2 = l2 == null?null:l2.next;
        }
        return head.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
