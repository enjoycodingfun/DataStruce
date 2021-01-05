//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1061 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

//Java：全排列
public class P46全排列{
    public static void main(String[] args) {
        Solution solution = new P46全排列().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *试试回溯加剪枝
     */
    class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();//用来存放已经遍历过的元素.也可以用boolean数组来表示，访问过的boolean[i] = true;
        return dfs(nums,len,deque,res,set);


    }

        private List<List<Integer>> dfs(int[] nums, int len, Deque<Integer> deque,
                ArrayList<List<Integer>> res, HashSet<Integer> set) {
            if (deque.size() == len){
                res.add(new ArrayList<>(deque));
                return res;
            }
            for (int i = 0; i < len; i++) {
                if (set.contains(nums[i])){
                    continue;
                }
                deque.addLast(nums[i]);
                set.add(nums[i]);
                dfs(nums,len,deque,res, set);
                set.remove(nums[i]);
                deque.removeLast();
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
