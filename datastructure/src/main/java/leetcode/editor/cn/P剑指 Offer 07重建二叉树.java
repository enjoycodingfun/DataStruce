//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 264 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import leetcode.editor.cn.common.TreeNode;

//Java：重建二叉树
public class P剑指 Offer 07重建二叉树{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 07重建二叉树().new Solution();
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
    int[] preorder;
    Map<Integer,Integer> map = new HashMap<>();
    /**
     * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
     * 参考题解如上：
     * 主要含义，首先通过前序遍历第一位确定根节点坐标root对应的值，之后根据中序遍历将子树分为左子树|root|右子树
     * 之后递归遍历左右子树，假设当前递归的前序遍历根节点坐标为root（第一次为0）,左边界在中序遍历中坐标值为left（第一次为0），右边界为right(第一次为inorder.length-1)
     * 那么对于左子树，它在前序遍历中根节点节点值为preorder[root+1],左边界在中序遍历中坐标值为left，右边界坐标值为i-1（i是根节点root在中序遍历的坐标值）
     * 对于右子树，他在前序遍历中根节点的节点值为preorder[root+（i-left）+1]，左边界在中序遍历中坐标值为i+1，右边界坐标值为right
     * 解释下为什么右子树的根节点是preorder[root+（i-left）+1]，首先对于前序遍历根左右来说，假如根节点坐标值为root,那么左子树的根节点坐标值就是root+1，
     * 而右子树的根节点坐标值应该是root+左子树的长度+1，在上文中左子树长度应该就是i-left
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTreeHelp(0,0,inorder.length-1);


    }

    private TreeNode buildTreeHelp(int root, int left, int right){
        if (left>right){
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[root]);
        int rootIndex = map.get(preorder[root]);
        rootNode.left = buildTreeHelp(root+1,left,rootIndex-1);
        rootNode.right = buildTreeHelp(root+rootIndex-left+1,rootIndex+1,right);
        return rootNode;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
