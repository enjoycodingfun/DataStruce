//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 156 👎 0


package leetcode.editor.cn;

//Java：二叉搜索树的后序遍历序列
public class P剑指 Offer 33二叉搜索树的后序遍历序列{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 33二叉搜索树的后序遍历序列().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0 || postorder.length == 1) {
            return true;
        }
        return recursion(postorder, 0, postorder.length - 1);

    }

    /**
     * 方法一：递归调用
     * @param postorder
     * @param left
     * @param right
     * @return
     */
    private boolean recursion(int[] postorder, int left, int right) {
        //终止条件：left > right的时候，没有节点就不用看了，等于的时候一个节点也是直接返回true
        if (left >= right){
            return true;
        }
        //先从左往右找到第一个大于根节点的数字，从这里开始到根节点之前都是右子节点
        int mid = left;
        while (postorder[mid] < postorder[right]){
            mid++;
        }
        //跳出循环之后的mid即为第一个大于根节点的值，接下来我们要判断其后面的值是不是都大于根节点，同时因为这个mid待会儿会作为
        //递归判断左右子树的分界点，所以我们用一个临时变量来保存mid值
        int tmp = mid;
        while (tmp < right){
            if (postorder[tmp++] < postorder[right]){
                //右子树部分出现了一个比根节点小的，肯定不是二叉搜索树
                return false;
            }
        }
        //之后递归判断左右子树
        return recursion(postorder,left,mid-1)&&recursion(postorder,mid,right-1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
