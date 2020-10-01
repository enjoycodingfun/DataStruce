//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 60 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：从尾到头打印链表
public class P剑指Offer06从尾到头打印链表{
    public static void main(String[] args) {
        Solution solution = new P剑指Offer06从尾到头打印链表().new Solution();
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
    public int[] reversePrint(ListNode head) {

        //数组头插法
        if (head == null ){
            return new int[0];
        }
        //1.最笨的办法，先入栈，最后出栈
        /*Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        int index = 0;
        int[] arr = new int[stack.size()];
        while (!stack.empty()){
            arr[index] = stack.pop().val;
            index++;
        }
        return arr;*/
        //2.使用递归的方式
        //先统计链表长度
        int count = this.count(head);
        int[] arr = new int[count];
        this.reverse(head,arr,count-1);
        return arr;
    }

    private void reverse(ListNode head, int[] arr, int i) {
        if (head == null){
            return;
        }
        reverse(head.next,arr,i-1);
        arr[i] = head.val;
    }

    private int count(ListNode head) {
        int count = 0;
        while (head != null){
            head = head.next;
            count ++;
        }

        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
