//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 227 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：数组中重复的数字
public class P剑指 Offer 03数组中重复的数字{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 03数组中重复的数字().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findRepeatNumber(int[] nums) {
        //return method1(nums);
        return method2(nums);
    }
    /**
     * 原地置换方法：
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/yuan-di-zhi-huan-shi-jian-kong-jian-100-by-derrick/
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
     * 如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，所以思路是重头扫描数组，遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换。在交换过程中，如果有重复的数字发生，那么终止返回ture
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
        int i = 0;
        while (i<nums.length){
            if (nums[i] == i){
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]){
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    private int method1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int rep = -1;
        for (int num : nums) {
            if (!set.add(num)){
                rep = num;
                break;
            }
        }
        return rep;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
