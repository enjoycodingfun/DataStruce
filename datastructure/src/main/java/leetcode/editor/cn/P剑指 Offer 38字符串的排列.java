//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 151 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//Java：字符串的排列
public class P剑指 Offer 38字符串的排列{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 38字符串的排列().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        if (s == null || s.length() == 0 || s.length() == 1){
            return new String[]{s};
        }
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int index) {
        if (index == c.length-1){
            res.add(String.valueOf(c));
            return;
        }
        //初始化用来存放当前位已经安置过的字母
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < c.length; i++) {
            if (set.contains(c[i])){
                //当前位置已经安置过这个字母，所以重复了，剪枝
                continue;
            }
            set.add(c[i]);
            //交换当前字母与[index,c.c[index]-1]位置的字母,将c[index]固定在x位
            swap(i,index);
            //开始低递归替换下一个位置
            dfs(index+1);
            //将已经更换的还回去
            swap(i,index);
        }
    }

    private void swap(int index, int i) {
        char tmp = c[index];
        c[index] = c[i];
        c[i] = tmp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
