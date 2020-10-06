//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
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
// Related Topics 树 深度优先搜索 数组 
// 👍 705 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：从前序与中序遍历序列构造二叉树
public class P105从前序与中序遍历序列构造二叉树{
    public static void main(String[] args) {
        Solution solution = new P105从前序与中序遍历序列构造二叉树().new Solution();
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
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         * 题目思路：前序遍历顺序是根左右，中序为左根右，所以根据前序遍历找到根节点（第一个元素），然后在中序遍历中找到与
         * 根节点相同值的下标index（树中没有重复值），此时对于中序遍历来说，从0-（index-1)为左子树节点，从（index+1）-end
         * 是右子树的节点，对于前序遍历来说，从根节点后面一个到leftsize-1（这个节点数根据中序遍历确认）下标为左子树，后面的为右子树
         * 之后递归的构造左右子树即可
         */
        if (preorder == null || inorder == null){
            return null;
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //base case
        if (preStart > preEnd){
            return null;
        }
        //1.根据前序遍历找到根节点
        int rootVal = preorder[preStart];
        //2.根据中序遍历找到根节点下标以确定左右子树的节点数量
        int index = 0;
        //注意这里遍历的起点和终点不能直接填0，和inorder.length，因为后面需要递归调用这个函数，每次的函数起点应该是inStart，终点是inEnd
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        //根据index可以知道左右子树节点的个数
        int leftSize = index - inStart;
        //构建根节点
        TreeNode root = new TreeNode(rootVal);
        //左右子树递归调用
        //对于前序遍历来说，preStart是根节点，左子树是preStart+1,(preStart+1)+leftSize-1之间的节点；对于中序遍历来说，左子树是inStart,index-1之间的节点
        root.left = build(preorder,preStart+1,preStart+leftSize,inorder,inStart,index-1);
        //对于前序遍历来说，右子树是preStart+leftSize+1,preEnd之间的节点；对于中序遍历来说，右子树是index+1,inEnd之间的节点；
        root.right = build(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
