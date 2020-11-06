//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2597 👎 0


package leetcode.editor.cn;

//Java：最大子序和
public class P53最大子序和 {

    public static void main(String[] args) {
        Solution solution = new P53最大子序和().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            /**
             * 方案一：动态规划
             * https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
             */
            //建立dptable dp[i]：表示以 nums[i] 结尾的连续子数组的最大和。
            /*int[] dp = new int[nums.length];
            dp[0] = nums[0];//以第一个元素结尾的最大子序和自然就是第一个元素自己
            int max = dp[0];//这里最好是int max= dp[0];
            for (int i = 1; i < nums.length; i++) {
                *//*if (dp[i-1]>=0){
                    dp[i] = dp[i-1]+nums[i];
                }else {
                    dp[i] = nums[i];
                }*
                这部分代码可以替换成下面一句
                 *//*
                dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            }
            //遍历所有dp
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max,dp[i]);
            }
            return max;
            */
            //针对上面的进行空间优化，每个状态的dp只和上一状态相关，因此我们只保存上一状态的最大值
            // 起名叫 pre 表示的意思是「上一个状态」的值
            int pre = nums[0];
            int max = pre;
            for (int i = 1; i < nums.length; i++) {
                pre = Math.max(nums[i], pre+nums[i]);
                max = Math.max(pre, max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
