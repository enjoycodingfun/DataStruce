//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1913 👎 0


package leetcode.editor.cn;

//Java：盛最多水的容器
public class P11盛最多水的容器 {

    public static void main(String[] args) {
        Solution solution = new P11盛最多水的容器().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 乘水的容量怎么计算假设选定的两个值是height[i]与height[j],则area=（j-i）*min(a[i],a[j]);
     */
    class Solution {

        public int maxArea(int[] height) {

            if (height == null || height.length < 2) {
                return 0;
            }
            int max = 0;
            //方法一采用双层循环最笨的方法计算,时间复杂度o(n2),空间复杂度o(1)
            /*for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    int area = (j - i) * Math.min(height[i], height[j]);
                    if (area > max) {
                        max = area;
                    }
                }
            }*/
            /**
             * 方法二，采用双指针的形式，其中初始化左指针指向头结点，尾指针指向末尾节点，之后移动左右两边高度较小的那个（因为它是体积的短板）;
             * 最后返回max值,时间复杂度O（N）双指针最多遍历数组一次，空间复杂度O(1)
             */
            int start = 0;
            int end = height.length-1;
            while (start < end){
                int area = (end - start) * Math.min(height[start], height[end]);
                if (area > max) {
                    max = area;
                }
                if (height[start] >= height[end]){
                    end--;
                }else if (height[start] < height[end]){
                    start++;
                }
            }
            return max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
