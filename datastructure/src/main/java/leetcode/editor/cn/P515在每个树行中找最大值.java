//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 101 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import leetcode.editor.cn.common.TreeNode;

//Java：在每个树行中找最大值
public class P515在每个树行中找最大值 {

    public static void main(String[] args) {
        Solution solution = new P515在每个树行中找最大值().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    /**
     * 本题目类似于二叉树的层序遍历，只是输出每层最大值了
     */
    class Solution {

        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null){
                return res;
            }
            /**
             * 方法一：bfs
             */
            //return bfs(root,res);
            /**
             * 方法二：dfs
             */
            return dfs(root,res,1);

        }

        private List<Integer> dfs(TreeNode root, List<Integer> res, int level) {
            if (root == null){
                return res;
            }
            if (level == res.size()+1){
                //如果走到下一层了直接把当前节点加入到结果集中
                res.add(root.val);
            }else {
                //否则对比当前层level的每个元素和结果集中第level个元素谁大取谁，因为数组下标从0开始，
                //这里level从1开始，所以level需要减一
                res.set(level-1,Math.max(res.get(level-1), root.val ));
            }
            //下面两行DFS核心代码
            dfs(root.left,res,level+1);
            dfs(root.right,res,level+1);
            return res;
        }

        private List<Integer> bfs(TreeNode root, List<Integer> res) {
            if (root == null){
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                //每一层的数量
                int size = queue.size();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if (cur == null){continue;}
                    max = Math.max(max,cur.val);
                    if (cur.left!=null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right!=null) {
                        queue.offer(cur.right);
                    }
                }
                res.add(max);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
