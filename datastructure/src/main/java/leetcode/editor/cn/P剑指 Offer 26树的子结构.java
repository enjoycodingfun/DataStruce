//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 157 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.common.TreeNode;

//Java：树的子结构
public class P剑指 Offer 26树的子结构{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 26树的子结构().new Solution();
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

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recursion(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean recursion(TreeNode a, TreeNode b) {
        //如果b为null说明B已经访问完毕，确定B是A的子树
        if ( b == null) {
            return true;
        }
        //如果a为空或者a的值不等于b的值，说明b不是a的子树，直接返回fasle（注意这里在上面考虑了b和a的根节点，左右子节点对比的情况，所以才会这样）
        if (a == null || a.val != b.val){
            return false;
        }
        //对比左右节点
        return recursion(a.left,b.left)&&recursion(a.right,b.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
