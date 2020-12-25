//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 134 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

//Java：最长不含重复字符的子字符串
public class P剑指 Offer 48最长不含重复字符的子字符串{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 48最长不含重复字符的子字符串().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        return twoPoint(s);

    }

    /**
     * 方法一采用双指针
     * @param s
     * @return
     */
    private int twoPoint(String s) {
        int left=0,right=0,res =0;
        //用来存放子串中已经有的数字
        HashSet<Character> set = new HashSet<>();
        while (right<s.length()){
            //获取当前right指针指向的
            char cur = s.charAt(right++);
            while (set.contains(cur)){
                //如果右指针指向的元素已经在字符串中存在了，就向右滑动左指针，直到子串中不含有该字符
                set.remove(s.charAt(left++));
            }
            //之后将该元素放入集合
            set.add(cur);
            res = Math.max(res, right-left);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
