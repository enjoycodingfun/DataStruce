//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划 
// 👍 273 👎 0


package leetcode.editor.cn;

//Java：最长公共子序列
public class P1143最长公共子序列 {

    public static void main(String[] args) {
        Solution solution = new P1143最长公共子序列().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestCommonSubsequence(String text1, String text2) {
            /**
             * 暴力法：两层循环，都从第一个字符开始，当遇到相同的两个指针都加1，直到最后
             */
            if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
                return 0;
            }
            /*String res = "";
            for (int i = 0; i < text1.length(); i++) {
                for (int j = 0; j < text2.length(); j++) {
                    if (i >= text1.length() || j >= text2.length()) {
                        return res.length();
                    }
                    if (text1.charAt(i) == text2.charAt(j)) {
                        res += text1.charAt(i);
                        i++;
                        break;
                    }
                }
            }*
             return res.length();
             */
            /**
             * 动态规划，构建dp表，dp[i][j]表示最长公共子序列长度，由于数组索引从零开始，为了方便计算，我们添加哨兵节点0，似的dp[0][j]和dp[i][0]都等于零
             * 这样我们计算的就是dp[i][j]
             */
            //初始化dptable,注意要给哨兵节点0预留位置，所以长度都是length+1;
            int[][] dp = new int[text1.length()+1][text2.length()+1];
            //注意这里ij都从1开始算起，终结是到length
            for (int i = 1; i < text1.length()+1; i++) {
                for (int j = 1; j < text2.length()+1; j++) {
                    if (text1.charAt(i-1) == text2.charAt(j-1)){
                        //字符串下标还是从0开始的，找到相同的之后就计算下一个
                        dp[i][j]=1+dp[i-1][j-1];
                    }else {
                        //没找到相等的就看谁能让字符串最长
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
           return dp[text1.length()][text2.length()];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
