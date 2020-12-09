//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "A
//BCCED"
//输出：true
// 
//
// 示例 2： 
//
// 输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 207 👎 0


package leetcode.editor.cn;

//Java：矩阵中的路径
public class P剑指 Offer 12矩阵中的路径{
public static void main(String[]args){
        Solution solution=new P剑指 Offer 12矩阵中的路径().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 复杂度分析：
     * M, NM,N 分别为矩阵行列大小， KK 为字符串 word 长度。
     *
     * 时间复杂度 O(3^KMN)O(3K
     *  MN) ： 最差情况下，需要遍历矩阵中长度为 KK 字符串的所有方案，时间复杂度为 O(3^K)O(3
     * K
     *  )；矩阵中共有 MNMN 个起点，时间复杂度为 O(MN)O(MN) 。
     * 方案数计算： 设字符串长度为 KK ，搜索中每个字符有上、下、左、右四个方向可以选择，舍弃回头（上个字符）的方向，剩下 33 种选择，因此方案数的复杂度为 O(3^K)O(3
     * K
     *  ) 。
     * 空间复杂度 O(K)O(K) ： 搜索过程中的递归深度不超过 KK ，因此系统因函数调用累计使用的栈空间占用 O(K)O(K) （因为函数返回后，系统调用的栈空间会释放）。最坏情况下 K = MNK=MN ，递归深度为
     * MNMN ，此时系统栈使用 O(MN)O(MN) 的额外空间。
     */

    public boolean exist(char[][] board, String s) {
        if (board == null || board.length == 0 || s == null || s.length() == 0) {
            return false;
        }
        char[] word = s.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        //先判断边界
        if (i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!= word[index]) {
            return false;
        }
        if (index == word.length-1){
            return true;
        }
        //替换当前遍历的字符
        board[i][j] = '\0';
        //开始遍历
        boolean res = dfs(board,word,i+1,j,index+1)||dfs(board,word,i-1,j,index+1)||
                dfs(board,word,i,j-1,index+1)||dfs(board,word,i,j+1,index+1);
        board[i][j]=word[index];
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
