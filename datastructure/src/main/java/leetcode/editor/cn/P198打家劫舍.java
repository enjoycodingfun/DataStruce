//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1152 👎 0


package leetcode.editor.cn;

//Java：打家劫舍
public class P198打家劫舍 {

    public static void main(String[] args) {
        Solution solution = new P198打家劫舍().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int rob(int[] nums) {
            /**
             * 方法一：动态规划，dp[n]表示在当前房屋中可以偷到的最大值，这个最大值当n-1号房间已经偷了，那么本房间就不能偷了，最大值还是dp[n-1]，要么前一个房间没偷，
             * 就是dp[n-2]+本房间数量
             * 我们添加一个哨兵节点
             */
            if (nums == null || nums.length == 0) {
                return 0;
            }
           /* int[] dp = new int[nums.length+1];
            //dp[0]是一个哨兵节点
            dp[0] = 0;
            dp[1] = nums[0];
            for (int i = 2; i <= nums.length; i++) {
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
            }
            return dp[nums.length];*/
            //每次计算我们只需要计算前两个即可，所以我们只保存前两个的值，下面进行空间优化
            int pre = 0;
            int cur = 0;//其中cur表示当前节点最大偷到值
            for (int i = 0; i < nums.length; i++) {
                //当前节点的最大值先保存到临时变量(要么是其前一个节点的最大值（本节点不偷）要么就是前两个节点加上本节点的值（本节点要偷）)
                int temp = Math.max(cur,pre+nums[i]);
                pre = cur;
                cur = temp;
            }
            return cur;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
