//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下： 
//
// 
// 二叉树的根是数组中的最大元素。 
// 左子树是通过数组中最大值左边部分构造出的最大二叉树。 
// 右子树是通过数组中最大值右边部分构造出的最大二叉树。 
// 
//
// 通过给定的数组构建最大二叉树，并且输出这个树的根节点。 
//
// 
//
// 示例 ： 
//
// 输入：[3,2,1,6,0,5]
//输出：返回下面这棵树的根节点：
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
// 
//
// 
//
// 提示： 
//
// 
// 给定的数组的大小在 [1, 1000] 之间。 
// 
// Related Topics 树 
// 👍 196 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：最大二叉树
public class P654最大二叉树{
    public static void main(String[] args) {
        Solution solution = new P654最大二叉树().new Solution();
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums || nums.length == 0){
            return null;
        }
        /**
         * 题目思路如下：
         * 1.先找到数组中最大的那个数字及其下标i，之后将该数字构造的节点作为根节点
         * 2.之后递归在左右子树上分别调用该函数过程，返回根节点
         */
        return this.buildTree(nums,0,nums.length-1);

    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start>end){return null;}
        //找到数组中的最大值，构建根节点
        int index = 0;//最大值对应的下标
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        //找到最大值后构建根节点
        TreeNode root = new TreeNode(max);
        //之后在左右子树递归调用该函数
        root.left = buildTree(nums,start,index-1);
        root.right = buildTree(nums,index+1,end);
        //返回根节点，如此递归调用得到的结果树即为最大二叉树
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
