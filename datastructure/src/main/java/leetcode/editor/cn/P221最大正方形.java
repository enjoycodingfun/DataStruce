//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例： 
//
// 
//输入：
//matrix = [["1","0","1","0","0"],
//          ["1","0","1","1","1"],
//          ["1","1","1","1","1"],
//          ["1","0","0","1","0"]]
//
//输出：4 
// Related Topics 动态规划 
// 👍 612 👎 0


package leetcode.editor.cn;

//Java：最大正方形
public class P221最大正方形 {

    public static void main(String[] args) {
        Solution solution = new P221最大正方形().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximalSquare(char[][] matrix) {
            /**
             * 动态规划，参考https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
             */
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return 0;
            }
            return method1(matrix);


        }

        private int method1(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            /**
             * dp 具体定义：dp[i + 1][j + 1] 表示 「以第 i 行、第 j 列为右下角的正方形的最大边长」
             * 为何不是 dp[i][j]
             * 回到图解中，任何一个正方形，我们都「依赖」当前格 左、上、左上三个方格的情况
             * 但第一行的上层已经没有格子，第一列左边已经没有格子，需要做特殊 if 判断来处理
             * 为了代码简洁，我们 假设补充 了多一行全 '0'、多一列全 '0'
             */
            int[][] dp = new int[m+1][n+1];
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                     if (matrix[i][j] == '1'){
                         dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j])+1;
                         max = Math.max(max,dp[i+1][j+1]);
                     }
                }
            }
            return max*max;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
