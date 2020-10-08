//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。 
//
// 例如， 
//
// 
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
// 
//
// 你应该返回如下子树: 
//
// 
//      2     
//     / \   
//    1   3
// 
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。 
// Related Topics 树 
// 👍 93 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：二叉搜索树中的搜索
public class P700二叉搜索树中的搜索{
    public static void main(String[] args) {
        Solution solution = new P700二叉搜索树中的搜索().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/er-cha-sou-suo-shu-cao-zuo-ji-jin
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        /**
         * 思路：还是套用框架递归调用，把根节点该做的事情做完，之后的事情交给递归框架
         */
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            //说明搜索的数字在左边，应该找左子树
           return searchBST(root.left,val);
        }
        if (root.val < val) {
            //说明搜索的数字在右边，应该找右子树
           return searchBST(root.right,val);
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
