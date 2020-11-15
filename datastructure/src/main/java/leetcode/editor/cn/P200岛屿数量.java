//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 853 👎 0


package leetcode.editor.cn;

//Java：岛屿数量
public class P200岛屿数量 {

    public static void main(String[] args) {
        Solution solution = new P200岛屿数量().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        private boolean[][] visited;

        private int rows;

        private int cols;

        private char[][] grid;

        public int numIslands(char[][] grid) {
            rows = grid.length;
            if (rows == 0) {
                return 0;
            }
            cols = grid[0].length;

            this.grid = grid;
            visited = new boolean[rows][cols];
            int count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 如果是岛屿中的一个点，并且没有被访问过，就进行深度优先遍历
                    if (!visited[i][j] && grid[i][j] == '1') {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        /**
         * 从坐标为 (i, j) 的点开始进行深度优先遍历
         */
        private void dfs(int i, int j) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + DIRECTIONS[k][0];
                int newY = j + DIRECTIONS[k][1];
                // 如果不越界、还是陆地、没有被访问过
                if (inArea(newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }

        /**
         * 封装成 inArea 方法语义更清晰
         */
        private boolean inArea(int x, int y) {
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
