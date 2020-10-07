//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 322 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import leetcode.editor.cn.common.TreeNode;

//Java：二叉树的前序遍历
public class P144二叉树的前序遍历{
    public static void main(String[] args) {
        Solution solution = new P144二叉树的前序遍历().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/
class Solution {

    /***
     * 第一种方案使用递归方法来解决
     * @param root
     * @return
     */
    /*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        this.preorder(root,tree);
        return tree;
    }

    private List<Integer> preorder(TreeNode root, List<Integer> tree) {
        if (root == null){
            return tree;
        }
        tree.add(root.val);
        if (null != root.left){
            preorder(root.left,tree);
        }
        if (null != root.right){
            preorder(root.right,tree);
        }
        return tree;
    }*/

    /**
     * 下面使用迭代的方法，迭代过程中利用栈，因为前序遍历是根左右的顺序，那么进栈的顺序与之相反为左根右，之后顺序出栈
     * 我们这里采用一种处理方式，对于根节点，开始遍历前直接入栈，之后在遍历左右子树的时候先让根节点出栈再将左右子树入栈
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        this.preorder(root,tree);
        return tree;
    }

    private List<Integer> preorder(TreeNode root, List<Integer> tree) {
        if (root == null) {
            return tree;
        }
        Stack<TreeNode> stack = new Stack<>();
        //先将头节点入栈
        stack.push(root);
        //之后遍历右左节点入栈，在此循环过程中如果遇到根节点就先出栈
        while (!stack.empty()){
            TreeNode treeNode = stack.pop();
            tree.add(treeNode.val);
            //接下来按照先右后左的进栈
            if (treeNode.right != null){
                stack.push(treeNode.right);
            }
            if (treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
        return tree;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
