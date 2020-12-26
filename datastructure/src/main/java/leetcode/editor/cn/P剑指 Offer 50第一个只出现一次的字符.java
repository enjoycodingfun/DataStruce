//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 64 👎 0


package leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

//Java：第一个只出现一次的字符
public class P剑指 Offer 50第一个只出现一次的字符{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 50第一个只出现一次的字符().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return ' ';
        }
        //return method1(s);
        return method2(s);
    }

        private char method2(String s) {
            char[] chars = s.toCharArray();
            int[] arr = new int[26];
            for (char c : chars) {
                arr[c - 'a']++;
            }
            for (char c : chars) {
                if (arr[c-'a'] == 1){
                    return c;
                }
            }
            return ' ';
        }

        private char method1(String s) {
            char[] chars = s.toCharArray();
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (char c : chars) {
                if (map.get(c) == null) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
            for (Character c : map.keySet()) {
                if (map.get(c) == 1){
                    return c;
                }
            }
            return ' ';
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
