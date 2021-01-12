//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 611 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

//Java：前 K 个高频元素
public class P347前 K 个高频元素{
    public static void main(String[] args) {
        Solution solution = new P347前 K 个高频元素().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 ){
            return new int[0];
        }
        //return method1(nums,k);
        return method2(nums,k);
    }

        /**
         * 使用treeMap
         * @param nums
         * @param k
         * @return
         */
        private int[] method2(int[] nums, int k) {
            Map<Integer,Integer> map = Arrays.stream(nums).boxed().collect(Collectors.toMap(e->e,e->1,Integer::sum));
            //此处换成treeMap
            // 定义二叉搜索树：key 是数字出现的次数，value 是出现了key次的数字列表。
            TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
            int count = 0;
            for (Integer key : map.keySet()) {
                Integer num = key;//当前的数字
                Integer numCount = map.get(num);//当前数字出现的次数
                if (count<k){
                    treeMap.computeIfAbsent(numCount, ArrayList::new).add(num);
                    count++;
                }else{
                    //treemap中容量超过k了，那就比较
                    Integer firstKey = treeMap.firstKey();
                    if (numCount > firstKey){
                        //当前数字出现的次数超过了treeMap中第一个entry中的数字出现的次数
                        treeMap.computeIfAbsent(numCount, ArrayList::new).add(num);
                        List<Integer> list = treeMap.get(firstKey);
                        if (list.size() == 1){
                            //如果这个entry中只有一个元素，直接移除整个entry
                            treeMap.pollFirstEntry();
                        }else {
                            //否则移除其最后一个元素
                            list.remove(list.size() - 1);
                        }
                    }
                }
            }
            //构建结果集
            int[] res = new int[k];
            int index = 0;
            for (List<Integer> list: treeMap.values()) {
                for (int num: list) {
                    res[index++] = num;
                }
            }
            return res;
        }

        /**
         * 使用优先队列
         * @param nums
         * @param k
         * @return
         */
        private int[] method1(int[] nums, int k) {
            Map<Integer,Integer> map = Arrays.stream(nums).boxed().collect(Collectors.toMap(e->e,e->1,Integer::sum));
            //使用优先队列,由于优先队列默认小根堆，所以要改成大根堆
            PriorityQueue<Integer> queue = new PriorityQueue<>((v1,v2)->map.get(v1)-map.get(v2));
            map.forEach((num,cnt)->{
                if (queue.size()<k){
                    queue.offer(num);
                    //注意队列中放到元素是数字不是数字的次数
                }else if (map.get(queue.peek())<cnt){
                    queue.poll();
                    queue.add(num);
                }
            });
            //构建结果集
            int[] res = new int[k];
            int index = 0;
            while (!queue.isEmpty()){
                res[index++]= queue.poll();
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
