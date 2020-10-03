package leetcode.editor.cn.common;

/**
 * TODO
 *
 * @author running
 * @version v1.1
 * @since 2020/10/3 23:47
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

}
