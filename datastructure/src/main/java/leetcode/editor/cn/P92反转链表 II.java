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
public class P92反转链表 II{
    public static void main(String[] args) {
        Solution solution = new P92反转链表 II().new Solution();
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null){
            return head;
        }
        if (m==1 && m==n){
            return head;
        }
        //先定义四个指针，分别指向m-1,m,n,n+1处
        ListNode preStart = null;//第m-1个节点
        ListNode start = null;//第m个节点
        ListNode end = null;//第n个节点
        ListNode postEnd = null;//n+1个节点
        ListNode tmp = head;//头节点
        int index = 1;
        while (tmp != null){
            if (index == m-1){
                preStart = tmp;
            }else if (index == m){
                start = tmp;
            }else if (index == n){
                end = tmp;
            }else if (index == n+1){
                postEnd = tmp;
            }
            tmp = tmp.next;
            index ++;
        }
        //TODO 逻辑需要调整
        //接下来从start到end开始反转，调用反转方法
        this.reverse(start,end);
        //反转过后end就是第m个节点，start是第n个节点
        //preStart.next = end;注意这里preSart可能为null即当从头结点开始反转的时候，所以要判定下
        if (preStart != null){
            preStart.next = end;
        }else{
            head.next = end;
        }
        start.next = postEnd;
        return head;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        if (start == null || start == end){
            return start;
        }
        ListNode pre = null;
        ListNode cur = start;
        //采用迭代法反转
        while (cur != end.next){
            //首先保存当前节点的下一个节点
            ListNode tmp = cur.next;
            //将当前节点的下一个节点指向其前置节点
            cur.next = pre;
            //指针后移
            pre = cur;
            cur = tmp;
        }
        return cur;


    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
