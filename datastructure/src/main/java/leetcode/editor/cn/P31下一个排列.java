//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 892 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：下一个排列
public class P31下一个排列 {

    public static void main(String[] args) {
        Solution solution = new P31下一个排列().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length <= 1){
                return;
            }
            method1(nums);

        }

        /**
         * 参考官方题解中评论SonLee，官方题解思路，以[4,5,2,6,3,1]为例
         * 1.从倒数第二个数开始往前找a[i]<a[i+1]的数，找到2<6
         * 2.从倒数第一个所在下标开始找大于2的第一个数，找到了3（假如找不到这么个数就直接将全部元素反转升序排列即可）
         * 3.交换2和3,得到[4,5,3,6,2,1],此时可以肯定原来的2现在的3所在位置后面的元素621一定是降序排列的，将其反转即可
         *
         * 关于证明：
         * 有一个小点可能一开始不是那么‘易知’，就是‘交换 a[i]与 a[j]，此时可以证明区间 [i+1,n) 必为降序‘这句话。
         * 要想证明这句话的正确性即证明a[j-1]>=a[i]>=a[j+1]，由于找 j 是由后向前找，所以必有a[i]>=a[j+1]
         * 否则如果a[j+1]>a[i]被选择的就是j+1而不是j。 另一方面，由于搜寻i的规则，必有a[j-1]>=a[j]
         * (否则的话此时选到的是j-1而不是i),同时a[j]>a[i]所以a[j-1]>a[i]，即a[j-1]>=a[i]。 Done。
         * @param nums
         */
        private void method1(int[] nums) {
            //先寻找满足条件a[i]<a[i-1]的数
            int i = nums.length-2;
            while (i>=0){
                if (nums[i]<nums[i+1]){
                    break;
                }
                i--;
            }
            int j = nums.length-1;
            if (i>=0) {
                //从后往前寻找满足a[j]>a[i]的第一个数
                while (j>i){
                    if (nums[j]>nums[i]){
                        break;
                    }
                    j--;
                }
                //交换ij元素
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            //将i+1和后面的元素升序排列
            Arrays.sort(nums,i+1,nums.length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
