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
        return method1(nums);

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
