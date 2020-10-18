//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
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
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 594 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：滑动窗口最大值
public class P239滑动窗口最大值 {

    public static void main(String[] args) {
        Solution solution = new P239滑动窗口最大值().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length <=0 || k <= 0) {
                return nums;
            }
            /**
             * 方法一：暴力破解，但是会超时
             */
            //一共能找到nums.length-k+1次最大值
            /*int[] res = new int[nums.length-k+1];
            //滑动窗口的最后一位
            int max = Integer.MIN_VALUE;
            for (int last = k-1; last < nums.length ; last++) {
                //遍历当前在滑动窗口内的值进行大小比较并添加进数组
                for (int i = last-k+1; i <= last ; i++) {
                    max = Math.max(max,nums[i]);
                }
                res[last-k+1] = max;
                //记得把max重置回去，不然就是上一轮得到的最大值了
                max = Integer.MIN_VALUE;
            }
            return res;*/
            /**方法二：参考题解
             * https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/
             * https://leetcode-cn.com/problems/sliding-window-maximum/solution/3chong-jie-jue-fang-shi-by-sdwwld/
             * 思路如下：
             * 1.如果队列是空的，直接加入元素下标（比如数组第一个元素的下标）
             * 2.当队列非空的时候，在队尾加入元素下标的时候，先判断要加入的元素下标对应值和队列前面值的大小，把前面小于当前元素的值都移出队列（从尾部移出），这样就保证了队列
             * 头部的一定是最大值
             * 3.当队列中的元素个数达到k个的时候开始，将队列头部的元素添加到结果数组中
             * 4.当队列中元素
             */
            //一共能找到nums.length-k+1次最大值
            int[] res = new int[nums.length-k+1];
            Deque<Integer> queue = new ArrayDeque<>();
            int index = 0;//当前在结果集中的数字下标
            for (int i = 0; i < nums.length; i++) {
                //如果往队列中添加当前元素时，队列中小于当前元素的都要移除
                while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                    queue.pollLast();
                }
                //添加当前元素下标进队列尾部
                queue.addLast(i);
                //判断当前队首的元素是否有效，是否在滑动窗口范围内，当前遍历的元素i，即滑动窗口R=i，L=i-k+1，当队首元素（即下标)<L的时候，就需要出队了
                if (queue.peekFirst()<=i-k){
                    queue.poll();
                }
                //当i已经大于k的时候，说明窗口已经形成了，开始进行最大值往结果集中写的过程
                if (i>=k-1){
                    res[index++] = nums[queue.peekFirst()];
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
