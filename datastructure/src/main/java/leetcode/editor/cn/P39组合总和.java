//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1107 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

//Java：组合总和
public class P39组合总和{
    public static void main(String[] args) {
        Solution solution = new P39组合总和().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 回溯加剪枝
     */
    class Solution {

        /**
         * https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
         * @param candidates
         * @param target
         * @return
         */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        int len = candidates.length;
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(candidates);
        /**
         * 排序剪枝（排序后如果target-当前元素已经小于0了，就没必要再遍历后面的元素了）
         */
        return dfs(candidates,0,len,deque,target,res);

    }

        private List<List<Integer>> dfs(int[] candidates, int begin, int len, Deque<Integer> deque, int target,
                ArrayList<List<Integer>> res) {
            //已经满足和为target就加入结果集
            if (target == 0){
                res.add(new ArrayList<>(deque));
            }
            for (int i = begin; i < len; i++) {
                /**
                 * 剪枝>>>>>>>(排序后如果target-当前元素已经小于0了，就没必要再遍历后面的元素了）
                 * 通过
                 */
                if (target-candidates[begin] < 0){
                    break;
                }
                deque.addLast(candidates[i]);
                //往下层搜索的时候起始元素还是i，因为可以重复使用
                dfs(candidates,i,len,deque,target-candidates[i],res);
                //之后回溯，进行下一次搜索
                deque.removeLast();

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
