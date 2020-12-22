//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/ 
//
// 
// Related Topics 链表 
// 👍 127 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

//Java：复杂链表的复制
public class P剑指 Offer 35复杂链表的复制{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 35复杂链表的复制().new Solution();
        // TO TEST
        }


/*
// Definition for a Node.*/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        return method1(head);

    }

    /**
     * 方法一:基于hash表构建
     * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/jian-zhi-offer-35-fu-za-lian-biao-de-fu-zhi-ha-xi-/
     * @param head
     * @return
     */
    private Node method1(Node head) {
        /**
         * 构建原节点与新节点的map
         */
        Node cur = head;
        HashMap<Node,Node> map = new HashMap<>();
        while (cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        //遍历之后开始构建新的链表
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        //返回新节点的头部
        return map.get(head);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
