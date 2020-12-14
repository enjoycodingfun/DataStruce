//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 99 👎 0


package leetcode.editor.cn;

//Java：数值的整数次方
public class P剑指 Offer 16数值的整数次方{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 16数值的整数次方().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public double myPow(double x, int n) {

        //return method1(x, n);
        return method2(x,n);

    }
    /**
     * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/fei-di-gui-he-di-gui-de-liang-chong-jie-jue-fang-s/
     * @param x
     * @param n
     * @return
     */
    private double method2(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0 ; i=i/2,x *= x) {
            if (i%2!=0) {
                res *= x;
            }
        }
        return n<0?1/res:res;
    }

    private double method1(double x, int n) {
        if (n == 0) {
            return 1;
        }else if (n < 0){
            //如果n小于0，把它改为正数，并且把1/x提取出来一个
            return 1/x*method1(1/x,-n-1);
        }else{
            return (n%2==0)?method1(x*x,n/2):x*method1(x*x,n/2);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
