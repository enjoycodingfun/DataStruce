//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 数组 
// 👍 475 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//Java：最短无序连续子数组
public class P581最短无序连续子数组 {

    public static void main(String[] args) {
        Solution solution = new P581最短无序连续子数组().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findUnsortedSubarray(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return 0;
            }
            //return method1(nums);
            return method2(nums);
        }

        /**
         * 使用栈来完成
         * @param nums
         * @return
         */
        private int method2(int[] nums) {
            int start = nums.length,end = 0;
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                while (!queue.isEmpty()&&nums[i] < nums[queue.peek()]){
                    start = Math.min(start,queue.poll());
                }
                queue.push(i);
            }
            queue.clear();
            for (int i = nums.length-1; i >= 0  ; i--) {
                while (!queue.isEmpty()&&nums[i] > nums[queue.peek()]){
                    end = Math.max(end,queue.poll());
                }
                queue.push(i);
            }
            return end-start>=0?end-start+1:0;
        }

        /**
         * 排序后再对比，找到左右下标进行计算
         * @param nums
         * @return
         */
        private int method1(int[] nums) {
            //先找到第一个比它前面小的数，再找到最后一个比它后面所有数字都小的
            int[] sortedNums = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sortedNums);
            int start = nums.length,end = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sortedNums[i] != nums[i]){
                    start = Math.min(start,i);
                    end = Math.max(end,i);
                }
            }
            return end-start>=0?end-start+1:0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
