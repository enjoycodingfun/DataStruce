//请你来实现一个 atoi 函数，使其能将字符串转换成整数。 
//
// 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下： 
//
// 
// 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。 
// 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。 
// 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。 
// 
//
// 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。 
//
// 在任何情况下，若函数不能进行有效的转换时，请返回 0 。 
//
// 提示： 
//
// 
// 本题中的空白字符只包括空格字符 ' ' 。 
// 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231 − 1]。如果数值超过这个范围，请返回 INT_MAX (231
// − 1) 或 INT_MIN (−231) 。 
// 
//
// 
//
// 示例 1: 
//
// 输入: "42"
//输出: 42
// 
//
// 示例 2: 
//
// 输入: "   -42"
//输出: -42
//解释: 第一个非空白字符为 '-', 它是一个负号。
//     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
// 
//
// 示例 3: 
//
// 输入: "4193 with words"
//输出: 4193
//解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
// 
//
// 示例 4: 
//
// 输入: "words and 987"
//输出: 0
//解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//     因此无法执行有效的转换。 
//
// 示例 5: 
//
// 输入: "-91283472332"
//输出: -2147483648
//解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
//     因此返回 INT_MIN (−231) 。
// 
// Related Topics 数学 字符串 
// 👍 907 👎 0


package leetcode.editor.cn;

//Java：字符串转换整数 (atoi)
public class P8字符串转换整数(atoi) {

    public static void main(String[] args) {
        Solution solution = new P8字符串转换整数(atoi) ().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int myAtoi(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            return method1(s);

        }

        /**
         * 参考题解：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/jin-liang-bu-shi-yong-ku-han-shu-nai-xin-diao-shi-/
         * @param str
         * @return
         */

        private int method1(String str) {
            int len = str.length();
            char[] chars = str.toCharArray();

            //1.跳过前面的空格
            int index = 0;
            while (index<len&&chars[index]==' '){
                index++;
            }
            //2.如果此时已经遍历完了，说明全是空格，就直接返回0
            if (index == len){
                return 0;
            }
            //3.如果出现符号位，仅第一个有效，并且要记录正负
            int sign = 1;
            char firstChar = chars[index];
            if (firstChar == '-'){
                index++;
                sign = -1;
            }else if (firstChar == '+'){
                index++;
            }


            //4.转换后续出现的数字字符，不能使用long类型
            int res = 0;
            while (index < len){
                char curChar = chars[index];
                //按照示例4除符号位如果不是数字开头的直接无法转换返回
                if (curChar < '0'||curChar > '9'){
                    break;
                }
                //提前预判res加上当前字符串后是否会越过int类型的上线界限
                if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && curChar - '0' > Integer.MAX_VALUE%10)){
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && curChar - '0' > -(Integer.MIN_VALUE%10))){
                    return Integer.MIN_VALUE;
                }
                //没有上述异常的情况就拼接,注意每次拼接都要乘以sign，否则就变成负数加正数或正数加负数了
                res = res*10 + sign*(curChar-'0');
                index++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
