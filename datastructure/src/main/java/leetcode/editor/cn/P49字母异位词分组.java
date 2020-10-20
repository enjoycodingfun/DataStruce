//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 494 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：字母异位词分组
public class P49字母异位词分组 {

    public static void main(String[] args) {
        Solution solution = new P49字母异位词分组().new Solution();
        // TO TEST
    }

    /**
     * 和p242差不多的提型
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> keyMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String s = String.valueOf(chars);
                if (keyMap.get(s) == null){
                    List<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    keyMap.put(s,list);
                }else {
                    keyMap.get(s).add(strs[i]);
                }
            }
            return new ArrayList<>(keyMap.values());
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
