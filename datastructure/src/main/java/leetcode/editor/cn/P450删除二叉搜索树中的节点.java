//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 
// 👍 299 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：删除二叉搜索树中的节点
public class P450删除二叉搜索树中的节点{
    public static void main(String[] args) {
        Solution solution = new P450删除二叉搜索树中的节点().new Solution();
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
 * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/er-cha-sou-suo-shu-cao-zuo-ji-jin
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        /**
         * 套用二叉搜索树的框架
         */
        if (root == null) {
            return null;
        }
        if (root.val == key){
            //假如该节点只有一个左子树或者一个右子树，只要将该节点置为null，并用该节点的左或者右节点替换自己即可,如果该节点没有左右子节点，直接返回null即可
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            //这种情况下，根据题意，我们可以采用该节点左子树最大的值或者右子树最小的值（最接近root）来替换该节点的值，这里采用第一种
            //找到左子树的最大节点
            TreeNode leftMax = getMax(root.left);
            //替换root的值
            root.val = leftMax.val;
            //之后递归删除leftMax，这个时候目标值就是原来的leftMax了，别忘了接收返回值
            root.left = deleteNode(root.left,leftMax.val);
        }else if (root.val > key){
            //这种情况说明key在root的左子树，所以去删除左子树中对应的值
            root.left = deleteNode(root.left,key);
        }else if (root.val < key){
            //这种情况说明key在root的右子树，所以去删除右子树中对应的值
            root.right = deleteNode(root.right,key);
        }
        return root;
    }

    private TreeNode getMax(TreeNode root) {
        //BST树最右边的就是最大的
        while (root.right != null){
            root = root.right;
        }
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
