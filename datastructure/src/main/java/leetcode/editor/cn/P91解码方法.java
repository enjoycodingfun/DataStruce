//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 题目数据保证答案肯定是一个 32 位的整数。 
//
// 
//
// 示例 1： 
//
// 输入："12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 输入："226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 输入：s = "0"
//输出：0
// 
//
// 示例 4： 
//
// 输入：s = "1"
//输出：1
// 
//
// 示例 5： 
//
// 输入：s = "2"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可以包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 555 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

//Java：解码方法
public class P91解码方法 {

    public static void main(String[] args) {
        Solution solution = new P91解码方法().new Solution();
        String s = "12";
        // TO TEST
    }

    /**
     * 动态规划dp[i] = dp[i-1]+2
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numDecodings(String s) {
            /**
             * 方法一：递归题解
             * https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/
             */
            if (s == null || s.length() == 0 || s.equals("0")) {
                return 0;
            }
            //递归方法容易超时
            //return getRes(s,0);
            /**
             * 方法二：对递归中间值进行保存，如果计算过直接返回
             */
            HashMap<Integer,Integer> map = new HashMap<>();
            //return getRes(s,0,map);
            /**
             * 方法三：动态规划
             * 同样的，递归就是压栈压栈压栈，出栈出栈出栈的过程，我们可以利用动态规划的思想，省略压栈的过程，直接从 bottom 到 top。
             *
             * 用一个 dp 数组， dp [ i ] 代表字符串 s [ i, s.len-1 ]，也就是 s 从 i 开始到结尾的字符串的解码方式。
             *
             * 这样和递归完全一样的递推式。
             *
             * 如果 s [ i ] 和 s [ i + 1 ] 组成的数字小于等于 26，那么
             *
             * dp [ i ] = dp[ i + 1 ] + dp [ i + 2 ]
             */
            int[] dp = new int[s.length()+1];
            //注意这里添加了一个哨兵节点，就是最后一位，将上面递归条件初始化为最后一位
            //dp[dp.length-1] = 1;
            dp[s.length()] = 1;
            //下面开始遍历字符串，当字符串最后一位不为0，就将倒数第二位dp[dp.length-2]初始化为1，这样假如s=23，
            //先遍历3，此时dp = dp[哨兵节点]+dp[哨兵节点之后一位，不存在] = 1；当遍历到2的时候dp=dp[3]+dp[哨兵节点]=1+1=2
            if (s.charAt(s.length()-1) != '0'){
                //dp[dp.length-2] = 1;
                dp[s.length()-1] = 1;
            }
            //从后往前遍历字符串计算其他值
            for (int i = s.length()-2; i >= 0; i--) {
                //当前数字为0是,没法单独成为一个字母，跳过
                if (s.charAt(i) == '0'){
                    continue;
                }
                //如果当前数字不是0的话，我们需要计算当前数字位置有几种编码方式，比如234，现在遍历到了2，2这个时候的编码方式应该是等于将
                //2单独作为一位的dp(除去2之后，剩余位数的dp，其实就是dp[i+1])加上将23作为一位（需要判断是否小于26）的dp[i+2]之和，类似于上面递归的理解方式
                int res1 = dp[i+1];
                //计算将两位划出来的dp
                int res2 = 0;
                if (Integer.parseInt(s.substring(i,i+2))<=26) {
                    res2 = dp[i+2];
                }
                dp[i] = res1 + res2;
            }
            return dp[0];
        }

        private int getRes(String s, int start, HashMap<Integer, Integer> map) {
            //如果是边界了，划分到了最后返回 1
            if (start == s.length()) {
                return 1;
            }
            //如果当前数字为0，直接返回0
            if (s.charAt(start) == '0'){
                return 0;
            }
            //先看下当前有没有计算过
            int res = map.getOrDefault(start,-1);
            if (res != -1){
                return res;
            }
            //先求将当前字符串第一个字母划分出去的情况
            int res1 = getRes(s,start+1,map);
            //再求将当前字符串第二个字母划分出去的情况，这个时候要判断前两个字符是否为0，是否小于26
            int res2 = 0;
            if (start<s.length()-1){
                //截取前两位与26比较大小，小于26递归执行
                if (Integer.parseInt(s.substring(start,start+2))<=26){
                    res2 = getRes(s,start+2,map);
                }
            }
            //如果是第一次计算，返回之前先放进map里
            map.put(start,res1+res2);
            return res1+res2;
        }

        private int getRes(String s, int start) {
            //如果是边界了，直接返回1
            if (start == s.length()) {
                return 1;
            }
            //如果当前数字为0，直接返回0
            if (s.charAt(start) == '0'){
                return 0;
            }
            //先求将当前字符串第一个字母划分出去的情况
            int res1 = getRes(s,start+1);
            //再求将当前字符串第二个字母划分出去的情况，这个时候要判断前两个字符是否为0，是否小于26
            int res2 = 0;
            if (start<s.length()-1){
                //截取前两位与26比较大小，小于26递归执行
                if (Integer.parseInt(s.substring(start,start+2))<=26){
                    res2 = getRes(s,start+2);
                }
            }
            return res1+res2;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
