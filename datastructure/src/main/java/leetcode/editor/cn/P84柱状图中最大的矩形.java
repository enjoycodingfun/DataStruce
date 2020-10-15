//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 954 👎 0


package leetcode.editor.cn;

//Java：柱状图中最大的矩形
public class P84柱状图中最大的矩形 {

    public static void main(String[] args) {
        Solution solution = new P84柱状图中最大的矩形().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
     */
    class Solution {

        public int largestRectangleArea(int[] heights) {
            /**
             * 方法一，采用题解中提到的暴力解法，对每一个柱子，查看下左右延长的最大宽度，乘以这个柱子高度就可以，依次取出最大值
             */
            if (heights == null || heights.length == 0) {
                return 0;
            }
            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                //计算左边可以扩展的最大距离
                int leftIndex = i;
                while (leftIndex > 0 && heights[leftIndex-1] >= heights[i]){
                    leftIndex--;
                }
                //计算右边可以扩展的最大距离
                int rightIndex = i;
                while (rightIndex < heights.length-1 && heights[rightIndex+1] >= heights[i]){
                    rightIndex++;
                }
                //计算面积
                int area = (rightIndex-leftIndex+1)*heights[i];
                if (area > max){
                    max = area;
                }
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
