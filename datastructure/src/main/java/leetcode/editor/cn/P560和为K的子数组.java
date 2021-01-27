//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 747 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：和为K的子数组
public class P560和为K的子数组 {

    public static void main(String[] args) {
        Solution solution = new P560和为K的子数组().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int subarraySum(int[] nums, int k) {

            //return method1(nums, k);
            return method2(nums, k);
        }

        /**
         * 前缀和加哈希表优化
         * @param nums
         * @param k
         * @return
         */
        private int method2(int[] nums, int k) {
            // key：前缀和，value：key 对应的前缀和的个数
            Map<Integer,Integer> preSumMap = new HashMap<>();
            // 对于下标为 0 的元素，前缀和为 0，个数为 1
            preSumMap.put(0,1);

            int preSum = 0;
            int count = 0;
            for (int num : nums) {
                preSum += num;
                if (preSumMap.containsKey(preSum-k)){
                    count += preSumMap.get(preSum-k);
                }
                preSumMap.put(preSum,preSumMap.getOrDefault(preSum,0)+1);
            }
            return count;
        }

        /**
         * 前缀和：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
         */
        private int method1(int[] nums, int k) {
            //构建前缀和
            int[] preSum = new int[nums.length+1];
            preSum[0] = 0;
            //构建前缀和数组，注意前缀和不包含当前位置元素，比如preSum[i+1]不包含nums[i+1]
            for (int i = 0; i < nums.length; i++) {
                preSum[i+1] = preSum[i]+nums[i];
            }
            //计算区间和
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    //计算[i,j]这个区间的和，就是用preSum[j]-preSum[i](注意这里是preSum[j+1]，因为preSum[j]是不包括j的)或者上面是
                    // j<=nums.length,下面是preSum[j+1]-preSum[i]
                    if (preSum[j+1]-preSum[i] == k){
                        count++;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
