//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 533 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：找到所有数组中消失的数字
public class P448找到所有数组中消失的数字 {

    public static void main(String[] args) {
        Solution solution = new P448找到所有数组中消失的数字().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 参考题解：
     * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/xiang-xi-tu-jie-448zhao-dao
     * -suo-you-shu-zu-zhong-x/
     */
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            //找到数字对应的下标之后将对应位置的数字置为负数
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                //用绝对值是因为这个位置的数字可能已经被置为负数了
                int index = Math.abs(nums[i])-1;
                if (nums[index]>0) {
                    nums[index] *= -1;
                }
            }
            //第二遍遍历数组，得到值为正数的减去一对应的数字就是缺失的数字
            for (int i = 1; i <= nums.length; i++) {
                if (nums[i-1]>0){
                    res.add(i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
