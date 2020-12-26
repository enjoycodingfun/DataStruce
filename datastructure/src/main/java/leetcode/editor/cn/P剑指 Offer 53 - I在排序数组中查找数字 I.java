//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 83 👎 0


package leetcode.editor.cn;

//Java：在排序数组中查找数字 I
public class P剑指 Offer 53-I在排序数组中查找数字 I{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 53-I在排序数组中查找数字 I().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int count = 0;

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //return method1(nums,target);
        return method2(nums,target,0,nums.length-1);

    }

    private int method2(int[] nums, int target, int low, int high) {
        if (low <= high){
            int mid = low + (high-low)/2;
            if (nums[mid] == target){
                count++;
                method2(nums, target, low, mid-1);
                method2(nums, target, mid+1, high);
            }else if(nums[mid] > target){
                method2(nums, target, low, mid-1);
            }else if (nums[mid] < target){
                method2(nums, target, mid+1, high);
            }
        }
        return count;
    }

    /**
     * 无脑暴力法
     * @param nums
     * @param target
     * @return
     */
    private int method1(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=target){
                index = i;
                break;
            }
        }
        if (nums[index]>target){
            return 0;
        }
        int count = 0;
        while (index < nums.length && nums[index++] == target){
            count++;
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
