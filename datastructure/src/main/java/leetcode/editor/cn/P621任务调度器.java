//给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务
//都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。 
//
// 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的最短时间。 
//
// 
//
// 示例 ： 
//
// 输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 
//
// 提示： 
//
// 
// 任务的总个数为 [1, 10000]。 
// n 的取值范围为 [0, 100]。 
// 
// Related Topics 贪心算法 队列 数组 
// 👍 420 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：任务调度器
public class P621任务调度器 {

    public static void main(String[] args) {
        Solution solution = new P621任务调度器().new Solution();
        char[] tasks = {'A','A','A'};
        int n = 1;
        System.out.println(solution.method1(tasks,n));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int leastInterval(char[] tasks, int n) {
            if (tasks.length <= 1 || n < 1) {
                return tasks.length;
            }
            /**
             * 方法一：参考题解
             * https://leetcode-cn.com/problems/task-scheduler/solution/621-ren-wu-diao-du-qi-java-jie-ti-zhu-shi-ying-gai/
             */
            return method1(tasks,n);


        }

        private int method1(char[] tasks, int n) {
            int[] count = new int[26];//用这个数组记录每个字母出现的次数
            //计数
            for (int i = 0; i < tasks.length; i++) {
                count[tasks[i]-'A']++;
            }
            //排序后先拍任务数最多的
            Arrays.sort(count);
            int maxCount = count[25];
            int maxTime = (maxCount-1)*(n+1)+1;//假如maxCount=5，n=2 那么中间有四个空隙，前四组（任务加间隙）时间是(maxCount-1)*(n+1)，再加上最后一个任务时间
            //遍历count看看有没有和maxcount出现次数一样的任务，如果有需要再加上这个任务排在末尾的一次等待时间
            for (int i = 24; i >=0 ; i--) {
                if (count[i] == maxCount){
                    maxTime++;
                }
            }
            /**
             * 如果按照最长的排完之后，后面还有剩下的没有排的，比如字符串序列式AAABBBCCCD，
             * 然后n=2的话，那拍好就是ABCABCABCD，按照公式计算出来的结果是(3-1)*(3)+1+2=9，
             * 但是实际的序列应该是ABCABCABCD，应该是10，所以通过求max来补充掉这个正好全排列但是还有多出去的情况
             */
            return Math.max(maxTime, tasks.length);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
