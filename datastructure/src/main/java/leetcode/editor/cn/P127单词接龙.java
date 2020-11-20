//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 643 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//Java：单词接龙
public class P127单词接龙 {

    public static void main(String[] args) {
        Solution solution = new P127单词接龙().new Solution();
        char[] chars = new char[]{'a', 'b', 'c'};
        System.out.println();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList.size() == 0 || !wordList.contains(endWord)) {
                return 0;
            }
            //return method1(beginWord, endWord, wordList);
            return method2(beginWord, endWord, wordList);

        }

        /**
         * 方法一：普通的广度优先遍历
         * https://leetcode-cn.com/problems/word-ladder/solution/yan-du-you-xian-bian-li-shuang-xiang-yan-du-you-2/
         */

        private int method1(String beginWord, String endWord, List<String> wordList) {
            /**
             * 先将wordList放入哈希表便于后面判断单词是否在单词字典中
             */
            HashSet<String> wordSet = new HashSet<>(wordList);
            wordSet.remove(beginWord);

            // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            //广度优先搜索wordList时访问过的字符串放到这个集合中
            HashSet<String> visited = new HashSet<>();
            visited.add(beginWord);

            // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
            int step = 1;
            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                for (int i = 0; i < queueSize; i++) {
                    //出队列
                    String curStr = queue.poll();
                    //对比该元素是否能够改变一个字符与endWord相同
                    if (verifyCurStr(curStr, endWord, queue, visited, wordSet)) {
                        return step + 1;
                    }
                }
                step++;
            }
            //全部遍历完还没有，就返回0
            return 0;
        }

        //尝试对 currentWord 修改每一个字符，看看是不是能与 endWord 匹配
        private boolean verifyCurStr(String curStr, String endWord, Queue<String> queue, HashSet<String> visited,
                HashSet<String> wordSet) {
            //为了改变curStr每个字符，先转换成字符数组
            char[] chars = curStr.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                //先把当前的字符保存起来，然后改变它，之后还需要恢复
                char curChar = chars[i];
                //改变这个字母
                for (char j = 'a'; j <= 'z'; j++) {
                    //令该字符串当前字符chars[i]=遍历到的字符
                    if (j == curChar) {
                        continue;
                    }
                    chars[i] = j;
                    //生成新字符串
                    //String newStr = chars.toString();(哭了，这两个api完全不同)[C@2a18f23c
                    String newStr = String.valueOf(chars);//abc
                    //比较是否相同,但是前提是当前变化出来的字符串在数据字典中
                    if (wordSet.contains(newStr)) {
                        if (endWord.equals(newStr)) {
                            return true;
                        }
                        //否则将它加入队列，同时立即标记为已访问过(如果没有标记过的话)，已经访问过就跳过，不再加入队列
                        if (!visited.contains(newStr)) {
                            queue.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                }
                //遍历下一个字母了，别忘了将当前字母恢复
                chars[i] = curChar;
            }
            return false;
        }

        /**
         * 方法二：双向广度优先搜索
         */
        private int method2(String beginWord, String endWord, List<String> wordList) {
            // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
            Set<String> wordSet = new HashSet<>(wordList);
            // 第 2 步：已经访问过的 word 添加到 visited 哈希表里
            HashSet<String> visited = new HashSet<>();
            // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
            HashSet<String> beginVisited = new HashSet<>();
            beginVisited.add(beginWord);
            HashSet<String> endVisited = new HashSet<>();
            endVisited.add(endWord);

            // 第 3 步：执行双向 BFS，左右交替扩散的步数之和为所求
            int step = 1;
            while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
                //优先选择小的hash表进行扩展，这样遍历数更少
                if (beginVisited.size() > endVisited.size()) {
                    HashSet<String> tmp = beginVisited;
                    beginVisited = endVisited;
                    endVisited = tmp;
                }
                // 逻辑到这里，保证 beginVisited 是相对较小的集合，nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
                HashSet<String> nextLevelVisited = new HashSet<>();
                for (String s : beginVisited) {
                    if (verifyCurStrDoubleBFS(s, endVisited, visited, wordSet, nextLevelVisited)) {
                        return step + 1;
                    }
                }
                // 原来的 beginVisited 废弃，从 nextLevelVisited 开始新的双向 BFS
                beginVisited = nextLevelVisited;
                step++;
            }
            return 0;
        }

        /**
         * 尝试对 word 修改每一个字符，看看是不是能落在 endVisited 中，扩展得到的新的 word 添加到 nextLevelVisited 里
         */

        private boolean verifyCurStrDoubleBFS(String s, HashSet<String> endVisited, HashSet<String> visited,
                Set<String> wordSet, HashSet<String> nextLevelVisited) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char curChar = chars[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (chars[i] == j){
                        continue;
                    }
                    chars[i] = j;
                    String newStr = String.valueOf(chars);
                    if (wordSet.contains(newStr)){
                        if (endVisited.contains(newStr)){
                            //如果已经在endVisited中，说明已经访问过，两者相遇了
                            return true;
                        }
                        if (!visited.contains(newStr)){
                            nextLevelVisited.add(newStr);
                            visited.add(newStr);
                        }
                    }
                    //恢复被改变的char[i]
                    chars[i] = curChar;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
