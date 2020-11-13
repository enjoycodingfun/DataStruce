//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 434 👎 0


package leetcode.editor.cn;

//Java：回文子串
public class P647回文子串 {

    public static void main(String[] args) {
        Solution solution = new P647回文子串().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countSubstrings(String s) {

            if (s == null || s.length() == 0) {
                return 0;
            }
            //return method1(s);
            return method2(s);


        }

        /**
         * 方法一：动态规划
         * https://leetcode-cn.com/problems/palindromic-substrings/solution/liang-dao-hui-wen-zi-chuan-de-jie-fa-xiang-jie-zho/
         * dp[i][j]定义为在字符串中[i,j]区间的子字符串是否是回文子串，它是回文子串的条件是s[i]==s[j]&&((j-i<2)||dp[i+1][j-1])
         * j-i<2前提i<=j，所以要么i=j,是单个字符串，算回文子串，要么j-i=1,是两个相同的字母，也是回文子串，而当区间[i+1,j-1]之间的子串是回文子串的时候
         * 在其两边加上两个相等的字符也一定是回文子串
         * 该方法时间复杂度和空间复杂度均为O(N2)
         */
        private int method1(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            int count = 0;
            for (int right = 0; right < s.length(); right++) {
                for (int left = 0; left <= right; left++) {
                    if (s.charAt(left) == s.charAt(right)&&((right-left)<2||dp[left+1][right-1])){
                        dp[left][right] = true;
                        count++;
                    }
                }
            }
            return count;
        }

        /**
         * 方法二：中心扩展法
         * 思路：对于一个字符串我们只要穷举出所有的回文中心，然后由回文中心两边扩展判定是否是回文字符串就可以，但是回文字符串中心和左右指针的关系我们需要确认（可以看其他题解理解什么是中心扩展法）
         * 假设字符串为abcd,那么它可能的中心有2*length-1中，为什么呢？首先回文中心只有可能是一个字符或者两个字符（三个或更多都有能由一个字符和两个初始字符向两边扩展得到）
         * 每个单个字符作为回文中心（a,b,c,d），那么总共有length个回文中心，每个双字符作为回文中心（ab,bc,cd）那么一共有length-1个，所以总共有2*length-1个
         * 下面再看遍历过程中每个中心和左右指针的关系，因为回文中心共有2*length-1个，那么回文中心遍历时候是从0-2*length-2遍历，我们一次性将回文中心是一个字符和两
         * 个字符的都遍历出来，下面是具体例子
         * 注意：其中回文中心编号范围是0-2*length-2共计2*length-1个；左右指针的编号是相对于字符串字符位置说的，范围是0-字符串长度-1；他两是不同的维度
         * 回文中心编号(center)   中心值  初始化左指针    初始化左指针编号(left)   初始化右指针    初始化右指针编号(right)
         *    0                   a        a             0                       a              0
         *    1                  ab        a             0                       b              1
         *    2                   b        b             1                       b              1
         *    3                  bc        b             1                       c              2
         *    4                   c        c             2                       c              2
         *    5                  cd        c             2                       d              3
         *    6                   d        d             3                       d              3
         *从上面的关系可以看出，回文中心编号center与左右指针left和right的关系如下：left=center/2 right=left+(center%2)
         */
        private int method2(String s) {
            int len = s.length();
            int num = 0;
            for (int center = 0; center < 2 * len - 1; center++) {
                int left = center/2;
                int right = left+(center%2);
                while (left>=0&&right<=len-1&&s.charAt(left)==s.charAt(right)){
                    num++;
                    left--;
                    right++;
                }
            }
            return num;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
