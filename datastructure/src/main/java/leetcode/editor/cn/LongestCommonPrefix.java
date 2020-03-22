//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix{
  public static void main(String[] args){
      Solution solution = new LongestCommonPrefix().new Solution();
      String[] strs = {""};
      System.out.println(strs[0].isEmpty());
     /* String[] strs = {""};
      String s = strs[0];
      System.out.println(s == "");*/

  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        //既然是公共字符串,选任意一个都行,如果拿出最短字符串也行
        String temp = strs[0];
        for (int i = 0; i < temp.length(); i++) {
            char pre = temp.charAt(i);
            for (int j = 1; j < strs.length ; j++) {
                //注意两个或的判断先后顺序
                if ( i == strs[j].length() || strs[j].charAt(i)!= pre){
                    return strs[0].substring(0,i);
                }
            }
        }
        return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


