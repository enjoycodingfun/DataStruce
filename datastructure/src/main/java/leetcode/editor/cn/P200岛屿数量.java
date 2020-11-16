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

import java.util.LinkedList;
import java.util.Queue;

//Java：岛屿数量
public class P200岛屿数量 {

    public static void main(String[] args) {
        Solution solution = new P200岛屿数量().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int numIslands(char[][] grid) {

            if (grid == null || grid.length == 0) {
                return 0;
            }
            return unfind(grid);
            /*int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1'){
                        *//**
                         * 方法一：深度优先搜索
                         * https://leetcode-cn.com/problems/number-of-islands/solution/number-of-islands-shen-du-you-xian-bian-li-dfs-or-/
                         *//*
                        //dfs(grid,i,j);
                        *//**
                         * 方法二：广度优先搜索
                         * https://leetcode-cn.com/problems/number-of-islands/solution/number-of-islands-shen-du-you-xian-bian-li-dfs-or-/
                         *//*
                        bfs(grid, i, j);
                        //删除已经遍历的
                        count++;
                    }
                }
            }
            return count;*/
        }

        /**
         * 并查集方式
         * @param grid
         * @return
         */
        private int unfind(char[][] grid) {
            UnionFind find = new UnionFind(grid);
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1'){
                        //二维矩阵m*n,z在一维数组的位置是：（第几行×矩阵宽度）+ 在第几列
                        //前面已经执行过，不用往回查
                        if (i+1 < m && grid[i+1][j] == '1'){
                            find.union(i*n+j,(i+1)*n+j);
                        }
                        if (j+1 <n && grid[i][j+1] == '1'){
                            find.union(i*n+j,i*n+(j+1));
                        }
                    }
                }
            }
            return find.count;
        }

        /**
         * 以下为并查集模板
         */
        class UnionFind {
            private int[] parent;

            private int count;

            public UnionFind(char[][] grid) {
                int m = grid.length;
                int n = grid[0].length;
                parent = new int[m*n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        //这里把二维转一维，使用i*n+j
                        if (grid[i][j] == '1') {
                            parent[i * n + j] = i * n + j;
                            count++;
                        }
                    }
                }
            }

            public int find(int p){
                while (p != parent[p]){
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            public void union(int p,int q){
                int pRoot = find(p);
                int qRoot = find(q);
                if (pRoot == qRoot){
                    return;
                }
                parent[pRoot] = q;
                count--;
            }

        }

        private void bfs(char[][] grid, int i, int j) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i,j});
            while (!queue.isEmpty()){
                int[] cur = queue.poll();
                int m = cur[0], n = cur[1];
                if (m>=0&&m<grid.length&&n>=0&&n<grid[0].length&&grid[m][n]=='1'){
                    grid[m][n] = '0';
                    bfs(grid,i+1,j);
                    bfs(grid,i,j+1);
                    bfs(grid,i-1,j);
                    bfs(grid,i,j-1);
                }
            }
        }

        /**
         * 从坐标为 (i, j) 的点开始进行深度优先遍历
         */
        private void dfs(char[][] grid, int i, int j) {
            if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
            //将遍历过的删除
            grid[i][j] = '0';
            dfs(grid,i+1,j);
            dfs(grid,i,j+1);
            dfs(grid,i-1,j);
            dfs(grid,i,j-1);
        }

    }
    // Java 并查集模板
    class UnionFind {
        private int count = 0;
        private int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
