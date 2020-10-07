//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 399 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的后序遍历
public class P145二叉树的后序遍历{
    public static void main(String[] args) {
        Solution solution = new P145二叉树的后序遍历().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * */
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
     * 以下为递归方式解决
     * @param root
     * @return
     */
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return postorder(list,root);
    }

    private List<Integer> postorder(List<Integer> list, TreeNode root) {
        if (root == null){
            return list;
        }
        postorder(list,root.left);
        postorder(list,root.right);
        list.add(root.val);
        return list;
    }*/
    /**
     * TODO 下面采用非递归方式
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        //stack1主要做中转站，stack2按照最终遍历的反向顺序入栈（即根右左）
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        //根节点先入stack1
        stack1.push(root);
        while (!stack1.empty()){
            //从stack1出栈后进入stack2
            TreeNode treeNode = stack1.pop();
            stack2.push(treeNode);
            //根已经进入stack2，接下来就是右节点，然后是左节点进入stack2，由于需要通过stack1中转
            //所以此时左右节点进入stack1的顺序应该是先左，再右，这样将来从stack1出来进入stack2的顺序才满足先右节点，再左节点
            if (treeNode.left != null){
                stack1.push(treeNode.left);
            }
            if (treeNode.right != null){
                stack1.push(treeNode.right);
            }
        }
        //接下来将stack2中的元素按照顺序出栈即可
        while (!stack2.empty()){
            list.add(stack2.pop().val);
        }
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
