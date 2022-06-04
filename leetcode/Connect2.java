package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.model.Node;

public class Connect2 {

    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

    public Node connect(Node root) {
        
        Queue<Node> stack = new LinkedList<>();
        stack.add(root);
        int count = 1;

        while (!stack.isEmpty()) {
            int childs = 0;
            Node prev = null;

            while (count-- > 0) {

                Node top = stack.poll();
                if (top == null)
                    continue;
                if (prev != null)
                    prev.next = top;

                if (top.left != null) {
                    stack.add(top.left);
                    childs++;
                }
                if (top.right != null) {
                    stack.add(top.right);
                    childs++;
                }

                prev = top;
            }
            count = childs;
        }

        return root;
    }
}