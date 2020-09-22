//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 714 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的中序遍历
public class P94二叉树的中序遍历{

    public static void main(String[] args) {
        Solution solution = new P94二叉树的中序遍历().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

  public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
     }
  }


class Solution {

    /**
     * 以下是递归方式做
     * @param root
     * @return
     */
   /* public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return this.inorder(list,root);
    }

    private List<Integer> inorder(List<Integer> list, TreeNode root) {
        if (root == null){
            return list;
        }
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
        return list;
    }*/
    /**
     * 下面采用迭代的方式做,一直遍历左子树直到其没有左子树为止，开始出栈，出栈后将元素加入集合，之后访问元素的右子树
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            //当遍历到没有左子树的时候，开始出栈然后加入集合
            root = stack.pop();
            list.add(root.val);
            //之后开始遍历右子树节点
            root = root.right;
        }
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
