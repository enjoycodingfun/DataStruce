//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 571 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：二叉树展开为链表
public class P114二叉树展开为链表{
    public static void main(String[] args) {
        Solution solution = new P114二叉树展开为链表().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * https://mp.weixin.qq.com/s/izZ5uiWzTagagJec6Y7RvQ
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        //题目分三步，第一步将左右子树递归的展开成链表
        flatten(root.left);
        flatten(root.right);
        //后序遍历
        TreeNode left = root.left;
        TreeNode right = root.right;

        //第二步将左子树放在右子树位置
        root.left = null;
        root.right = left;
        //第三步将原来的右子树接在新的右子树右边
        TreeNode cur = root;
        while (cur.right != null){
            //不断遍历找到新的右子树（即原来的左子树）的最右边的节点
            cur = cur.right;
        }
        //将展开后的right子树接到这个新的节点的右子树上
        cur.right = right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
