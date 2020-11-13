//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2893 👎 0


package leetcode.editor.cn;

//Java：最长回文子串
public class P5最长回文子串 {

    public static void main(String[] args) {
        Solution solution = new P5最长回文子串().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            //return method1(s);
            return method2(s);

        }


        private String method1(String s) {
            /**
             * 方法一：中心拓展法
             * 此题类似于P647回文子串，方法一基于P647改造下
             */
            String res = "";
            for (int center = 0; center < 2*s.length()-1; center++) {
                int left = center/2;
                int right = left + (center%2);
                while (left>=0&&right<=s.length()-1&&s.charAt(left)==s.charAt(right)){
                    if (right-left+1>res.length()){
                        res = s.substring(left,right+1);
                    }
                    left--;
                    right++;
                }
            }
            return res;
        }

        private String method2(String s) {
            /**
             * 方法二：动态规划 ,也是在P647基础上修改的，时间和空间复杂度为O(N2)
             */
            boolean[][] dp = new boolean[s.length()][s.length()];
            String res = "";
            for (int right = 0; right < s.length(); right++) {
                for (int left = 0; left <= right; left++) {
                    if (s.charAt(left) == s.charAt(right)&&((right-left)<2||dp[left+1][right-1])){
                        dp[left][right] = true;
                        if (right-left+1>res.length()){
                            res = s.substring(left,right+1);
                        }
                    }
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
