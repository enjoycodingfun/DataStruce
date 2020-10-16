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

import java.util.ArrayDeque;
import java.util.Deque;

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
             *
             * 时间复杂度：O(N^2)，这里 NN 是输入数组的长度。
             * 空间复杂度：O(1)。
             */
            if (heights == null || heights.length == 0) {
                return 0;
            }
            /*int max = 0;
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
            return max;*/
            /**
             * 方法二：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/xiang-jie-dan-diao-zhan-bi-xu-miao-dong-by-sweetie/
             * 参考如上题解，大概思路过程是，遍历柱子下标的过程，如果当前柱子高度大于等于栈顶柱子高度的时候就进栈，如果小于栈顶柱子高度，说明当前柱子就是比栈顶柱子小的最右边
             * 的柱子，这个时候可以计算栈顶柱子可以构成的面积，因为栈中元素单调递增，所以栈顶柱子的组成的最大面积其实就是1*h（栈顶柱子），计算后栈顶柱子出栈，计算新的栈顶
             * 柱子组成的最大面积（2-1）*h(新的栈顶柱子)，所以就是h*（i-栈顶柱子的下一个-1）
             */
            //在原数组左右两边加入哨兵节点0方便计算
            int[] newHeight = new int[heights.length+2];
            System.arraycopy(heights,0,newHeight,1,heights.length);
            //构建栈，官方推荐用deque
            Deque<Integer> stack = new ArrayDeque<>();
            int max = 0;
            //开始遍历新数组
            for (int i = 0; i < newHeight.length; i++) {
                while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]){
                    // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
                    // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
                    // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积（摘抄自题解）
                    int h = newHeight[stack.pop()];//注意这个时候我们要计算的栈顶柱子已经出栈
                    int area = h * (i-stack.peek()-1);//也可以提前保存栈顶元素下标，没有保存这里就只能通过新的栈顶元素计算
                    max = Math.max(max,area);
                }
                //当前遍历的柱子高度大于栈顶元素高度直接入栈
                stack.push(i);
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
