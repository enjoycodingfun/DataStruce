//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 163 👎 0


package leetcode.editor.cn;

//Java：把数字翻译成字符串
public class P剑指 Offer 46把数字翻译成字符串{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 46把数字翻译成字符串().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int translateNum(int num) {
        //方法一：使用递归方法
        return recursion(num);
    }

    private int recursion(int num) {
        if (num <= 9){
            return 1;
        }
        //取后两位数字
        int tail = num%100;
        //如果后两位数字本身已经大于26或者十位数字为0，就没法递归拆分了
        if (tail <=9 || tail >= 26){
            return recursion(num/10);
        }
        return recursion(num/10)+recursion(num/100);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
