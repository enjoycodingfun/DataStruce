//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 823 👎 0


package leetcode.editor.cn;

//Java：乘积最大子数组
public class P152乘积最大子数组 {

    public static void main(String[] args) {
        Solution solution = new P152乘积最大子数组().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            /**
             * 方法一：动态规划，参考题解：https://leetcode-cn.com/problems/maximum-product-subarray/solution/duo-chong-si-lu-qiu-jie-by-powcai-3/
             * 我们只需要记录前i个元素子序乘积的最大值和最小值即可，之后两者分别乘当前值，形成的两个数与当前值进行比较即可
             */
            int preMax = nums[0];
            int preMin = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int curMax = Math.max(Math.max(nums[i] * preMax, nums[i] * preMin), nums[i]);
                int curMin = Math.min(Math.min(nums[i] * preMax, nums[i] * preMin), nums[i]);
                max = Math.max(curMax, max);
                preMax = curMax;
                preMin = curMin;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
