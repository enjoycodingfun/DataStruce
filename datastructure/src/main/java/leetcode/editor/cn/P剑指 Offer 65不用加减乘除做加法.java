//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// 👍 104 👎 0


package leetcode.editor.cn;
//Java：不用加减乘除做加法
public class P剑指 Offer 65不用加减乘除做加法{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 65不用加减乘除做加法().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 位运算加法，具体参考
         * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/jin-zhi-tao-wa-ru-he-yong-wei-yun-suan-wan-cheng-j/
         * @param a
         * @param b
         * @return
         */
    public int add(int a, int b) {
        while ( b != 0){
            int c = (a&b)<<1;//进位的和为与之后左移一位
            a ^= b;//非进位的和为异或
            //计算两者的和
            b = c;
            /**
             * 下面的更好理解
             * int tempSum = a ^ b; //计算非进位的和
             * int carrySum = a & b << 1;//计算进位和
             * a = tempSum;//递归
             * b = carrySum;//递归
             */

        }
        return a;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
