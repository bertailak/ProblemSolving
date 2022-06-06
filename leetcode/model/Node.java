package leetcode.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node insertByOrder(int index, Object[] keys) {
        if (index < keys.length && keys[index] != null) {
            Node root = new Node((int) keys[index]);
            root.left = insertByOrder(index * 2 + 1, keys);
            root.right = insertByOrder(index * 2 + 2, keys);
            return root;
        }
        return null;
    }
}
