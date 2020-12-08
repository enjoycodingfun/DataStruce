//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 递归 
// 👍 81 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

//Java：斐波那契数列
public class P剑指 Offer 10-I斐波那契数列{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 10-I斐波那契数列().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer,Integer> resMap = new HashMap<>();

    public int fib(int n) {

        //方法一：保存中间变量的递归方法
        //return method1(resMap,n);
        //方法二：使用不占O(1)空间复杂度的动态规划
        return method2(n);

    }

    private int method2(int n) {
        if (n == 0 || n == 1){
            return n;
        }
        int pre = 0,cur = 1;
        for (int i = 2; i <= n ; i++) {
            int tmp = cur;
            cur = (pre + tmp)%1000000007;
            pre = tmp;
        }
        return cur;
    }

    private int method1(HashMap<Integer, Integer> resMap, int n) {
        if (n == 0 || n == 1){
            resMap.put(n,n);
            return n;
        }
        if (resMap.get(n) != null){
            return resMap.get(n);
        }
        int res = (fib(n-1)+fib(n-2))%1000000007;
        resMap.put(n,res);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
