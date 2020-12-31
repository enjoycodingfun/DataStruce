//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 86 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

//Java：扑克牌中的顺子
public class P剑指 Offer 61扑克牌中的顺子{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 61扑克牌中的顺子().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        return method1(nums);

    }

        /**
         *当牌中无重复且max-min<=4的时候就是顺子
         * @param nums
         * @return
         */
        private boolean method1(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            int max = 0,min = 14;//注意这里不要颠倒了
            for (int num : nums) {
                if (num == 0){
                    continue;
                }
                if (set.contains(num)){
                    return false;
                }
                max = Math.max(max,num);
                min = Math.min(min,num);
                set.add(num);
            }
            return max-min<5;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
