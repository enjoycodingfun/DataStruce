//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 96 👎 0


package leetcode.editor.cn;

//Java：数组中出现次数超过一半的数字
public class P剑指 Offer 39数组中出现次数超过一半的数字{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 39数组中出现次数超过一半的数字().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 本题目采用摩尔投票法:
     * 思路：将初始候选人定为nums[0]，他的票数定为1，后续遇到与他相同的则票数加一；否则票数减一
     * 假如票数变为0了，就换下一数作为候选人，因为票数变为0之后，多数元素一定在剩下的元素里面，哪怕他与
     * 前面的几个元素中某一元素相等
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int res = nums[0],count=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res){
                count++;
            }else{
                count--;
                if (count == 0){
                    res = nums[i];
                    count = 1;
                }
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
