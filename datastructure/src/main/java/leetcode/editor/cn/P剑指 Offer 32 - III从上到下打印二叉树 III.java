//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 
// 👍 58 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import leetcode.editor.cn.common.TreeNode;

//Java：从上到下打印二叉树 III
public class P剑指 Offer 32-III从上到下打印二叉树 III{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 32-III从上到下打印二叉树 III().new Solution();
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
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        //return levelOrderHelper(root,res,0);
        return method2(root,res);

    }

    private List<List<Integer>> method2(TreeNode root, List<List<Integer>> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null){
                    continue;
                }
                if (index % 2 ==0){
                    curLevel.add(cur.val);
                }else{
                    curLevel.add(0,cur.val);
                }
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            //处理完本层之后，下一层index增加
            index++;
            if (!curLevel.isEmpty()){
                res.add(curLevel);
            }
        }
        return res;
    }

    /**
     * 方法一DFS
     * @param root
     * @param res
     * @param level
     * @return
     */
    private List<List<Integer>> levelOrderHelper(TreeNode root, List<List<Integer>> res, int level) {
        if (res.size()-1<level){
            res.add(new LinkedList<>());
        }
        if(level % 2 == 0){
            res.get(level).add(root.val);
        }else{
            res.get(level).add(0, root.val);
        }
        if (root.left != null){
            levelOrderHelper(root.left,res,level+1);
        }
        if (root.right != null){
            levelOrderHelper(root.right,res,level+1);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
