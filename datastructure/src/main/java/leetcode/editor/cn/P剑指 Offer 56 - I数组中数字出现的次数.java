//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 275 👎 0


package leetcode.editor.cn;

//Java：数组中数字出现的次数
public class P剑指 Offer 56 - I数组中数字出现的次数{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 56 - I数组中数字出现的次数().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        return method1(nums);

    }

        /**
         * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/jie-di-qi-jiang-jie-fen-zu-wei-yun-suan-by-eddievi/
         * 异或满足交换律，第一步异或，相同的数其实都抵消了，剩下两个不同的数。
         * 这两个数异或结果肯定有某一位为1，不然都是0的话就是相同数。找到这个位，
         * 不同的两个数一个在此位为0，另一个为1。按此位将所有数分成两组，分开后各自异或，
         * 相同的两个数异或肯定为0（而且分开的时候，两个数必为一组）。
         * 剩下的每组里就是我门要找的数。
         * @param nums
         * @return
         */
        private int[] method1(int[] nums) {
            //将所有的数字异或起来，最后得到的是不同的两个数的异或值，相同数字异或为0
            int k = 0;
            for (int num : nums) {
                k ^= num;
            }
            //得到的k是两个不同的数异或的结果，接下来找两个数中哪一位不同,不同后异或结果为1，所以就是找K中哪一位为1（至少有一位不同，不然异或结果为0）
            int mask = 1;
            while ((k&mask) == 0){
                mask <<= 1;
            }
            //接下来用这个扰动函数mask去与所有的数字进行分组，相同的数字与mask与结果相同，而两个不同的数字结果不同会分到不同的组
            //在mask锁对应为1的那一位一定是不同的，最后就会被剩下来
            int a = 0,b=0;
            for (int num : nums) {
                if ((num&mask) == 0){
                    a ^= num;
                }else {
                    b ^= num;
                }
            }
            return new int[]{a,b};
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
