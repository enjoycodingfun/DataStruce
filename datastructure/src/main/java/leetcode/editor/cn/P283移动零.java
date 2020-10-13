//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 767 👎 0


package leetcode.editor.cn;

//Java：移动零
public class P283移动零 {

    public static void main(String[] args) {
        Solution solution = new P283移动零().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 首先想到双指针的方案
     */
    class Solution {

        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length < 2) {
                return;
            }
            /*int start = 0;
            int end = start+1;
            while (end < nums.length){
                if (nums[start] == 0 && nums[end] == 0){
                    //如果前指针为0，后指针也为零，那就移动后指针，直到找到一个后指针不是0的，进入第二种情况
                    end++;
                }else if (nums[start] == 0 && nums[end]!=0){
                    //第二种情况，交换两个指针的值之后，两者向下一步迈进
                    *//*int tmp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = tmp;*//*
                    nums[start] = nums[start]^nums[end];
                    nums[end] = nums[start]^nums[end];
                    nums[start]= nums[start]^nums[end];
                    start++;
                    end++;
                }*//*else if (nums[start] != 0 && nums[end]!=0){
                    //当前指针不是0，不管后面的是不是零，两个指针都往后移动，所以下面的两种可以合并成一种
                    start++;
                    end++;
                }else if (nums[start]!=0 && nums[end]==0){
                    start++;
                    end++;
                }*//*
                else{
                    start++;
                    end++;
                }
            }*/
            /**
             * 参考题解https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
             * 下面的评论
             */
            int start = 0;//指定当前数字
            for (int i = 0; i < nums.length; i++) {
                //遍历数组元素，如果不是num[i]非0,且i>j，将nums[i]的数字放在nums[j]处，同时将nums[i]处置为0
                //这种情况下我一开始认为假如nums[j]处不是0，这样替换不就出错了？但其实画一个过程就知道，假如i,j相等不会交换，
                //假如i>j，且nums[i]非零，这个时候j指向的一定是上一步交换后的0，因为交换之后把nums[i]置为0了
                if (nums[i] != 0) {
                    if (i > start) {
                        nums[start] = nums[i];
                        nums[i] = 0;
                    }
                    //发生交换才往下，不然不往下走
                    start++;
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
