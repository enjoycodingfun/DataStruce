//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 715 👎 0


package leetcode.editor.cn;

//Java：旋转数组
public class P189旋转数组 {

    public static void main(String[] args) {
        Solution solution = new P189旋转数组().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0) {
                return;
            }
            /**
             * 方法一，不要想着一步到位，想简单点，旋转k个位置实际上就是将每次往后挪动一个这个动作循环执行k次
             * 所以关键是往后移动一个元素的写法，a0会移动到a1去，此时需要将a1临时保存起来，之后将a1赋值为a0，
             * 之后需要保存a2,一直到最后a[length-1]保存到a0位置
             * 时间复杂度O(N*K),空间复杂度o（1）
             */
            /*for (int i = 0; i < k; i++) {
                //外循环控制重复操作次数
                int pre = nums[nums.length-1];
                //将每一个元素替换为它前面的那个元素，第一个用last替换
                for (int j = 0; j < nums.length; j++) {
                    int tmp = nums[j];
                    nums[j] = pre;
                    pre = tmp;
                }
            }*/
            //方法一时间复杂度太高，下面使用来自题解中的理解方式（n个同学换座位n次）
            //首先将k对数组长度取模，因为假如数组长度为5，往后移动两个，那么移动2,7,12其实都和移动2一个效果
            int len = nums.length;
            k = k % len;
            int count = 0;//count用来计算交换位置的次数，n个元素交换n次就可以了
            for (int i = 0; count < len; i++) {
                int curIndex = i;//当前被交换的元素下标（先从第一个开始）
                int cur = nums[curIndex];//被交换的元素
                do {
                    //计算当前被交换的元素要换到那个下标去
                    int nextIndex = (curIndex + k)%len;
                    //开始交换
                    //先把要交换到的那个下标原来的元素保存起来，不然交换后就丢了
                    int tmp = nums[nextIndex];
                    //接着将cur放到这里来
                    nums[nextIndex] = cur;
                    //下一次被交换的cur就变成了tmp;
                    cur = tmp;
                    curIndex = nextIndex;
                    //计数器增加一次
                    count++;
                    //这里curIndex相当于一个快指针，i相当于一个慢指针，重合时候相当于有一个小组替换一轮了，该从这个小组长下一个元素位置替换了
                }while (curIndex != i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
