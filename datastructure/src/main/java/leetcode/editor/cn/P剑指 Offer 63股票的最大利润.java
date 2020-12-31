//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 10^5 
//
// 
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-s
//tock/ 
// Related Topics 动态规划 
// 👍 78 👎 0


package leetcode.editor.cn;
//Java：股票的最大利润
public class P剑指 Offer 63股票的最大利润{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 63股票的最大利润().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 动态规划，思路，假设有dp[i]表示第i天的最大利润，则dp[i]=Math.max(dp[i-1],price[i]-前i-1天最低的价格)
         * 用一个变量记录前i-1天的最低价格，用max记录最大利润
         */
        int lower = Integer.MAX_VALUE,max = 0;
        for (int i = 0; i < prices.length; i++) {
            lower = Math.min(prices[i],lower);
            max = Math.max(prices[i]-lower,max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
