//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 51 👎 0


package leetcode.editor.cn;

//Java：替换空格
public class P剑指 Offer 05替换空格{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 05替换空格().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return method1(s);

    }

    private String method1(String s) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                res.append("%20");
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
