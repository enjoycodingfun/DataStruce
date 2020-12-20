//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
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
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 68 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import leetcode.editor.cn.common.TreeNode;

//Java：从上到下打印二叉树 II
public class P剑指 Offer 32-II从上到下打印二叉树 II{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 32-II从上到下打印二叉树 II().new Solution();
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        //return levelOrderHelper(root,res,0);
        return method2(root, res);

    }

    private List<List<Integer>> method2(TreeNode root, List<List<Integer>> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                curLevel.add(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            if (curLevel.size() != 0){
                res.add(curLevel);
            }
        }
        return res;
    }

    /**
     * 方法一：迭代法
     */
    private List<List<Integer>> levelOrderHelper(TreeNode root, List<List<Integer>> res, int level) {
        if (res.size() - 1 < level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left != null) {
            levelOrderHelper(root.left, res, level + 1);
        }
        if (root.right != null) {
            levelOrderHelper(root.right, res, level + 1);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
