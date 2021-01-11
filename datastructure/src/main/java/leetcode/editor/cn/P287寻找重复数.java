//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 3 * 104 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以在不修改数组 nums 的情况下解决这个问题吗？ 
// 你可以只用常量级 O(1) 的额外空间解决这个问题吗？ 
// 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？ 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 1039 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：寻找重复数
public class P287寻找重复数{
    public static void main(String[] args) {
        Solution solution = new P287寻找重复数().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 二分法
     *
     */
    class Solution {
    public int findDuplicate(int[] nums) {
        //return method1(nums);
        //return method2(nums);
        return method3(nums);

    }

        /**
         * 二分查找法：
         * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
         *
         * 第一页评论区原作者回复JerryChaox的思想
         * 不是大佬。我认为：弄不清楚边界条件，是不太认真，也有可能是在背模板，没有搞清楚里面非常细节的地方。
         *
         * 下面提到的一些点可能不是您存在的问题，如果讲得过分了，还请您谅解，在这里给同样有问题的朋友提个醒：
         *
         * 我的经验是把定义区间成为左闭右闭区间，左右边界是无差别的，弄成左闭右开，反而增加了思考的复杂程度；
         * 明确 int = left + ( right - left ) / 2 这里除以 2 是下取整；
         * 明确 while(left <= right) 和 while(left < right) 这两种写法其实在思路上有本质差别， while(left <= right) 在循环体内部直接查找元素，而 while
         * (left < right) 在循环体内部一直在排除元素，第 2 种思路在解决复杂问题的时候，可以使得问题变得简单；
         * 始终在思考下一轮搜索区间是什么，把它作为注释写到代码里面，就能帮助我们搞清楚边界是不是能取到，等于、+1 、-1 之类的细节；
         * 思考清楚每一行代码背后的语义是什么，保证语义上清晰，也是写对代码，减少 bug 的一个非常有效的策略。
         * 在下面的视频题解里，我都非常具体地讲解了我是怎么分析和做二分查找问题的。
         *
         * 二分查找不难，只是在考察我们是否细心，如果面试中遇到，是一定要拿下的。
         *
         * 第 35 题：题解；
         *
         * 第 1095 题：官方题解；
         *
         * 第 4 题：官方题解。
         *
         * 下面是非常重要的一点，希望能对看到的朋友有帮助，我写三遍：
         *
         * 先搞懂思路，再研究细节，多做问题去应用。
         * 先搞懂思路，再研究细节，多做问题去应用。
         * 先搞懂思路，再研究细节，多做问题去应用。
         * 个人意见，仅供参考。
         * @param nums
         * @return
         */
        private int method3(int[] nums) {
            int left = 1;
            int right = nums.length-1;
            while (left < right){
                int mid = left + (right-left)/2;
                //先统计小于等于mid的元素个数，如果这个元素个数大于mid，那重复元素一定在[left,mid]之间
                int count = 0;
                for (int num : nums) {
                    if (num <= mid){
                        count++;
                    }
                }
                if (count > mid){
                    //说明重复元素在[left，mid]之间
                    right = mid;
                }else{
                    //重复元素在[mid+1，right]之间
                    left = mid + 1;
                }
            }
            return left;
        }

        /**
         * 使用数组或者hash表
         * @param nums
         * @return
         */
        private int method2(int[] nums) {
            int[] res = new int[nums.length+1];
            for (int num : nums) {
                if (res[num] > 0){
                    return num;
                }else{
                    res[num] += 1;
                }
            }
            return 0;
        }

        /**
         * 暴力法
         * @param nums
         * @return
         */
        private int method1(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]){
                    return nums[i];
                }
            }
            return 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
