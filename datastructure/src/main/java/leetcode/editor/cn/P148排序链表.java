//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 942 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.ListNode;

//Java：排序链表
public class P148排序链表{
    public static void main(String[] args) {
        Solution solution = new P148排序链表().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 思路参考
     * https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-di-gui-die-dai-xiang-jie-by-cherr/
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        return method1(head);
    }

    private ListNode method1(ListNode head) {
        /**
         * 首先为了后面截取链表需要先获取链表的长度
         */
        int lenght = this.getLength(head);
        //创建哨兵节点，每次排序开始的时候，节点头指针都指到哨兵节点处
        ListNode sentinel = new ListNode(-1,head);
        //接下来按照一定的步长开始拆分合并链表，比如第一次先把链表节点拆分成一个一个的单独节点，然后两两排序合并（这个和剑指offer25题合并两个排序列表一样）
        //第一次循环完之后下一次变成两个两个的拆开，然后合并排序成四个四个的，直到最后排序完成
        for (int step = 1; step < lenght ; step<<=1) {
            //每次循环都从链表头部开始
            ListNode pre = sentinel;
            ListNode cur = sentinel.next;
            //开始按照步长拆分链表
            while (cur != null){
                //第一部分开头等于cur
                ListNode h1 = cur;
                //从第一部分头结点开始按照步长拆分，返回第二部分的头结点
                ListNode h2 = this.split(h1,step);
                //cur指向剩余部分的头结点准备在下一个循环的时候使用
                cur = this.split(h2,step);
                //合并第一部分与第二部分并返回新的头结点
                ListNode tmp = this.merge(h1,h2);
                //将这部分合并好的拼接到pre的后面
                pre.next = tmp;
                //将pre指针移动到拼接后链表的尾部
                while (pre.next != null){
                    pre = pre.next;
                }
            }
        }
        //最后返回哨兵节点的下一个节点
        return sentinel.next;
    }

    /**
     * 合并两个有序列表的代码
     * @param h1
     * @param h2
     * @return
     */
    private ListNode merge(ListNode h1, ListNode h2) {
        //创建哨兵节点
        ListNode sentinel = new ListNode(-1);
        ListNode pre = sentinel;
        while (h1 != null && h2 != null){
            if (h1.val < h2.val){
                pre.next = h1;
                h1 = h1.next;
            }else{
                pre.next = h2;
                h2 = h2.next;
            }
            pre = pre.next;
        }
        //假如其中一个走完了，就把另外一个的剩余节点拼接到当前pre上
        pre.next = h1 == null?h2:h1;
        return sentinel.next;
    }

    /**
     * 按照步长拆分链表，返回第二部分头部
     * @param head
     * @param step
     * @return
     */
    private ListNode split(ListNode head, int step) {
        if (head == null){
            return head;
        }
        ListNode cur = head;
        //注意这里cur.next!=null 有可能出现后半段还没到规定步长但是走完的情况
        for (int i = 1; i < step && cur.next != null; i++) {
            cur = cur.next;
        }
        //跳出循环的时候刚好数了step-1+head=step个元素，那么后半部分结点就是cur.next
        //后半部分的头结点
        ListNode right = cur.next;
        //断开前后两段关联
        cur.next = null;
        return right;
    }

    /**
     * 获取链表长度
     * @param head
     * @return
     */
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
