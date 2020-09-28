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
        //2.下面采用反转链表，再对比是否一致的方法（下面这种方法把原链表已经反转了，所以新老链表永远都一致XXX）
        //要想使用这种除非构建一个新的链表把原链表保存着
        /*ListNode newHead = this.reverse(head);
        //开始遍历对比是否一致
        while(head != null){
            if (head.val != newHead.val){
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;*/
        //3.下面采用先找到中点，然后从中点开始反转后半部分，之后用后半部分与前半部分比较（这个时候前半部分还是原来的样子）
        //时间复杂度O(N),空间复杂度O(1)
        //找到中间节点
        ListNode mid = this.findMid(head);
        //反转后半部分
        ListNode newMidHead = this.reverse(mid);
        //前后两段开始对比
        while (newMidHead != null){
            if (newMidHead.val != head.val){
                return false;
            }
            head = head.next;
            newMidHead = newMidHead.next;
        }
        return true;
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        //采用迭代法反转链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            //先保存当前节点的下一个节点以防反转后找不到
            ListNode temp = cur.next;
            //将当前节点的next指针指向前缀
            cur.next = pre;
            //将pre和cur都移动到下一位
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
