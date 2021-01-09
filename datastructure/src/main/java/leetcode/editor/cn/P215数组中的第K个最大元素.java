//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 845 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

//Java：数组中的第K个最大元素
public class P215数组中的第K个最大元素{
    public static void main(String[] args) {
        Solution solution = new P215数组中的第K个最大元素().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 快排
     */
    class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //return method1(nums,k);
        //return method2(nums,k);
        //return method3(nums,k);
        return method4(nums,k);

    }

        /**
         * 最常见的双指针法快排，比方法三更好理解
         * @param nums
         * @param k
         * @return
         */
        private int method4(int[] nums, int k) {
            int len = nums.length;
            int target = len - k;
            int left = 0,right = len - 1;
            while (true){
                int res = partition2(nums,left,right);
                if (res == target){
                    return nums[res];
                }else if (res < target){
                    left = res + 1;
                }else {
                    right = res - 1;
                }
            }
        }

        private int partition2(int[] nums, int left, int right) {
            int center = nums[left];
            int  len = nums.length;
            int l = left+1,r = right;
            while (true){
                while (l <= r && nums[l] < center){
                    //一直找小于center的
                    l++;
                }
                while (l <= r && nums[r] > center){
                    //一直找大于center的
                    r--;
                }
                if (l>r){
                    break;
                }
                //找到后交换两者的值
                swap(nums,l,r);
                //继续往下找
                l++;
                r--;
            }
            //最后交换center和r的值
            swap(nums,left,r);
            return r;
        }


        /**
         * 快速排序法，排好顺序后找到第len-k个元素
         * @param nums
         * @param k
         * @return
         */
        private int method3(int[] nums, int k) {
            int len = nums.length;
            int target = len - k;
            int left = 0,right = len - 1;
            while (true){
                int res = partition(nums,left,right);
                if (res == target){
                    return nums[res];
                }else if (res < target){
                    left = res + 1;
                }else {
                    right = res - 1;
                }
            }
        }

        private int partition(int[] nums, int left, int right) {
            int center = nums[left];
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < center){
                    j++;
                    if (j != i){
                        swap(nums,i,j);
                    }
                }
            }
            //经过上面的遍历已经满足除center外，（left+1，j）< center [j+1,right]>center，之后将center换到j的位置
            //返回j的下标就是我们要找的target
            swap(nums,left,j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        /**
         * 优先队列
         * @param nums
         * @param k
         * @return
         */
        private int method2(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.add(num);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            return queue.peek();
        }

        /**
         * 无脑排序法
         * 时间复杂度：O(NlogN)，这里 NN 是数组的长度，算法的性能消耗主要在排序，JDK 默认使用快速排序，因此时间复杂度为 O(N \log N)O(NlogN)。
         * 空间复杂度：O(1)，这里是原地排序，没有借助额外的辅助空间。
         * @param nums
         * @param k
         * @return
         */
        private int method1(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length-k];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
