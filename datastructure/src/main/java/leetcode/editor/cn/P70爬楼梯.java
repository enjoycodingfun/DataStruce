//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1280 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

//Java：爬楼梯
public class P70爬楼梯 {

    public static void main(String[] args) {
        Solution solution = new P70爬楼梯().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     *这个题是斐波那契数列的题，可以采用递归的算法，优化点是在计算数值的过程中将中间值缓存起来
     * 递归算法如果不加缓存的时候会超时，所以需要注意
     */
    class Solution {
        HashMap<Integer,Integer> map = new HashMap<>();
        public int climbStairs(int n) {
            //方法一：带有缓存的递归方式，将中间计算结果缓存起来
            /*if (n == 0){
                return 0;
            }
            if (n == 1){
                map.put(1,1);
                //只有一个台阶，就只有一种爬楼梯方法
                return 1;
            }
            if (n == 2){
                map.put(2,2);
                //只有两个台阶，就可以一次一个阶梯，或者一次两个阶梯这两种爬楼方法
                return 2;
            }
            if (map.get(n-1)!=null && map.get(n-2) != null){
                map.put(n, map.get(n - 1) + map.get(n - 2));
                return map.get(n);
            }
            int num = climbStairs(n-1)+climbStairs(n-2);
            map.put(n,num);
            return num;*/
            //方法二：动态规划问题，构建数组，每一个数组的后一个元素，等于他前两个元素之和
            /*int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            //每次计算新的值的时候，需要在现在的length上加一，n<=dp.length+1
            for (int i = 2; i <= n ; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];*/
            //方法三：空间优化，因为方法二中保存了所有的中间过程到数组元素，实际上计算过程中对于n我们只需要他前两个值，所以用局部变量一直保存前两个即可
            int pre = 1;
            int cur = 1;
            for (int i=2;i<=n;i++){
                int tmp = cur;//暂存上一次的当前值
                cur = pre + tmp;//新的当前值等于上次的当前值加前一个值
                pre = tmp;//上一个当前值变为pre
            }
            return cur;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
