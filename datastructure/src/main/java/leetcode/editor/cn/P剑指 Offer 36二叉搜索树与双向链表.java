//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 分治算法 
// 👍 149 👎 0


package leetcode.editor.cn;

//Java：二叉搜索树与双向链表
public class P剑指 Offer 36二叉搜索树与双向链表{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 36二叉搜索树与双向链表().new Solution();
        // TO TEST
        }


// Definition for a Node.
class Node {

    public int val;

    public Node left;

    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

};

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        //当cur为null的时候，pre指向最后一个节点，head指向第一个节点，把他两连起来即可(注意left是前驱,right是后继)
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 利用二叉排序树的中序遍历是升序的性质
     */
    private void dfs(Node cur) {
        if (cur == null) {
            //当前节点已经为空则直接返回
            return;
        }
        //中序遍历先访问左子树|根|右子树
        dfs(cur.left);
        if (pre == null) {
            //递归到最左叶子节点的时候第一次的时候pre和head还没有值，此时初始化head的值，方便后面连接头尾节点
            head = cur;
        } else {
            //如果pre已经有值了，说明已经初始化过了，将pre的右子节点指向当前节点
            pre.right = cur;
        }
        cur.left = pre;
        //将pre指向当前节点
        pre = cur;
        //遍历右子树
        dfs(cur.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
