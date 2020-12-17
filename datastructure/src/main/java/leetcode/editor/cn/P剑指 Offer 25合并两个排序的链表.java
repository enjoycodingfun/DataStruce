//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 68 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：合并两个排序的链表
public class P剑指 Offer 25合并两个排序的链表{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 25合并两个排序的链表().new Solution();
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //return recursion(l1,l2);
        return iterator(l1,l2);
    }

    /**
     * 迭代法解决问题
     * @param l1
     * @param l2
     * @return
     */
    private ListNode iterator(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0),cur = sentinel;
        while (l1!=null && l2!=null){
            if (l1.val <= l2.val){
                cur.next=l1;
                l1 = l1.next;
            } else if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null?l2:l1;
        return sentinel.next;
    }

    /**
     * 递归解决
     * @param l1
     * @param l2
     * @return
     */
    private ListNode recursion(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = recursion(l1.next,l2);
            return l1;
        }
        if (l1.val > l2.val){
            l2.next = recursion(l1,l2.next);
            return l2;
        }
        return null;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
