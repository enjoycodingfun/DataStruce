//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i
//+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 69 👎 0


package leetcode.editor.cn;
//Java：构建乘积数组
public class P剑指 Offer 66构建乘积数组{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 66构建乘积数组().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0){
            return new int[0];
        }
        int[] res = new int[a.length];
        res[0] = 1;
        int right = 1;
        for (int i = 1; i < a.length; i++) {
            res[i] = res[i-1]*a[i-1];
        }
        for (int i = a.length-2; i >=0 ; i--) {
            right *= a[i+1];
            res[i] *= right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
