//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 163 👎 0


package leetcode.editor.cn;

//Java：顺时针打印矩阵
public class P剑指 Offer 29顺时针打印矩阵{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 29顺时针打印矩阵().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        return method1(matrix);

    }

    /**
     * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
     * @param matrix
     * @return
     */
    private int[] method1(int[][] matrix) {
        int l = 0,r = matrix[0].length-1,t = 0,b=matrix.length-1;
        int[] res = new int[(r+1)*(b+1)];
        int index = 0;
        while (true){
            //从左到右打印，发现超出边界的时候break
            for (int i = l; i <= r; i++) {
                res[index++] = matrix[t][i];
            }
            //接下来从上往下打印，t要先加一往下走一格
            if (++t>b){break;}
            for (int i = t; i <= b; i++) {
                res[index++] = matrix[i][r];
            }
            //接下来从右往左打印，r要先减一往左走一格
            if (--r < l){
                break;
            }
            for (int i = r; i >= l ; i--) {
                res[index++] = matrix[b][i];
            }
            //接下来从下往上打印，b要先减一往上走一格
            if (--b < t){
                break;
            }
            for (int i = b; i >= t ; i--) {
                //搞清楚是行在变还是列在变
                res[index++] = matrix[i][l];
            }
            //接下来继续从左往右打印，先判断边界
            if (++l > r){
                break;
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
