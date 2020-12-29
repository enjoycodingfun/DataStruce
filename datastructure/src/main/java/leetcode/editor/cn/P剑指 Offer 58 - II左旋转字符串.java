//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 字符串 
// 👍 70 👎 0


package leetcode.editor.cn;
//Java：左旋转字符串
public class P剑指 Offer 58 - II左旋转字符串{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 58 - II左旋转字符串().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        return method1(s,n);

    }

        private String method1(String s, int n) {
            StringBuilder sb = new StringBuilder();
            String s2 = s.substring(0, n);
            String s1 = s.substring(n);
            String s3 = sb.append(s1).append(s2).toString();
            return s3;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
