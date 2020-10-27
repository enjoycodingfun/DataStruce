//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 974 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Java：电话号码的字母组合
public class P17电话号码的字母组合 {

    public static void main(String[] args) {
        Solution solution = new P17电话号码的字母组合().new Solution();
        // TO TEST
    }

    /**
     * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/mei-guan-zheng-ji-de-hui-su-dai-ma-by-yuhongzhou/
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return new ArrayList<>();
            }
            /**
             * 方法一：暴力穷举法
             */
            return this.method1(digits);

        }

        private List<String> method1(String digits) {
            List<String> res = new ArrayList<>();
            //先初始化一个hashmap
            HashMap<Character,String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            //先初始化一个集合
            //接下来遍历回溯
            this.backtrack(res,digits,map,0,new StringBuilder());
            return res;
        }

        private void backtrack(List<String> res, String digits, HashMap<Character, String> map, int index,
                StringBuilder sb) {
            //终止条件
            if (sb.length() == digits.length()){
                res.add(sb.toString());
                return;
            }
            //处理当前逻辑
            String value = map.get(digits.charAt(index));
            for (int i = 0; i < value.length(); i++) {
                //下探
                backtrack(res,digits,map,index+1,sb.append(value.charAt(i)));
                //回溯
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
