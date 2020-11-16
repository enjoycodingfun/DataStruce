//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 461 👎 0


package leetcode.editor.cn;

//Java：实现 Trie (前缀树)
public class P208实现 Trie(前缀树){
public static void main(String[]args){
        Solution solution=new P208实现 Trie(前缀树)().new Solution();
        // TO TEST
        }

//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private boolean hasString = false;
    private Trie[] next = new Trie[26];

    public Trie(){}

    public void insert(String word){//插入单词
        Trie root = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            //如果输入字符串当前位置的字符在trie树中没有，就创建一个新的节点
            if (root.next[w[i]-'a'] == null){
                root.next[w[i]-'a'] = new Trie();
            }
            //将root指向这个新节点开始创建下一节点
            root = root.next[w[i]-'a'];
        }
        root.hasString = true;
    }

    public boolean search(String word){//查找单词
        Trie root = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i]-'a'] == null){
                return false;
            }
            root = root.next[w[i]-'a'];
        }
        return root.hasString;
    }

    public boolean startsWith(String word){//查找前缀
        Trie root = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i]-'a'] == null){
                return false;
            }
            root = root.next[w[i]-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
