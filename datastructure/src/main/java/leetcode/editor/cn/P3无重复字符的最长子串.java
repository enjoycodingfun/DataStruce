//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4774 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

//Java：无重复字符的最长子串
public class P3无重复字符的最长子串{
    public static void main(String[] args) {
        Solution solution = new P3无重复字符的最长子串().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 经典滑动窗口问题
     */
    class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0 ){
            return 0;
        }
        return method1(s);
    }

        /**
         * 方法一：滑动窗口最大值
         * @param s
         * @return
         */
        private int method1(String s) {
            char[] chars = s.toCharArray();
            int left = 0,right = 0,max = 0;
            HashSet<Character> set = new HashSet<>();
            while (right < chars.length){
                char cur = chars[right];
                while (set.contains(cur)){
                    set.remove(chars[left++]);
                }
                set.add(cur);
                max = Math.max(max,right-left+1);
                right++;
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
