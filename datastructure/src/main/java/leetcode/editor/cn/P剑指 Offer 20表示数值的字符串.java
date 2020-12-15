//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 129 👎 0


package leetcode.editor.cn;

//Java：表示数值的字符串
public class P剑指 Offer 20表示数值的字符串{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 20表示数值的字符串().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean numGet = false;
        boolean dotGet = false;
        boolean eGet = false;
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                numGet = true;
            } else if (str[i] == '.') {
                //.之前不能出现e或者点
                if (dotGet || eGet) {
                    return false;
                }
                dotGet = true;
            }else if (str[i] == 'e' || str[i] == 'E'){
                //e之前不能出现e，必须出现数字
                if (eGet || !numGet){
                    return false;
                }
                eGet = true;
                numGet = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            }else if (str[i] == '-' || str[i] == '+'){
                //符号位在第一位或者e后面才是合法的
                if (i != 0&&str[i-1]!='e'&&str[i-1]!='E'){
                    return false;
                }
            }else {
                return false;
            }
        }
        return numGet;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


