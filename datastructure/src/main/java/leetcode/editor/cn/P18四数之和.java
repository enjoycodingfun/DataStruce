//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 648 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：四数之和
public class P18四数之和 {

    public static void main(String[] args) {
        Solution solution = new P18四数之和().new Solution();
        // TO TEST
    }

    /**
     * 精选题解
     * https://leetcode-cn.com/problems/4sum/solution/ji-bai-9994de-yong-hu-you-dai-ma-you-zhu-shi-by-yo/
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 思路：
         * 1）参考三数之和，排序后，定义k,i,left,right四个指针，其中k是老大，从0，开始遍历到nums.legth-4
         * i定义为k+1，left定义为i+1，right定义为nums.legth-1
         * 2）外层循环遍历k[0-nums.legth-4](k最多遍历到倒数第四个)，内层循环遍历i[k+1,nums.length-3]（i最多遍历到倒数第三个），
         * 在遍历i的时候进行left和right及k和i四数之和的计算
         * 3）遍历k和i的过程中用最大值，最小值比较下，减少计算次数，遍历过程中依然要去除重复项，对于left和right的移动也要注意去除
         * 重复项
         */

        public List<List<Integer>> fourSum(int[] nums, int target) {
            //参考三数之和
            if (nums == null || nums.length < 4) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            //先给数组排序
            Arrays.sort(nums);
            //外层遍历老大k
            for (int k = 0; k < nums.length - 3; k++) {
                //如果和前面的重复了，就跳过,别忘记前面的k>0
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                //计算这一层时候的最小值和，如果这个最小值已经比target大了，没必要遍历后面的更大值了
                int minK = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
                if (minK > target) {
                    break;
                }
                //计算这一层时候的最大值和，如果这个最大值已经比target小了，那么移动k值，继续下一次遍历
                int maxK = nums[k] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
                if (maxK < target) {
                    //注意这里不是break，因为这种情况下移动k值是有可能满足target的
                    continue;
                }
                //第二层遍历老二i
                for (int i = k + 1; i < nums.length - 2; i++) {
                    //老规矩，参考外层写这一层的中止条件
                    if (i > k + 1 && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    //定义剩下两个数的指针left（i+1），right
                    int left = i + 1;
                    int right = nums.length - 1;
                    //计算这一层时候的最小值和，如果这个最小值已经比target大了，没必要遍历后面的更大值了
                    int minI = nums[k] + nums[i] + nums[left] + nums[left + 1];//nums[k]+nums[i]+nums[i+1]+nums[i+2];
                    if (minI > target) {
                        break;
                    }
                    //计算这一层时候的最大值和，如果这个最大值已经比target小了，那么移动i值，继续下一次遍历
                    int maxI = nums[k] + nums[i] + nums[right] + nums[right - 1];
                    if (maxI < target) {
                        //注意这里是continue
                        continue;
                    }
                    //遍历移动left和right
                    while (left < right) {
                        //如果以上情况都OK对比四数之和与target的大小
                        int sum = nums[k] + nums[i] + nums[left] + nums[right];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                            //继续进行下一组寻找同时避开相等的值
                            while (left < right && nums[left + 1] == nums[left]) {
                                //注意当跳出这个while循环的时候，当前left指向的元素与下一个确实不相等了，但是与其上一个还是相等的，所以我们需要在跳出循环之后继续left+1
                                left++;
                            }
                            //注意
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            //跳出循环后需要对左右指针往内部靠拢以下，如果没有循环，也是需要直接靠拢的
                            left++;
                            right--;
                        } else if (sum > target) {
                            right--;
                        } else if (sum < target) {
                            left++;
                        }
                    }
                }

            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
