//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9322 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：两数之和
public class P1两数之和 {

    public static void main(String[] args) {
        Solution solution = new P1两数之和().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 本题目之前采用了暴利穷举法，现在重新采用hash表的方式,思路就是根据index访问每一个元素的时候，先查询下hashmap中有没有key是
     * target-nums[i]的元素，有的话就get(target-nums[i])得到该元素的下标，没有的话就将当前元素num[i]作为key，其下标值i作为value
     * 放入hashmap中
     */
    class Solution {

        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> numMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (numMap.containsKey(target-nums[i])){
                    //说明找到了某个数据与当前的num[i]和等于target
                    return new int[]{i,numMap.get(target-nums[i])};
                }
                numMap.put(nums[i],i);
            }
            return new int[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
