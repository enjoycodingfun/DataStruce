//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 96 👎 0


package leetcode.editor.cn;

//Java：丑数
public class P剑指 Offer 49丑数{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 49丑数().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 动态规划：参考https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
     * 详细题解可参考：https://leetcode-cn.com/problems/chou-shu-lcof/solution/chou-shu-ii-qing-xi-de-tui-dao-si-lu-by-mrsate/
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int p2 = 0,p3 = 0,p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int a = dp[p2]*2,b=dp[p3]*3,c=dp[p5]*5;
            dp[i] = Math.min(Math.min(a,b),c);
            //注意这里用if不是if else 防止出现重复的数字
            if (dp[i] == a){
                p2++;
            }
            if (dp[i] == b){
                p3++;
            }
            if (dp[i] == c){
                p5++;
            }
        }
        return dp[n-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
