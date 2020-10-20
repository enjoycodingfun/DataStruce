//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 265 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：有效的字母异位词
public class P242有效的字母异位词 {

    public static void main(String[] args) {
        Solution solution = new P242有效的字母异位词().new Solution();
        // TO TEST
        solution.isAnagram("aacc","ccac");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isAnagram(String s, String t) {
            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.length() != t.length()){
                return false;
            }
            /**
             * 方法一，时间复杂度O(N),空间复杂度O(N)
             * hashmap,key是字母，value是字母出现的次数
             */
            /*HashMap<Character,Integer> smap = new HashMap<>(s.length()*4/3);
            HashMap<Character,Integer> tmap = new HashMap<>(t.length()*4/3);
            for (int i = 0; i < s.length(); i++) {
                if (smap.get(s.charAt(i)) == null){
                    smap.put(s.charAt(i),1);
                }else{
                    smap.put(s.charAt(i),smap.get(s.charAt(i))+1);
                }
            }
            for (int j = 0; j < t.length(); j++) {
                if (tmap.get(t.charAt(j)) == null){
                    tmap.put(t.charAt(j),1);
                }else{
                    tmap.put(t.charAt(j),tmap.get(t.charAt(j))+1);
                }
            }
            for (Character key : smap.keySet()) {
                if (!smap.get(key).equals(tmap.get(key))){
                    return false;
                }
            }
            return true;*/
            /**
             * 方法二：先排序再比较
             */
            char[] str1 = s.toCharArray();
            char[] str2 = t.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            return Arrays.equals(str1,str2);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
