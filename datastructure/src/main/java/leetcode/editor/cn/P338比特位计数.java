//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划 
// 👍 449 👎 0


package leetcode.editor.cn;

//Java：比特位计数
public class P338比特位计数 {

    public static void main(String[] args) {
        Solution solution = new P338比特位计数().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] countBits(int num) {
            return method1(num);

        }

        /**
         * 方法一：参考官方题解，此题可以看重P191的后续，针对每个数字使用函数
         * @param num
         * @return
         */

        private int[] method1(int num) {
            int[] res = new int[num+1];
            for (int i = 0; i < num + 1; i++) {
                res[i] = getBitsOne(i);
            }
            return res;
        }

        private int getBitsOne(int n) {
            int res = 0;
            while (n!=0){
                n &= n - 1;
                res++;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
