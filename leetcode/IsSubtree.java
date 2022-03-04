package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.TreeNode;

public class IsSubtree {

    // https://leetcode.com/problems/subtree-of-another-tree/

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (false)
            System.out.println("not solved, dit not submitted");

        if (equals(root, subRoot))
            return true;

        return equals(root.left, subRoot) || equals(root.right, subRoot);

    }

    public boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == node2) {
            return true;
        }
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val &&
                equals(node1.left, node2.left) &&
                equals(node1.right, node2.right);
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
