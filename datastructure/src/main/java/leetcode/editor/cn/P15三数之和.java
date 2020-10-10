//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2666 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15三数之和 {

    public static void main(String[] args) {
        Solution solution = new P15三数之和().new Solution();
        // TO TEST
    }

    /**
     * https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
     * 双指针法思路： 固定 3 个指针中最左（最小）数字的指针 k，双指针 i，j 分设在数组索引 (k, len(nums))(k,len(nums)) 两端，通过双指针交替向中间移动，记录对于每个固定指针 k 的所有满足
     * nums[k] + nums[i] + nums[j] == 0 的 i,j 组合：
     * 当 nums[k] > 0 时直接break跳出：因为 nums[j] >= nums[i] >= nums[k] > 0，即 33 个数字都大于 00 ，在此固定指针 k 之后不可能再找到结果了。
     * 当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
     * i，j 分设在数组索引 (k, len(nums))(k,len(nums)) 两端，当i < j时循环计算s = nums[k] + nums[i] + nums[j]，并按照以下规则执行双指针移动：
     * 当s < 0时，i += 1并跳过所有重复的nums[i]；
     * 当s > 0时，j -= 1并跳过所有重复的nums[j]；
     * 当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
     * 复杂度分析：
     * 时间复杂度 O(N^2)O(N
     * 2
     *  )：其中固定指针k循环复杂度 O(N)O(N)，双指针 i，j 复杂度 O(N)O(N)。
     * 空间复杂度 O(1)O(1)：指针使用常数大小的额外空间。

     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            if(nums == null || nums.length < 3){
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            //首先给数组排序
            Arrays.sort(nums);
            //首先定位一个元素,用于遍历时的首个数字，之后在定位左右指针指向这个数字之后的数字（所以这个数字只要到倒数第三个就行了）
            for (int i = 0; i < nums.length-2; i++) {
                if (nums[i]>0) {
                    //首个数字已经大于零，后面的比这个数字还大，那么三个数字之和一定大于零，不必再遍历了
                    break;
                }
                //别忘记前面的i>0条件
                if (i>0 && nums[i] == nums[i-1]) {
                    //说明这个数字已经做过一次首位数字了，为了避免重复，去除掉
                    continue;
                }
                //定位左右指针
                int left = i + 1;
                int right = nums.length-1;
                while (left < right){
                    int sum = nums[i]+nums[left]+nums[right];
                    if (sum == 0){
                        //这只是以当前定位数字为老大，找到的第一个老二老三，还需要继续以该数字为老大，找别的老二老三（即左右指针需要继续往内部走）
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        //continue;注意这里不应该continue，应该继续找把左右指针往中间靠拢，但同时需要去重（不仅是老大需要去重，老二老三遍历过程中也要去重）
                        while (left < right && nums[left+1] == nums[left]){
                            //注意当跳出这个while循环的时候，当前left指向的元素与下一个确实不相等了，但是与其上一个还是相等的，所以我们需要在跳出循环之后继续left+1
                            left++;
                        }
                        while (left < right && nums[right-1] == nums[right]){
                            right--;
                        }
                        //如果左右指针没有重复的，直接往内部靠拢即可
                        left++;
                        right--;
                    }else if (sum > 0){
                        //有点偏大，这个时候移动右指针
                        right--;
                    }else if (sum < 0){
                        //有点偏小，移动左指针
                        left++;
                    }
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
