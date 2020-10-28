//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 676 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import leetcode.editor.cn.common.TreeNode;

//Java：二叉树的层序遍历
public class P102二叉树的层序遍历{
    public static void main(String[] args) {
        Solution solution = new P102二叉树的层序遍历().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
         * 方法一：深度优先遍历
         * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/tao-mo-ban-bfs-he-dfs-du-ke-yi-jie-jue-by-fuxuemin/
         */
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            dfs(res,root,0);
        }
        return res;
    }
    private void dfs(List<List<Integer>> res, TreeNode node, int level) {
        if (res.size()-1<level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        if (node.left!=null){
            dfs(res,node.left,level+1);
        }
        if (node.right!=null){
            dfs(res,node.right,level+1);
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
