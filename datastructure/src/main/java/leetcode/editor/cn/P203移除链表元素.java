//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 448 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：移除链表元素
public class P203移除链表元素{
    public static void main(String[] args) {
        Solution solution = new P203移除链表元素().new Solution();
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
    public ListNode removeElements(ListNode head, int val) {
        //1.先用递归的方式做(时间和空间复杂度为O(n))
        if (head == null){
            return null;
        }
        /*
        head.next = removeElements(head.next,val);
        if (head.val == val){
            return head.next;
        }else{
            return head;
        }*/
        //2.添加一个哨兵节点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                //指针后移一位
                cur = cur.next;
            }
        }
        return pre.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
