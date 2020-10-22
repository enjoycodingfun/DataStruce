//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1379 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22括号生成 {

    public static void main(String[] args) {
        Solution solution = new P22括号生成().new Solution();
        // TO TEST
    }

    /**
     * 参考题解：
     * https://leetcode-cn.com/problems/generate-parentheses/solution/jian-dan-dfsmiao-dong-by-sweetiee/
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs(n, n, res,"");
            return res;

        }

        private void dfs(int left, int right, List<String> res, String s) {
            if (left == 0 && right == 0){
                //左右括号都不剩了，递归中止
                res.add(s);
                return;
            }
            //左括号还有剩余，拼接左括号
            if (left > 0){
                dfs(left-1,right,res,s+"(");
            }
            //右括号剩余大于左括号，拼接右括号
            if (right > left){
                dfs(left,right-1,res,s+")");
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
