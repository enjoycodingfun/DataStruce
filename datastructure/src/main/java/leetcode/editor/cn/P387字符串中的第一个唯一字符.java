//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 293 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

//Java：字符串中的第一个唯一字符
public class P387字符串中的第一个唯一字符 {

    public static void main(String[] args) {
        Solution solution = new P387字符串中的第一个唯一字符().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int firstUniqChar(String s) {
            if (s == null || s.length() == 0) {
                return -1;
            }
            return method1(s);
        }

        private int method1(String s) {
            int len = s.length();
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                if (set.contains(s.charAt(i))){
                    continue;
                }
                for (int j = i + 1; j < len; j++) {
                    if (s.charAt(j) == s.charAt(i)){
                        set.add(s.charAt(j));
                    }
                }
                if (!set.contains(s.charAt(i))){
                    return i;
                }
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
