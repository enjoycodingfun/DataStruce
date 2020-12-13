//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 133 👎 0


package leetcode.editor.cn;

//Java：剪绳子
public class P剑指 Offer 14-I剪绳子{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 14-I剪绳子().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int cuttingRope(int n) {
        //return method1(n);
        return method2(n);

    }

    /**
     * 方法二：动态规划
     * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/shu-xue-zhi-shi-he-dong-tai-gui-hua-liang-chong-fa/
     * @param n
     * @return
     */
    private int method2(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],(Math.max(j,dp[j])*Math.max((i-j),dp[i-j])));
            }
        }
        return dp[n];
    }

    /**
     * 方法一：数学逻辑
     * 当 n \leq 3n≤3 时，按照规则应不切分，但由于题目要求必须剪成 m>1m>1 段，因此必须剪出一段长度为 11 的绳子，即返回 n - 1n−1 。
     * 当 n>3n>3 时，求 nn 除以 33 的 整数部分 aa 和 余数部分 bb （即 n = 3a + bn=3a+b ），并分为以下三种情况：
     * 当 b = 0b=0 时，直接返回 3^a3
     * a
     *  ；
     * 当 b = 1b=1 时，要将一个 1 + 31+3 转换为 2+22+2，因此返回 3^{a-1} \times 43
     * a−1
     *  ×4；
     * 当 b = 2b=2 时，返回 3^a \times 23
     * a
     *  ×2。
     * @param n
     * @return
     */

    private int method1(int n) {
        if (n <= 3){
            return n-1;
        }
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
