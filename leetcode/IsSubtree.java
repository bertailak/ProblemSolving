package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import leetcode.model.TreeNode;

public class IsSubtree {

    // https://leetcode.com/problems/subtree-of-another-tree/

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (false)
            System.out.println("not solved, did not submitted");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top.val == subRoot.val) {
                if (isIdentical(top, subRoot))
                    return true;
            }

            if (top.left != null)
                queue.add(top.left);
            if (top.right != null)
                queue.add(top.right);

        }

        return false;

    }

    public boolean isIdentical(TreeNode node1, TreeNode node2) {

        if (!(node1.left == null && node2.left == null)
                || ((node1.left == null)
                        || (node2.left == null)
                        || node1.left.val != node2.left.val
                        || (!isIdentical(node1.left, node2.left)))) {
            return false;
        }

        if ((node1.right != null && node2.right != null)
                && ((node1.right == null)
                        || (node1.right != null)
                        || node1.right.val != node2.right.val
                        || (!isIdentical(node1.right, node2.right)))) {
            return false;
        }

        return true;
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 3, 4, 5, 1, 2 });
        TreeNode subRoot = TreeNode.insertByOrder(0, new Object[] { 4, 1, 2 });
        boolean expected = true;
        boolean actual = isSubtree(root, subRoot);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 3, 4, 5, 1, 2, null, null, null, null, 0 });
        TreeNode subRoot = TreeNode.insertByOrder(0, new Object[] { 4, 1, 2 });
        boolean expected = false;
        boolean actual = isSubtree(root, subRoot);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        TreeNode root = TreeNode.insertByOrder(0,
                new Object[] { 1, null, 1, null, 1, null, 1,
                        null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2
                });
        TreeNode subRoot = TreeNode.insertByOrder(0,
                new Object[] { 1, null, 1, null, 1, null, 1, null, 1, null, 1, 2 });
        boolean expected = true;
        boolean actual = isSubtree(root, subRoot);
        assertEquals(expected, actual);
    }

}
