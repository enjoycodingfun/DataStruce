//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 558 👎 0


package leetcode.editor.cn;

//Java：加一
public class P66加一 {

    public static void main(String[] args) {
        Solution solution = new P66加一().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 只要+1求余数，余数不等于0，说明没有进位，直接返回。如果余数等于0，说明有进位，遍历前一个数字，
     * 加1再求余数，以此循环。如果for循环都遍历完了，说明最高位也有进位，则重新建立一个数组，初始化为0，
     * 将第一位设置为1就可以了，因为，99、999之类的数字加一为100、1000
     * https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
     */
    class Solution {

        public int[] plusOne(int[] digits) {
            if (digits == null || digits.length <= 0) {
                return digits;
            }
            /**
             * 参考题解
             */
            for (int i = digits.length-1; i >= 0; i--) {
                //从后往前遍历，先给最后一位加一
                digits[i]++;
                //判定这个加一是否需要进位
                digits[i] = digits[i]%10;
                if (digits[i] != 0){
                    //说明不需要进位，直接返回即可
                    return digits;
                }
            }
            //假如走完for循环了，还没有返回，只有一种情况，类似于99,99,999这种，那我们直接在原有数据上加一位，首位置为0即可
            digits = new int[digits.length+1];
            digits[0] = 1;
            return digits;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
