//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 745 👎 0


package leetcode.editor.cn;

//Java：旋转图像
public class P48旋转图像 {

    public static void main(String[] args) {
        Solution solution = new P48旋转图像().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 找规律交换
     * https://leetcode-cn.com/problems/rotate-image/solution/yi-ci-xing-jiao-huan-by-powcai/
     * 即:任意一个(i,j) , (j, n-i-1), (n-i-1, n-j-1), (n -j-1, i)就是这四个索引号上的数交换.这种规律不方便找，
     * 所以本题采用第二种解法，先上下翻转，再对角翻转
     */
    class Solution {

        public void rotate(int[][] matrix) {
            //第一轮上下交换matrix[i]换到matrix[n-1-i]，比如n=4，第一行i=0换到i=3第四行，第二行i=1换到i=2第三行，注意i<n/2
            int n = matrix.length;
            for (int i = 0; i < n / 2; i++) {
                int[] tmp = matrix[i];
                matrix[i] = matrix[n-1-i];
                matrix[n-1-i] = tmp;
            }
            //第二轮对角线翻转（以左下角为基准）
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
