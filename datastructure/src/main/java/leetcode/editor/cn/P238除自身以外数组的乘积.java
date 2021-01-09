//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 
// 👍 686 👎 0


package leetcode.editor.cn;
//Java：除自身以外数组的乘积
public class P238除自身以外数组的乘积{
    public static void main(String[] args) {
        Solution solution = new P238除自身以外数组的乘积().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 原理对于数组[1,2,3,4]来说，乘积数组规律如下
     *      1  2  3  4
     *   1  1  2  3  4 =>res[0]=1*2*3*4=24
     *   2  1  1  3  4 =>res[1]=1*1*3*4=12
     *   3  1  2  1  4 =>res[2]=1*2*1*4=8
     *   4  1  2  3  1 =>res[3]=1*2*3*1=6
     *对于每一个下标来说，该下标对应数字变为1，之后构建其左右两边的乘积即可，在该示例中也就是
     * 对于中间的结果集来说，先构建下标左边的乘积，再构建下标右边的乘积即可，比如，
     * 当下标为0时，对应数字为1，将其本身置为1，左边没有数字，我们定为1，右边的数字为234,乘起来即可
     * 当下标为1时，对应数字为2，将其本身置为1，左边数字为1，右边数字为3,4，乘起来即可
     */
    class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        //先构建每一行左边的数字乘积，规律在于下一行的乘积等于上一行数字左半边乘积乘以当前下标前一个数字
        //比如res[2]左半边=res[1]左半边*nums[2-1]
        int[] res = new int[nums.length];
        res[0] = 1;
        int right = 1;//初始化的右半边值
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1]*nums[i-1];
        }
        //再构建右边同时乘起来，右半边的规律是从下往上找的，比如res[2]右半边=res[3]右半边*nums[3]
        for (int i = nums.length-2; i >=0; i--) {
            right *= nums[i+1];
            res[i] *= right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
