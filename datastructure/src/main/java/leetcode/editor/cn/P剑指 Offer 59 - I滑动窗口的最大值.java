//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 164 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：滑动窗口的最大值
public class P剑指 Offer 59 - I滑动窗口的最大值{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 59 - I滑动窗口的最大值().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        return method1(nums,k);
    }

        private int[] method1(int[] nums, int k) {
            int[] res = new int[nums.length-k+1];
            Deque<Integer> deque = new ArrayDeque<>();
            int index = 0;//当前结果集中的数字下标
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty()&&nums[i]>nums[deque.peekLast()]) {
                    //当往队列中添加当前元素的时候，队列尾部小于当前元素的都移除，这样就保证队列首部的一定是最大值
                    deque.pollLast();
                }
                //添加当前元素下标进队列尾部
                deque.addLast(i);
                //验证队列首部的元素是否有效，因为窗口大小为k，假如当前遍历到了第i个元素，即窗口rightg=i，那么窗口left>=i-k+1，
                // 即队列首部元素下标需要满足该大小，否则就要出队了
                if (deque.peekFirst()<i-k+1){
                    deque.pollFirst();
                }
                //当遍历元素窗口已经形成的时候开始往结果集中写入数据
                if (i>=k-1){
                    res[index++] = nums[deque.peekFirst()];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
