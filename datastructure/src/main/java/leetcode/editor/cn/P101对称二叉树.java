//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1078 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import leetcode.editor.cn.common.TreeNode;

//Java：对称二叉树
public class P101对称二叉树 {

    public static void main(String[] args) {
        Solution solution = new P101对称二叉树().new Solution();
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
     */
    class Solution {

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            //中序遍历后判断是否是回文字符串
            if (root.right == null && root.left == null) {
                return true;
            }
            if (root.left == null || root.right == null) {
                return false;
            }
            //接下来中序遍历后判断是否是回文字符串
            List<Integer> res = new ArrayList<>();
            List<Integer> inorder = inorder(res, root);
            //如果是对称的，一定是奇数个节点
            if (inorder.size() % 2 == 0) {
                return false;
            }
            int i = inorder.size() / 2 - 1;
            int j = inorder.size() / 2 + 1;
            while (i >= 0 && j <= inorder.size() - 1) {
                if (!inorder.get(i).equals(inorder.get(j))) {
                    return false;
                }
                i--;
                j++;
            }
            return true;
        }

        private List<Integer> inorder(List<Integer> res, TreeNode root) {
            /**
             * 中序遍历
             */
            if (root == null) {
                return res;
            }
            inorder(res, root.left);
            res.add(root.val);
            inorder(res, root.right);
            return res;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
