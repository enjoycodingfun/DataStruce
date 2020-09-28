//给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。 
//
// 请你返回该链表所表示数字的 十进制值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [1,0,1]
//输出：5
//解释：二进制数 (101) 转化为十进制数 (5)
// 
//
// 示例 2： 
//
// 输入：head = [0]
//输出：0
// 
//
// 示例 3： 
//
// 输入：head = [1]
//输出：1
// 
//
// 示例 4： 
//
// 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
//输出：18880
// 
//
// 示例 5： 
//
// 输入：head = [0,0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 链表不为空。 
// 链表的结点总数不超过 30。 
// 每个结点的值不是 0 就是 1。 
// 
// Related Topics 位运算 链表 
// 👍 55 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：二进制链表转整数
public class P1290二进制链表转整数{
    public static void main(String[] args) {
        Solution solution = new P1290二进制链表转整数().new Solution();
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
    public int getDecimalValue(ListNode head) {
        //1.最笨的办法，使用栈先进栈，再出栈计算值
        /*Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        int num = 0;
        double n = 0;
        while (!stack.empty()){
            num += stack.pop().val*Math.pow(Double.parseDouble(String.valueOf(2)),n);
            n ++;
        }
        return num;*/
        //2.位运算
        int num = 0;
        while (head != null){
            num <<= 1;
            num += head.val;
            head = head.next;
        }
        return num;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
