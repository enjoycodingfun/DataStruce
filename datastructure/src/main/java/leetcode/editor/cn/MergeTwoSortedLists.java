//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;
public class MergeTwoSortedLists{
  public static void main(String[] args){
      Solution solution = new MergeTwoSortedLists().new Solution();

      ListNode l11 = new ListNode(1);
      ListNode l12 = new ListNode(2);
      ListNode l13 = new ListNode(4);
      ListNode l21 = new ListNode(1);
      ListNode l22 = new ListNode(3);
      ListNode l23 = new ListNode(4);
      l11.next = l12;
      l12.next = l13;
      l21.next = l22;
      l22.next = l23;
      ListNode listNode = solution.mergeTwoLists(l11, l21);
      MergeTwoSortedLists.ListNode.printVal(listNode);
  }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      public static void printVal(ListNode node){
          while(node.next != null){
              System.out.print(node.val+"->");
              node = node.next;
          }
          //输出最后一个节点的值
          System.out.println(node.val);
      }
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


