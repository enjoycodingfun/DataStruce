//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

package leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses{
  public static void main(String[] args){
      Solution solution = new ValidParentheses().new Solution();
      System.out.println(solution.isValid("(([]){})"));
  
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {

        if (s.length() == 0){
            return true;
        }
        if (s.length()%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        //按顺序入栈并判断与前一个是否能组成一对,能组成就将两个都出栈
        for (int i = 0; i < s.length() ; i++) {
            /*if (stack.empty()){
                //栈空,则直接入栈
                stack.push(s.charAt(i));
            }else{
                //否则拿栈顶元素来判定是否兄弟,是兄弟,弹出栈顶元素,否则继续入栈
                if(isbro(stack.peek(),s.charAt(i))){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                };
            }*/
            //上面的直接简化为下面代码(注意看 Related Topics 栈 字符串)
            if (stack.empty() || !isbro(stack.peek(),s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }
        return stack.empty();

        /*if (s.length() == 0){
            return true;
        }
        if (s.length()%2 != 0){
            return false;
        }
        boolean flag = true;
        int mid = s.length()/2;
        //判断对称形式的
        for (int i = 0; i < mid; i++) {
            //检查是不是自己的兄弟,注意有两种形式对称形式的"()" 顺序形式的"()[]{}"
            if (!this.isbro(s.charAt(i),s.charAt(s.length()-1-i))){
                //检查对称形式的
                flag = false;
                break;
            };
        }
        if (flag == true){
            //如果经历第一次判断仍然是true,说明刚好是第一种对称形式且有效
            return true;
        }
        //判断顺序形式的
        for (int i = 0; i <s.length() ; i+=2) {
            if (!this.isbro(s.charAt(i),s.charAt(i+1))){
                //检查顺序形式的
                flag = false;
                break;
            }else {
                flag = true;
            }
        }
        return flag;*/
    }

      private boolean isbro(char left, char right) {
        if ('(' == left && ')' == right){
            return true;
        }
          if ('{' == left && '}' == right){
              return true;
          }
          if ('[' == left && ']' == right){
              return true;
          }
          return false;
      }

  }
//leetcode submit region end(Prohibit modification and deletion)

}


