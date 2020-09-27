//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 648 👎 0


package leetcode.editor.cn;

import java.util.Stack;
import leetcode.editor.cn.common.ListNode;

//Java：回文链表
public class P234回文链表{
    public static void main(String[] args) {
        Solution solution = new P234回文链表().new Solution();
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        //1.采用最笨的栈的方式来判断，先进栈，再出栈，如果得到结果一致就说明是回文字符串,时间复杂度和空间复杂度均为o(n)
        /*Stack<ListNode> stackin = new Stack<>();
        Stack<ListNode> stackout = new Stack<>();
        while (head != null){
            stackin.push(head);
            head = head.next;
        }
        Stack<ListNode> in = new Stack<>();
        in.addAll(stackin);
        while (!stackin.empty()){
            stackout.add(stackin.pop());
        }
        //比较in和stackout是否一致
        while (!in.empty()){
            if (in.pop().val != stackout.pop().val){
                return false;
            }
        }
        return true;*/
        //2.下面采用先反转链表，再对比是否一致

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
