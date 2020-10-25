//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 851 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：子集
public class P78子集 {

    public static void main(String[] args) {
        Solution solution = new P78子集().new Solution();
        // TO TEST
    }

    /**
     * https://leetcode-cn.com/problems/subsets/solution/hui-su-wei-yun-suan-di-gui-deng-gong-4chong-fang-s/
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            /**
             * 方法一，先创建一个空集合，之后每访问一个数字，就在原子集合中加入这个数字，创建新的子集，然后加入结果集
             */
            /*List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int num : nums) {
                //每访问一个数就遍历之前的子集，构建新的子集并加入这个数
                for (int i = 0; i < res.size(); i++) {
                    List<Integer> list = new ArrayList<>(res.get(i));
                    list.add(num);
                    res.add(list);
                }
            }
            return res;*/
            /**
             * 方法二：回溯,
             */
            //回溯算法模板
            /*private void backtrack("原始参数") {
                //终止条件(递归必须要有终止条件)
                if ("终止条件") {
                    //一些逻辑操作（可有可无，视情况而定）
                    return;
                }

                for (int i = "for循环开始的参数"; i < "for循环结束的参数"; i++) {
                    //一些逻辑操作（可有可无，视情况而定）

                    //做出选择

                    //递归
                    backtrack("新的参数");
                    //一些逻辑操作（可有可无，视情况而定）

                    //撤销选择
                }
            }*/
            List<List<Integer>> list = new ArrayList<>();
            this.backtrack(list,new ArrayList<>(),nums,0);
            return list;
        }

        private void backtrack(List<List<Integer>> list, ArrayList<Integer> templist, int[] nums, int start) {
            list.add(new ArrayList<>(templist));
            for (int j = start; j < nums.length; j++) {
                //做出选择
                templist.add(nums[j]);
                //回溯
                backtrack(list,templist,nums,j+1);
                //撤销选择
                templist.remove(templist.size()-1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
