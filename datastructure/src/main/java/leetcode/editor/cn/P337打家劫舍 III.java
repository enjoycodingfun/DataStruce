//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 692 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：打家劫舍 III
public class P337打家劫舍 III{
    public static void main(String[] args) {
        Solution solution = new P337打家劫舍 III().new Solution();
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
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        return method1(root);
    }

    /**
     * https://leetcode-cn.com/problems/house-robber-iii/solution/shu-xing-dp-ru-men-wen-ti-by-liweiwei1419/
     * 动态规划
     * @param root
     * @return
     */
    private int method1(TreeNode root) {
        int[] res = dfs(root);
        //返回本节点偷或者不偷的最大结果值
        return Math.max(res[0],res[1]);
    }

    /**
     * 对于每个节点有两种状态，本节点不偷用0表示，本节点偷用1表示
     * @param root
     * @return
     */
    private int[] dfs(TreeNode root) {
        if (root == null){
            return new int[]{0,0};
        }
        //先计算左右子树的最大值
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // dp[0]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点不偷
        // dp[1]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点偷
        int[] dp = new int[2];
        //本节点不偷，那就是左右子树最大的值的和作为最大值
        dp[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        //本节点偷，左右子节点就不偷了
        dp[1] = root.val+left[0]+right[0];
        return dp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
