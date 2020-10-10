//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找 
// 👍 411 👎 0


package leetcode.editor.cn;

//Java：两数之和 II - 输入有序数组
public class P167两数之和2输入有序数组 {

    public static void main(String[] args) {
        Solution solution = new P167两数之和2输入有序数组().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] twoSum(int[] numbers, int target) {
            //使用双指针，左右指针分别指向首尾元素，之后再采用二分法的思路来解题
            if (numbers == null || numbers.length == 0) {
                return new int[0];
            }
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] == target) {
                    return new int[]{left + 1, right + 1};
                } else if (numbers[left] + numbers[right] > target) {
                    right--;
                } else if (numbers[left] + numbers[right] < target) {
                    left++;
                }
            }
            return new int[0];
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)


