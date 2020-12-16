//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 64 👎 0


package leetcode.editor.cn;

//Java：调整数组顺序使奇数位于偶数前面
public class P剑指 Offer 21调整数组顺序使奇数位于偶数前面{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 21调整数组顺序使奇数位于偶数前面().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] exchange(int[] nums) {
        return method1(nums);

    }

    /**
     * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/mian-shi-ti-21-diao-zheng-shu-zu-shun-xu-shi-qi-4/
     * @param nums
     * @return
     */
    private int[] method1(int[] nums) {
        int left = 0,right = nums.length-1,tmp;
        while (left < right){
            //left一直往右找偶数
            while (left < right &&(nums[left]&1)==1){
                left++;
            }
            //right一直往左找奇数
            while (left < right && (nums[right]&1)==0){
                right--;
            }
            //找到后交换两者
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
