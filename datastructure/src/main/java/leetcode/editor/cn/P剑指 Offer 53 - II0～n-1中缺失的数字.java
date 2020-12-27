//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 数组 二分查找 
// 👍 89 👎 0


package leetcode.editor.cn;

//Java：0～n-1中缺失的数字
public class P剑指 Offer 53-II0～n-1中缺失的数字{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 53-II0～n-1中缺失的数字().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int missingNumber(int[] nums) {
        //return method1(nums);
        return method2(nums);


    }

    /**
     * 方法二采用二分法，因为方法一当数据量较大时，时间复杂度较高，所以采用二分法降低时间复杂度到O(logN)
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] != mid){
                //那么下标一定在左子数组
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }


    /**
     * 方法一：无脑暴力法：时间复杂度O[n]
     * 思路，按照题目意思，应该是每一位数字下标与数字相等，比如对应题目的[0,1,3]
     * nums[0]=0,nums[1]=1,nums[2]=3,可以发现nums[2] != 2，所以返回nums[2]-1=3-1=2
     * 如果是缺失最后一位，则返回nums数组最后一位加一
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                return nums[i]-1;
            }
        }
        return nums[nums.length-1]+1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
