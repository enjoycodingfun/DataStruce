//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 621 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：每日温度
public class P739每日温度{
    public static void main(String[] args) {
        Solution solution = new P739每日温度().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0){
            return new int[0];
        }
        //return method1(T);
        return method2(T);

    }

        /**
         * 方法二：单调栈
         * @param t
         * @return
         */
        private int[] method2(int[] t) {
            int[] res = new int[t.length];
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < t.length; i++) {
                while (!deque.isEmpty()&&t[i]>t[deque.peek()]){
                    res[deque.peek()] = i - deque.poll();
                }
                deque.push(i);
            }
            return res;
        }

        /**
         * 无脑暴力法
         * @param t
         * @return
         */
        private int[] method1(int[] t) {
            int[] res = new int[t.length];
            for (int i = 0; i < t.length; i++) {
                for (int j = i+1; j < t.length; j++) {
                    if (t[j]>t[i]){
                        res[i] = j-i;
                        break;
                    }
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
