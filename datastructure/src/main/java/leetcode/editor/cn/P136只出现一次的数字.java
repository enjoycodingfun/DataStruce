//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1593 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

//Java：只出现一次的数字
public class P136只出现一次的数字 {

    public static void main(String[] args) {
        Solution solution = new P136只出现一次的数字().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int singleNumber(int[] nums) {
            //return method1(nums);
            return method2(nums);

        }
        //任何数异或自己等于0，而任何数异或0等于他自己，所以如果一个数出现两次，经过异或会变为0，最后再异或出现一次的那个数字
        //得到它自己
        private int method2(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            return res;
        }

        private int method1(int[] nums) {
            /**
             * 用最笨的hashmap
             */
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.get(num) == null){
                    map.put(num,1);
                }else{
                    map.put(num,map.get(num)+1);
                }
            }
            for (Integer integer : map.keySet()) {
                if (map.get(integer) == 1){
                    return integer;
                }
            }
            return 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
