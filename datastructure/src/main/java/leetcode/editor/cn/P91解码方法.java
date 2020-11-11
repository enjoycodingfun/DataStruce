//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 题目数据保证答案肯定是一个 32 位的整数。 
//
// 
//
// 示例 1： 
//
// 输入："12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 输入："226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 输入：s = "0"
//输出：0
// 
//
// 示例 4： 
//
// 输入：s = "1"
//输出：1
// 
//
// 示例 5： 
//
// 输入：s = "2"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可以包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 555 👎 0


package leetcode.editor.cn;

//Java：解码方法
public class P91解码方法 {

    public static void main(String[] args) {
        Solution solution = new P91解码方法().new Solution();
        // TO TEST
    }

    /**
     * 动态规划dp[i] = dp[i-1]+2
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numDecodings(String s) {
            int len = s.length();
            int end = 1;
            int cur = 0;
            if (s.charAt(len - 1) != '0') {
                cur = 1;
            }
            for (int i = len - 2; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    end = cur;//end 前移
                    cur = 0;
                    continue;
                }
                int ans1 = cur;
                int ans2 = 0;
                int ten = (s.charAt(i) - '0') * 10;
                int one = s.charAt(i + 1) - '0';
                if (ten + one <= 26) {
                    ans2 = end;
                }
                end = cur; //end 前移
                cur = ans1 + ans2;

            }
            return cur;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
