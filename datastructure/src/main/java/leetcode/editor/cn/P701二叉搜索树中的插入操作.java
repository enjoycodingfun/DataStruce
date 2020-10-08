//给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不
//同。 
//
// 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。 
//
// 
//
// 例如, 
//
// 给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和 插入的值: 5
// 
//
// 你可以返回这个二叉搜索树: 
//
//          4
//       /   \
//      2     7
//     / \   /
//    1   3 5
// 
//
// 或者这个树也是有效的: 
//
//          5
//       /   \
//      2     7
//     / \   
//    1   3
//         \
//          4
// 
//
// 
//
// 提示： 
//
// 
// 给定的树上的节点数介于 0 和 10^4 之间 
// 每个节点都有一个唯一整数值，取值范围从 0 到 10^8 
// -10^8 <= val <= 10^8 
// 新值和原始二叉搜索树中的任意节点值都不同 
// 
// Related Topics 树 
// 👍 130 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：二叉搜索树中的插入操作
public class P701二叉搜索树中的插入操作{
    public static void main(String[] args) {
        Solution solution = new P701二叉搜索树中的插入操作().new Solution();
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        /**
         * 老套路，套用框架，当找到新的插入位置的时候，创建新的节点插入,
         * 一旦涉及“改”，函数就要返回 TreeNode 类型，并且对递归调用的返回值进行接收。
         */
        if (root == null){
            return new TreeNode(val);
        }
        if (root.val > val){
            //注意这里需要对递归调用的返回值进行接收
            root.left = insertIntoBST(root.left,val);
        }
        if (root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
