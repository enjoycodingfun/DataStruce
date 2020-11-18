//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 444 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

//Java：有效的数独
public class P36有效的数独 {

    public static void main(String[] args) {
        Solution solution = new P36有效的数独().new Solution();
        System.out.println(1<<4|0);//16
        System.out.println(16>>4&1);//1
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValidSudoku(char[][] board) {
            if (board == null || board.length == 0) {
                return false;
            }
            //return method1(board);
            return method2(board);

        }

        /**
         * 方案一：哈希表
         * https://leetcode-cn.com/problems/valid-sudoku/solution/javawei-yun-suan-1ms-100-li-jie-fang-ge-suo-yin-by/
         * 每个方格所在格子的计算方式为i/3*3+j/3,比如以第一个（0,0）属于第0个格子，最后一个（8,8）属于第8个格子
         */

        private boolean method1(char[][] board) {
            HashSet<Integer>[] rows = new HashSet[9];
            HashSet<Integer>[] cols = new HashSet[9];
            HashSet<Integer>[] boxs = new HashSet[9];
            //初始化下boxs
            for (int i = 0; i < 9; i++) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
                boxs[i] = new HashSet<>();
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.'){
                        continue;
                    }
                    int tmp = board[i][j] - '0';
                    if (rows[i].contains(tmp) || cols[j].contains(tmp) || boxs[i/3*3+j/3].contains(tmp)){
                        return false;
                    }
                    rows[i].add(tmp);
                    cols[j].add(tmp);
                    boxs[i/3*3+j/3].add(tmp);
                }
            }
            return true;
        }

        /**
         * 方法二：位运算
         * 原理，如果当前访问的board[i][j]没有访问过，通过如下运算1<<broad[i][j]|row[i]这样row[i]就保存了broad[i][j]第i位，下次判断的时候，只要
         * 将row[i]>>broad[i][j]&1，如果得到结果是1，说明这一行已经保存过broad[i][j]，列j及box[i/3*3+j/3]同理
         * 比如我们初始化时候用row[9]数组保存位运算结果的数字，假如当前访问到broad[2][3] = 4,那们我们要看下4参会与位运算的结果有没有保存在row[2]，
         * 假如还没有，那么row[2]一定是0，那么row[2]>>4&1=0;假如已经访问过了，那么当时访问的时候执行了1<<broad[i][j]|row[i]=1<<4|0=16并且将16保存在了
         * row[2]中，此时再执行row[2]>>4&1=1,所以可以通过这种方式来判断某个行有没有当前数字broad[i][j]，某个列同理
         * @param board
         * @return
         */
        private boolean method2(char[][] board) {
            int[] rows = new int[9];//初始化用来保存某个行有没有某个数字board[i][j]参与运算的结果
            int[] cols = new int[9];//初始化用来保存某个列有没有某个数字board[i][j]参与运算的结果
            int[] boxs = new int[9];//初始化用来保存某个格子中有没有某个数字board[i][j]参与运算的结果
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.'){
                        continue;
                    }
                    int tmp = board[i][j];
                    //判定某行或列或box有没有保存该数字结果
                    int boxIndex = i/3*3+j/3;
                    if ((rows[i]>>tmp & 1)==1||(cols[j]>>tmp &1)==1||(boxs[boxIndex]>>tmp &1)==1){
                        //说明已经保存过了
                        return false;
                    }
                    //否则的话保存进去
                    rows[i] = (1<<tmp)|rows[i];
                    cols[j] = (1<<tmp)|cols[j];
                    boxs[boxIndex] = (1<<tmp)|boxs[boxIndex];
                }
            }
            return true;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
