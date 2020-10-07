//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索 
// 👍 482 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：相同的树
public class P100相同的树{
    public static void main(String[] args) {
        Solution solution = new P100相同的树().new Solution();
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
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //两棵树相同那么按照顺序遍历，得到的结果一定是相同的，所以假设按照前中后顺序遍历，得到的结果肯定一致
        //现在按照递归方式前序遍历两棵树，并加入集合
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        };
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
