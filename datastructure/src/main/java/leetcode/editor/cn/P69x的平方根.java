//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 531 👎 0


package leetcode.editor.cn;

//Java：x 的平方根
public class P69x的平方根 {

    public static void main(String[] args) {
        Solution solution = new P69x的平方根().new Solution();
        // TO TEST
        System.out.println("输出平方根："+solution.mySqrt(2147395599));
    }

    /**
     * 二分查找
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int mySqrt(int x) {
            if (x == 0) {
                return x;
            }
            long start = 1,end = x/2;
            while (start < end){
                // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
                long mid = start + (end-start+1)/2;
                if (mid * mid >x){
                    end = mid-1;
                }else{
                    start = mid;
                }
            }
            return (int) start;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
