//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 1 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 98 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：平衡二叉树
public class P剑指 Offer 55 - II平衡二叉树{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 55 - II平衡二叉树().new Solution();
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
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        /*return Math.abs(depth(root.left)-depth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);*/
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = height(root.left);
        if (left == -1){
            //左子树不是平衡二叉树，剪枝
            return -1;
        }
        int right = height(root.right);
        if (right == -1){
            //右子树不是平衡二叉树，剪枝
            return -1;
        }
        return Math.abs(height(root.left)-height(root.right))<2?Math.max(left,right)+1:-1;
    }

    //计算树深度的方法
    private int depth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right))+1;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}
