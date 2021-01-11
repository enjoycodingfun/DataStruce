//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 653 👎 0


package leetcode.editor.cn;

//Java：最佳买卖股票时机含冷冻期
public class P309最佳买卖股票时机含冷冻期 {

    public static void main(String[] args) {
        Solution solution = new P309最佳买卖股票时机含冷冻期().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 非常典型的动态规划问题
     */
    class Solution {

        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0){
                return 0;
            }
            return method1(prices);

        }

        /**
         * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/fei-zhuang-tai-ji-de-dpjiang-jie-chao-ji-tong-su-y/
         * 所以对于每一天i，都有可能是三种状态：
         * 0.不持股且当天没卖出,定义其最大收益dp[i][0];(冷冻期)
         * 1.持股,定义其最大收益dp[i][1]；
         * 2.不持股且当天卖出了，定义其最大收益dp[i][2]；
         *
         * 初始化的时候：
         * dp[0][0]=0//第一天不持股也没卖出，啥也没干，所以=0
         * dp[0][1]=-prices[0]//第一天持股那就是花费当天股价来收购股票跑，所以收益为负
         * dp[0][2]=0//可以理解成第0天买入又卖出，那么第0天就是“不持股且当天卖出了”这个状态了，其收益为0，所以初始化为0是合理的
         *
         * 下面计算各种情况第i天的最大收益：
         * dp[i][0]当天不持股也没有卖出，只有一种情况即前一天卖出了或者前一天是冷冻期，今天啥也没干，所以此时dp[i][0]=dp[i-1][0](前一天是冷冻期)
         * 或者dp[i-1][2](前一天卖出了)，所以dp[i][0]=max(dp[i-1][0],dp[i-1][2]);
         *
         * dp[i][1]当天持股，前一天是冷冻期今天买入dp[i][1]=dp[i-1][0]-prices[i]或者前一天就持股也没卖出今天啥也没干继承昨天的股票dp[i-1][1]
         * 所以dp[i][1]=max(dp[i-1][0]-prices[i],dp[i-1][1])
         *
         * dp[i][2]当天不持股且当天卖出了，那么其只有一种情况那就是说昨天我一定是持股的，要不然我今天拿什么卖啊，
         * 而持股只有一种状态，昨天持股的收益加上今天卖出得到的钱，就是dp[i][2]=dp[i-1][1]+prices[i]
         *
         * 最后一天的最大收益有两种可能，而且一定是“不持有”状态下的两种可能，把这两种“不持有”比较一下大小，返回即可
         *
         * @param prices
         * @return
         */
        private int method1(int[] prices) {
            //dp用来表示第i天的最大收益，其中第二位有0,1,2三个状态，0表示当天不持有股票且没有卖出（不是因为卖出而没有持股票，因为冷冻期或者前天卖出，今天无操作）
            //1表示持有股票2表示当天不持有股票且当天卖出了股票（这个情况的前提是昨天持有股票）
            int[][] dp = new int[prices.length][3];
            dp[0][0]=0;
            dp[0][1]=-prices[0];
            dp[0][2]=0;
            for (int i = 1; i < prices.length ; i++) {
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]);
                dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
                dp[i][2]=dp[i-1][1]+prices[i];
            }
            return Math.max(dp[prices.length-1][0],dp[prices.length-1][2]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
