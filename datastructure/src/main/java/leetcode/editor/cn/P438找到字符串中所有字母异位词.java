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
            //return method1(s,p,res);
            return method2(s,p,res);

        }

        /**
         * 双指针 + 滑动窗口
         * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/438-zhao-dao-zi-fu-chuan-zhong-suo-you-zi-mu-yi-16/
         * 先对目标串p每个字符进行字符计数，统计出每个字符的出现次数。
         *
         * 使用滑动窗口在s串中寻找符合条件的字母异位词，创建一个临时计数数组 tempCounts[ ]，用于记录窗口内每种字符的出现次数。
         * 滑动窗口的左右指针初始均为0， 左指针指向窗口的第一个字符，右指针指向下个待移入窗口的字符。
         *
         * 把右指针不断后移，每移入一个字符，把此次移入的这个字符的计数器加一，因为移入了一个字符，所以右指针需要后移一位。如果此次移入某字符后导致窗口内该字符的出现次数超过了字母异位词的该字符本应该出现的次数，应该把窗口内最左边的超标字符滑出该窗口以维持数量平衡，使得该字符不超标，也就是让窗口的左指针不断右移，把碰到的字符的计数器都减一，直到这个超标的字符被移出去一个。
         *
         * 如果窗口大小刚好是p串的长度，说明窗口内的子串刚好构成 p 的字母异位词，原因是窗口内的每种字符个数都没有超过p,但是总的字符个数却刚好等于p,
         * 说明这两个字符串每种字符出现的次数完全一致。这时把窗口的左指针存入结果集中
         * @param s
         * @param p
         * @param res
         * @return
         */
        private List<Integer> method2(String s, String p, List<Integer> res) {
            int srcLen = p.length();
            int targetLen = s.length();
            //使用数组统计每个字符出现的次数
            int[] count = new int[26];
            for (int i = 0; i < srcLen; i++) {
                count[p.charAt(i)-'a']++;
            }

            //临时滑动窗口，记录窗口内每种字符的出现次数
            int[] tmpCount = new int[26];
            int left = 0,right = 0;
            while (right < targetLen){
                int cur = s.charAt(right)-'a';
                tmpCount[cur]++; // curR字符的出现次数加一
                right++; // 新增一个字符后，窗口右指针右移一位
                while (tmpCount[cur] > count[cur]){ // 不断缩小窗口大小，直到把超标字符移出去一个，使得不超标
                    tmpCount[s.charAt(left++)-'a']--;// 移走一个字符后窗口左指针右移一位
                }
                //这里注意right指向的是下一个即将进入窗口的数字，因此不需要right-left+1
                if (right-left == srcLen){
                    res.add(left);
                }
            }
            return res;
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
