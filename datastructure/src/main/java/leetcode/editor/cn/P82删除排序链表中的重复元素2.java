//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 375 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：删除排序链表中的重复元素 II
public class P82删除排序链表中的重复元素2{
    public static void main(String[] args) {
        Solution solution = new P82删除排序链表中的重复元素2().new Solution();
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
 * 参考题解 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/javashuang-zhi-zhen-dai-ma-jiao-duan-rong-yi-li-ji/
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        //思路，向后遍历的过程中遇到相同的就跳过，不同的就拼接在尾部
        //TODO 该题目还需要继续看
        ListNode pre = new ListNode(0);
        ListNode tail = pre;
        for (ListNode left = head,right = head;left!=null;left=right){
            // 只要r不为空并且与l的值相等则一直向后移动
            while (right != null && left.val == right.val){
                right = right.next;
            }
            //判断长度是否为1来插入尾部(即判断要插入的元素与上一个是否相同，因为链表是排序的，所以每次添加都和上一次对比即可保证后面的不会
            // 与前面的任何一个重复)
            if (left.next == right){
                //将元素拼接在tail后面
                tail.next = left;
                //tail指针后移一位到新拼接入的链表
                tail = left;
                //去除tail后面的元素
                tail.next = null;
            }
        }
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
