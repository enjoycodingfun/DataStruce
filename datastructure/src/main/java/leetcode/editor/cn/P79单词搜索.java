//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 731 👎 0


package leetcode.editor.cn;

//Java：单词搜索
public class P79单词搜索 {

    public static void main(String[] args) {
        Solution solution = new P79单词搜索().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 典型的回溯加剪枝问题
         * @param board
         * @param word
         * @return
         */
        public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    //先找到首字母再开始搜索
                    if (board[i][j] == word.charAt(0)&&backtrack(board,word,visited,i,j,0)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int len) {
            if (len == word.length()){
                //长度已经够了，就返回true
                return true;
            }
            //判断下下标,及是否已访问，字母是否相同
            if (i>=board.length||i<0||j>=board[0].length||j<0||visited[i][j]||word.charAt(len) != board[i][j]){
                return false;
            }
            //否则开始递归,上下左右位置
            visited[i][j] = true;
            if (backtrack(board,word,visited,i-1,j,len+1)||backtrack(board,word,visited,i+1,j,len+1)
            ||backtrack(board,word,visited,i,j+1,len+1)||backtrack(board,word,visited,i,j-1,len+1)){
                return true;
            }
            //回溯
            visited[i][j] = false;
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
