//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 194 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：和为s的连续正数序列
public class P剑指 Offer 57 - II和为s的连续正数序列{
    public static void main(String[] args) {
        Solution solution = new P剑指 Offer 57 - II和为s的连续正数序列().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        return method1(target);

    }

        /**
         * 方法一：滑动窗口，思路如下：
         * 在这道题中，我们关注的是滑动窗口中所有数的和。当滑动窗口的右边界向右移动时，也就是 j = j + 1，窗口中多了一个数字 j，窗口的和也就要加上 j。当滑动窗口的左边界向右移动时，也就是 i = i +
         * 1，窗口中少了一个数字 i，窗口的和也就要减去 i。滑动窗口只有 右边界向右移动（扩大窗口） 和 左边界向右移动（缩小窗口） 两个操作
         * 窗口何时扩大何时缩小：
         *
         * 当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
         * 当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
         * 当窗口的和恰好等于 target 的时候，我们需要记录此时的结果。设此时的窗口为 [i, j)[i,j)，那么我们已经找到了一个 ii 开头的序列，也是唯一一个 ii 开头的序列，接下来需要找 i+1i+1
         * 开头的序列，所以窗口的左边界要向右移动
         * 时间复杂度O(N),空间复杂度O(N)
         * @param target
         * @return
         */
        private int[][] method1(int target) {
            int left = 1,right = 1,sum = 0;
            List<int[]> list = new ArrayList<>();
            while (left <= target/2){
                if (sum < target){
                    //和小于target，则右边界右移
                    sum += right;
                    right++;
                }else if (sum > target){
                    //和大于target，则左边界右移
                    sum -= left;
                    left++;
                }else{
                    int[] res = new int[right-left];
                    for (int i = left; i < right; i++) {
                        res[i-left] = i;
                    }
                    list.add(res);

                    sum -= left;
                    left++;
                }
            }
            return list.toArray(new int[list.size()][]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
