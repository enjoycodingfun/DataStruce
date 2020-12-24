//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 79 👎 0


package leetcode.editor.cn;

//Java：数字序列中某一位的数字
public class P剑指 Offer 44数字序列中某一位的数字{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 44数字序列中某一位的数字().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 参考题解：
     * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        //先计算在那个位数上
        int digit = 1;//几位数
        long start = 1;//起始数字（本题解以1位起始数字）
        long count = 9;//该位数的数字共有多少个
        while (n > count){
            n -= count;
            digit += 1;
            start *= 10;
            count = digit*start*9;
        }
        long num = start + (n-1)/digit;//计算出在第几个数字上
        int res = String.valueOf(num).charAt((n-1)%digit)-'0';
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
