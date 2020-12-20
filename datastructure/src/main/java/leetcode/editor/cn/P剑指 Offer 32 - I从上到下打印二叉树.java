//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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
// 👍 52 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import leetcode.editor.cn.common.TreeNode;

//Java：从上到下打印二叉树
public class P剑指 Offer 32-I从上到下打印二叉树{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 32-I从上到下打印二叉树().new Solution();
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

    public int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[0];
        }
        /*List<List<Integer>> res = new ArrayList<>();
        this.recursion(root,res,0);

        List<Integer> result = new ArrayList<>();
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                result.add(integer);
            }
        }
        int[] level = result.stream().mapToInt(i->i).toArray();
        return level;*/
        return method2(root);
    }

    /**
     * BFS
     * @param root
     * @return
     */
    private int[] method2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    /**
     * 方法一：迭代法层序遍历
     * @param root
     * @param res
     * @param i
     * @return
     */
    private List<List<Integer>> recursion(TreeNode root, List<List<Integer>> res, int level) {
        if (res.size()-1<level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left != null){
            recursion(root.left,res,level+1);
        }
        if (root.right != null){
            recursion(root.right,res,level+1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
