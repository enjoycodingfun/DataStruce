//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 108 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：N叉树的前序遍历
public class P589N叉树的前序遍历{
    public static void main(String[] args) {
        Solution solution = new P589N叉树的前序遍历().new Solution();
        // TO TEST
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.

*/

class Solution {
    public List<Integer> preorder(Node root) {
        /**
         * 方法一：使用迭代的方式
         */
        /*List<Integer> list = new ArrayList<>();
        return this.preorderHelper(list,root);*/
        /**
         * 方法二：使用迭代：
         * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/marveljian-dan-de-xue-xi-bi-ji-589-by-tyanyonecanc/
         */
        List<Integer> list = new ArrayList<>();
        return this.preorderHelperByIterator(list,root);
        
    }

    private List<Integer> preorderHelperByIterator(List<Integer> list, Node root) {
        if (root == null){
            return list;
        }
        Stack<Node> stack = new Stack<>();
        //入队时根右左，出队时根左右，按出队顺序放入结果集就是前序遍历
        stack.push(root);
        while (!stack.empty()){
            //一进来先把根出列
            Node cur = stack.pop();
            //按照出队顺序放入结果集
            list.add(cur.val);
            //进队按照根右左
            for (int i = cur.children.size()-1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
        }
        return list;
    }

    private List<Integer> preorderHelper(List<Integer> list, Node root) {
        //根左右的顺序
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Node child : root.children) {
            preorderHelper(list,child);
        }
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
