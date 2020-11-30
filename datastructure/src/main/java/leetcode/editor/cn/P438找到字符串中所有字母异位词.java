//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 416 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：找到字符串中所有字母异位词
public class P438找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        Solution solution = new P438找到字符串中所有字母异位词().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || p == null || s.length() == 0 || p.length() == 0){
                return res;
            }
            return method1(s,p,res);

        }

        private List<Integer> method1(String s, String p, List<Integer> res) {
            char[] source = p.toCharArray();
            Arrays.sort(source);
            for (int i = 0,len = s.length(),sourceLen = p.length(); i < len-sourceLen+1; i++) {
                String substring = s.substring(i, i + sourceLen);
                char[] sub = substring.toCharArray();
                Arrays.sort(sub);
                if (Arrays.equals(source,sub)){
                    res.add(i);
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
