//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 517 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：二叉树的直径
public class P543二叉树的直径{
    public static void main(String[] args) {
        Solution solution = new P543二叉树的直径().new Solution();
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
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/liang-chong-si-lu-shi-yong-quan-ju-bian-liang-yu-b/
 */
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);
        return max;
    }

    private int calculate(TreeNode root) {
        if (root == null){return 0;}
        int left = calculate(root.left);
        int right = calculate(root.right);
        max = Math.max(max,left+right);
        return 1+Math.max(left,right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
