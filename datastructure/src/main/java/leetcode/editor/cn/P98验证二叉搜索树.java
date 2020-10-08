//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 798 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：验证二叉搜索树
public class P98验证二叉搜索树 {

    public static void main(String[] args) {
        Solution solution = new P98验证二叉搜索树().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/er-cha-sou-suo-shu-cao-zuo-ji-jin
     */
    class Solution {

        long pre = Long.MIN_VALUE;
        //TreeNode pre = null;

        public boolean isValidBST(TreeNode root) {
            /**
             * 方法二
             */
        if (root == null) {
            return true;
        }
        //访问左子树
        if (!isValidBST(root.left)){
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre){
            return false;
        }
        pre = root.val;
        //访问右子树
        return isValidBST(root.right);
            //方法三针对方法二进行改进，少一些比较
            /*if (root == null) {
                return true;
            }
            if (!isValidBST(root.left)) {
                return false;
            }
            //这里用于判断是不是找到最左边的节点了，如果是就不用比较
            if (pre == null) {
                pre = root;
            }
            //如果不是就比较这个节点和其左节点
            else if (root.val <= pre.val) {
                return false;
            }
            pre = root;
            return isValidBST(root.right);*/

            /**
             * 思路，套用二叉树的框架，先搞清楚本节点应该做什么事情，之后递归其他节点交给框架递归函数
             * 本题中要验证二叉搜索树，根节点需要大于所有的左子树节点，同时小于所有的右子树节点，我们无法一个个比较，
             * 所以应该定义两个辅助节点max和min，对于左子树来说，max是root，对于右子树来说min是root
             */
            //return isValidBST(root,null,null); 方法一


        }
        //方法一
    /*private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val){
            return false;
        }
        if (max != null && root.val >= max.val){
            return false;
        }
        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }*/
        /**
         * 方法二可以采用中序遍历，在遍历过程中每一个遍历到的节点与前一个节点比较，如果小于或等于前一个节点，说明不是BST
         * 中序遍历即左根右遍历
         */


    }
//leetcode submit region end(Prohibit modification and deletion)

}
