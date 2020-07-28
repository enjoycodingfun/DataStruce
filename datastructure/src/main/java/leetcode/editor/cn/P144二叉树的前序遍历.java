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
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
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
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
