//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 104 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import leetcode.editor.cn.common.TreeNode;

//Java：二叉搜索树的第k大节点
public class P剑指 Offer 54二叉搜索树的第k大节点{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 54二叉搜索树的第k大节点().new Solution();
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
    int index = 0;

    public int kthLargest(TreeNode root, int k) {
        if (root == null){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list = method1(root, list);
        return list.get(list.size()-k);
    }

    /**
     * 注意二叉搜索树的中序遍历是递增的，但是我们不需要将所有元素放进去，只要满足够就行，第K大的是第nums.length-k个元素
     * @param root
     * @param k
     * @param list
     * @return
     */
    private List<Integer> method1(TreeNode root, List<Integer> list) {
        if (root == null){
            return list;
        }
        method1(root.left,list);
        list.add(root.val);
        method1(root.right,list);
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
