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

import java.util.Deque;
import java.util.LinkedList;
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
            //方法一：调用递归函数，比较左右节点
            //return isMirror(root.left,root.right);
            //方法二：对列，https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
            //创建保存节点的对列
            Deque<TreeNode> deque = new LinkedList<>();
            //先将左右节点放进去
            deque.add(root.left);
            deque.add(root.right);
            //以此放进对称节点并比较
            while (!deque.isEmpty()){
                TreeNode left = deque.removeFirst();
                TreeNode right = deque.removeFirst();
                if (right == null && left == null) {
                    //注意这里是continue，继续比较
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }
                if (left.val != right.val){
                    return false;
                }
                //之后依次放入对称节点
                deque.add(left.left);
                deque.add(right.right);
                deque.add(left.right);
                deque.add(right.left);
            }
            return true;
        }

        private boolean isMirror(TreeNode left, TreeNode right) {
            if (right == null && left == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
