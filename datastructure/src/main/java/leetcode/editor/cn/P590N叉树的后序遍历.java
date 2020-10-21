//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 104 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：N叉树的后序遍历
public class P590N叉树的后序遍历 {

    public static void main(String[] args) {
        Solution solution = new P590N叉树的后序遍历().new Solution();
        // TO TEST
    }

    class Node {

        public int val;

        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

    }

    ;
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.

*/

    class Solution {

        public List<Integer> postorder(Node root) {
            /**
             * 方法一：使用迭代的方式
             */
            /*List<Integer> list = new ArrayList<>();
            return this.postorderHelper(list, root);*/
            /**
             * 方法二：使用递归的方式，由于前序遍历是左右根，反过来就是根右左，我们将节点按照这个顺序入栈，之后再出栈即可
             * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/solution/marveljian-dan-de-xue-xi-bi-ji-590-by-tyanyonecanc/
             */
            LinkedList<Integer> list = new LinkedList<>();
            return this.postorderHelperByIterator(list,root);



        }

        private List<Integer> postorderHelperByIterator(LinkedList<Integer> list, Node root) {
            if (root == null) {
                return list;
            }
            Stack<Node> stack = new Stack<>();
            //进队列时根左右，出队列时根右左，按出队列顺序从头结点加入结果集就是左右根后序遍历
            //入队，根
            stack.push(root);
            while (!stack.empty()){

                //出队根右左，一进来先把根出列
                Node cur = stack.pop();
                list.addFirst(cur.val);
                //入队左右
                for (int i = 0; i < cur.children.size(); i++) {
                    stack.push(cur.children.get(i));
                }
            }
            return list;
        }

        private List<Integer> postorderHelper(List<Integer> list, Node root) {
            if (root == null) {
                return list;
            }
            //左右根
            if (root.children == null || root.children.size() == 0){
                list.add(root.val);
                return list;
            }
            for (int i = 0; i < root.children.size(); i++) {
                postorderHelper(list,root.children.get(i));
            }
            list.add(root.val);
            return list;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
