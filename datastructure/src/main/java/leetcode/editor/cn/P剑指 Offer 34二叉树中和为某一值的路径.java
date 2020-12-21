//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 111 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import leetcode.editor.cn.common.TreeNode;

//Java：二叉树中和为某一值的路径
public class P剑指 Offer 34二叉树中和为某一值的路径{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 34二叉树中和为某一值的路径().new Solution();
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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        //dfs(root,sum,new ArrayList<>(),res);
        dfs2(root,sum,new ArrayList<>(),res);
        return res;

    }

    /**
     * 回溯算法
     * @param root
     * @param sum
     * @param arr
     * @param res
     */
    private void dfs2(TreeNode root, int sum, List<Integer> arr, List<List<Integer>> res) {
        if (root == null){
            return;
        }
        arr.add(root.val);
        if (root.left == null && root.right == null){
            if (sum == root.val){
                res.add(new ArrayList<>(arr));
            }
            //回溯
            arr.remove(arr.size()-1);
            return;
        }
        //否则的话继续下探节点,此时sum的值要减去root值
        dfs(root.left,sum-root.val,arr,res);
        dfs(root.right,sum-root.val,arr,res);
        //回溯
        arr.remove(arr.size()-1);
    }

    private void dfs(TreeNode root, int sum, List<Integer> arr, List<List<Integer>> res) {
        if (root == null){
            return;
        }
        //每次传递都要新建一个list防止分支污染
        List<Integer> subList = new ArrayList<>(arr);
        subList.add(root.val);
        if (root.left == null && root.right == null){
            if (sum == root.val){
                res.add(subList);
            }
            //已经是叶子节点了，直接返回
            return;
        }
        //否则的话继续下探节点,此时sum的值要减去root值
        dfs(root.left,sum-root.val,subList,res);
        dfs(root.right,sum-root.val,subList,res);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
