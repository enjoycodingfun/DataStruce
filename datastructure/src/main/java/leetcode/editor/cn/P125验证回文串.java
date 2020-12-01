//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 300 👎 0


package leetcode.editor.cn;

//Java：验证回文串
public class P125验证回文串 {

    public static void main(String[] args) {
        Solution solution = new P125验证回文串().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPalindrome(String s) {
            if (s == null){
                return false;
            }
            if (s.length() == 0){
                return true;
            }
           StringBuffer sgood = new StringBuffer();
            //先去除其中的标点
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetterOrDigit(s.charAt(i))){
                    sgood.append(Character.toLowerCase(s.charAt(i)));
                }
            }
            int left = 0,right = sgood.length()-1;
            while (left<right){
                if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
