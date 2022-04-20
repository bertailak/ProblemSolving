package leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.model.TreeNode;

public class BSTIterator {

    // https://leetcode.com/problems/binary-search-tree-iterator/submissions/

    Queue<Integer> q;

    public BSTIterator(TreeNode root) {
        q = new LinkedList<>();
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        q.add(root.val);
        inOrder(root.right);
    }

    public int next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}
