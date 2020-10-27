//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 774 👎 0


package leetcode.editor.cn;

//Java：多数元素
public class P169多数元素 {

    public static void main(String[] args) {
        Solution solution = new P169多数元素().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int majorityElement(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            /**
             * 方法一：暴力法
             */
            /*HashMap<Integer,Integer> map = new HashMap<>(nums.length);
            for (int num : nums) {
                map.put(num,map.getOrDefault(num,0)+1);
                if (map.get(num)>nums.length/2){
                    return num;
                }
            }
            return 0;*/
            /**
             * 方法二，排序法，从小到大排序后位于数组中间的一定是多数元素
             */
            /*Arrays.sort(nums);
            return nums[nums.length/2];*/
            /**
             * 方法三：采用优先队列topK
             */
            /*int len = (nums.length + 1) >> 1;
            //优先队列的内部实现是二叉小顶堆
            PriorityQueue<Integer> pQueue = new PriorityQueue<>(len, Comparator.comparingInt(item -> -item));
            for (int num : nums) {
                pQueue.offer(num);
                if (pQueue.size() > len)
                    pQueue.poll();
            }
            return pQueue.poll();*/
            /**
             * 方法四：摩尔投票法
             * https://leetcode-cn.com/problems/majority-element/solution/3chong-fang-fa-by-gfu-2/
             */
            int countNum = nums[0],count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (countNum == nums[i]){
                    count++;
                }else{
                    count--;
                    if (count == 0){
                        countNum = nums[i];
                        count = 1;
                    }
                }
            }
            return countNum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
