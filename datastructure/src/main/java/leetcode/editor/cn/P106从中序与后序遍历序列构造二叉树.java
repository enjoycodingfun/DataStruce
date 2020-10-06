//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 382 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：从中序与后序遍历序列构造二叉树
public class P106从中序与后序遍历序列构造二叉树{
    public static void main(String[] args) {
        Solution solution = new P106从中序与后序遍历序列构造二叉树().new Solution();
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
 * https://mp.weixin.qq.com/s/OlpaDhPDTJlQ5MJ8tsARlA
 * 与题目P105类似
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /**
         * 题目思路：中序为左根右，后序遍历是左右根，所以根据后序遍历找到根节点（最后一个元素），然后在中序遍历中找到与
         * 根节点相同值的下标index（树中没有重复值），此时对于中序遍历来说，从0-（index-1)为左子树节点，从（index+1）-end
         * 是右子树的节点，对于后序遍历来说，从根节点后面一个到0-（leftsize-1）（这个节点数根据中序遍历确认）下标为左子树，后面的为右子树
         * 之后递归的构造左右子树即可
         */
        if (inorder == null || postorder == null){
            return null;
        }
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd){
            return null;
        }
        //1.根据后序遍历找到根节点
        int rootVal = postorder[postEnd];
        //2.根据中序遍历找到根节点在中序中的下标值（这个地方可以优化为从hashmap取值）
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        //构建根节点
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;
        //递归构建左右子树
        //对于中序遍历来说，左子树是inStart,index-1之间的节点；对于后序遍历来说，postEnd是根节点，左子树是postStart,postStart+leftSize-1之间的节点；
        root.left = build(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
        //对于中序遍历来说，右子树是index+1,inEnd之间的节点；对于后序遍历来说，postEnd是根节点，右子树是（postStart+leftSize-1）+1,postEnd-1之间的节点；
        root.right = build(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
