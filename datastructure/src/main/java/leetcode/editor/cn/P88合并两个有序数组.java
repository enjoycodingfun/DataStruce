//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 658 👎 0


package leetcode.editor.cn;

//Java：合并两个有序数组
public class P88合并两个有序数组 {

    public static void main(String[] args) {
        Solution solution = new P88合并两个有序数组().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            /**
             * 首先想到双指针的方式，一个指针指向nums1尾部元素，一个指向nums2尾部元素；谁大谁放进nums1末尾
             * https://leetcode-cn.com/problems/merge-sorted-array/solution/jiang-qing-chu-mei-yi-xing-dai-ma-zui-hao-li-jie-d/
             */
            int i = m - 1;//nums1的最后一个元素下标（参与排序的最后一个）
            int j = n - 1;//nums2的最后一个元素下标（参与排序的最后一个）
            int maxIndex = nums1.length-1;//当前要放置最大值的nums1的下标
            while (i >= 0 && j >= 0 ){
                //比较最大值，然后放入maxIndex
                if (nums1[i] > nums2[j]){
                    nums1[maxIndex--] = nums1[i--];
                }else {
                    nums1[maxIndex--] = nums2[j--];
                }
            }
            //假如经过上面的循环遍历，有两种情况，一种nums2已经遍历完了，nums1还有，这种情况不需要处理，因为剩余的nums1正好是排好序的，另外一种情况是
            //nums1已经遍历完了，需要把nums2剩余的元素放到nums1的前面，下面处理这种情况
            while (j >= 0 ){
                nums1[maxIndex--] = nums2[j--];
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
