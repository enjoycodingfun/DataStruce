//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 95 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

//Java：青蛙跳台阶问题
public class P剑指 Offer 10-II青蛙跳台阶问题{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 10-II青蛙跳台阶问题().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    HashMap<Integer,Integer> resMap = new HashMap<>();

    public int numWays(int n) {
        /**
         * 方法一：保存中间变量的递归
         */
        //return method1(resMap,n);
        /**
         * 方法二：优化空间的动态规划
         */
        return method2(n);

    }

    private int method2(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        int pre = 1,cur = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = cur;
            cur = (pre + tmp)%1000000007;
            pre = tmp;
        }
        return cur;
    }

    private int method1(HashMap<Integer, Integer> resMap, int n) {
        if (n == 0 || n == 1){
            resMap.put(n,1);
            return 1;
        }
        if ( n == 2){
            resMap.put(n,n);
            return n;
        }
        if (resMap.get(n) != null) {
            return resMap.get(n);
        }
        int res = (numWays(n-1)+numWays(n-2))%1000000007;
        resMap.put(n,res);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
