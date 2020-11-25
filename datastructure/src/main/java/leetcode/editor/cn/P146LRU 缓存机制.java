//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1003 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：LRU 缓存机制
public class P146LRU 缓存机制{
    public static void main(String[] args) {
        Solution solution = new P146LRU 缓存机制().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

        class ListNode{
            private int key;
            private int value;
            private ListNode pre;
            private ListNode next;

            public ListNode() {
            }

            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, ListNode> cache = new HashMap<>();
        private int capacity;
        private ListNode head, tail;

        public LRUCache(int capacity) {
            cache = new HashMap<>(capacity);
            this.capacity = capacity;
            //初始化虚拟头结点和尾结点
            head = new ListNode(-1,-1);
            tail = new ListNode(-1,-1);
            //互相指定
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (cache.containsKey(key)){
                ListNode listNode = cache.get(key);
                int value = listNode.value;
                //将该节点移动到头部
                this.moveToFirst(key);
                return value;
            }else{
                return -1;
            }
        }

        private void moveToFirst(int key) {
            //先保存key对应节点
            ListNode listNode = cache.get(key);
            //把它前后的节点手牵手
            listNode.pre.next = listNode.next;
            listNode.next.pre = listNode.pre;
            //把当前节点放到虚拟节点头部之后
            addNodeBehindHead(listNode);
        }

        private void addNodeBehindHead(ListNode listNode) {
            //先保存当前真实头结点
            ListNode oldfirst = head.next;
            //将虚拟头结点和当前节点手牵手
            head.next = listNode;
            listNode.pre = head;
            //当前节点和老的头结点手牵手
            listNode.next = oldfirst;
            oldfirst.pre = listNode;
        }

        /**
         * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
         * 限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            //先判断key如果存在直接替换值并把当前节点放到双向链表头部
            if (cache.containsKey(key)){
                ListNode listNode = cache.get(key);
                listNode.value = value;
                //
                this.moveToFirst(key);
                return;
            }
            //如果放入之前先判断容量大小
            if (cache.size() == capacity){
                //删除最久未使用的也就是尾结点
                ListNode oldTail = this.removeLastNode();
                //别忘了删除cache中的key
                cache.remove(oldTail.key);
            }
            //如果容量够则加到头结点上
            ListNode node = new ListNode(key,value);
            cache.put(key,node);
            addNodeBehindHead(node);
        }

        /**
         * 删除双向链表尾部节点
         * @return
         */
        private ListNode removeLastNode() {
            //找到真实的尾结点
            ListNode oldTail = tail.pre;
            oldTail.pre.next = tail;
            tail.pre = oldTail.pre;
            //释放引用？
            oldTail.pre = null;
            oldTail.next = null;
            return oldTail;
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
