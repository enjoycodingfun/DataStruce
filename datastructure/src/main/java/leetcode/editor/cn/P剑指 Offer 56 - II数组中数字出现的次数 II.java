//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 111 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：数组中数字出现的次数 II
public class P剑指 Offer 56 - II数组中数字出现的次数 II{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 56 - II数组中数字出现的次数 II().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //return method1(nums);
        return method2(nums);

    }

        /**
         * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
         * @param nums
         * @return
         */
        private int method2(int[] nums) {
            int ones = 0,twos = 0;
            for (int num : nums) {
                ones = ones ^ num & ~twos;
                twos = twos ^ num & ~ones;
            }
            return ones;
        }

        /**
         * 无脑暴力法
         * @return
         * @param nums
         */
        private int method1(int[] nums) {

            Arrays.sort(nums);
            if (nums[0] != nums[1]){
                return nums[0];
            }
            for (int i = 1; i < nums.length-1; i++) {
                if (nums[i] != nums[i-1]&&nums[i] != nums[i+1]){
                    return nums[i];
                }
            }
            return nums[nums.length-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
