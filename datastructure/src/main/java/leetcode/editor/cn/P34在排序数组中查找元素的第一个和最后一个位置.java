//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 611 👎 0


package leetcode.editor.cn;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        Solution solution = new P34在排序数组中查找元素的第一个和最后一个位置().new Solution();
        // TO TEST
    }

    /**
     * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/da-jia-bu
     * -yao-kan-labuladong-de-jie-fa-fei-chang-2/
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int startIndex = findStartIndex(nums, target);
            //由于上面的方法已经找了第一次出现的地方，如果没找到，肯定不会有第二次出现的地方，直接返回即可
            /*if (startIndex == -1) {
                return new int[]{-1, -1};
            }*/
            //假如我们不依赖上面找第一个位置时候的边界条件判定，就需要在findLastIndex补充上他自己的边界判定
            int lastIndex = findLastIndex(nums, target);
            return new int[]{startIndex, lastIndex};
        }


        private int findStartIndex(int[] nums, int target) {
            /**
             * 这里是找第一次出现的地方，所有当找到相等的值时候不应该返回，而应该继续往左边找
             */
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    //继续向左搜索[left,mid-1]区间搜索①
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            /**
             *当循环结束的时候，left>right;此时有两种边界情况需要判定
             *假设target很大，这个时候由于一直往右边找，最后的结果可能是left越界即left = nums.length，这个时候right对应的位置是target坐标（但不一定是第一个）
             * 假设target很小，由于一直往左边找，最后的结果可能是right越界，此时判断left对应的值是否是target即可
             */
            //此时 left 和 right 的位置关系是 [right, left]，注意上面的 ①，此时 left 才是第 1 次元素出现的位置（下面做边界判定）
            if (left != nums.length && nums[left] == target) {
                //这种情况下对应的left一定是第一次出现target的坐标
                return left;
            }
            return -1;
        }
        private int findLastIndex(int[] nums, int target) {
            /**
             * 这里是找最后一次出现的地方，所有当找到相等的值时候不应该返回，而应该继续往右边找，代码大部分与往左边找类似
             */
            int left = 0;
            int right = nums.length-1;
            while (left <= right){
                int mid = left + (right -left)/2;
                if (nums[mid] == target) {
                    //这是应该继续往右边找
                    left = mid + 1;
                }else if (nums[mid] > target){
                    right = mid -1;
                }else if (nums[mid] < target){
                    left = mid + 1;
                }
            }
            //方法一：由于前面调用找最左边的情况的时候已经判定了边界，所以这里不需要判定，直接返回right即可(为什么是right，同理与上面的返回left)
            //return right;
            //方法二：上面由于依赖了找最左边的情况的时候已经判定了边界，所以不需要再判定，假设这里不依赖前面的方法，需要自己判定边界
            //当target较小时，最后right越界mid-1变成-1，当target较大时，left越界，right对应的数据才是最后一个
            if (right != -1 && nums[right] == target){
                return right;
            }
            return -1;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
