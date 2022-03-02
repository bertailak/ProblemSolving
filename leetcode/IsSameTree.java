package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.TreeNode;

public class IsSameTree {

    // https://leetcode.com/problems/same-tree/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Test
    public void test1() {
        TreeNode p = TreeNode.insertByOrder(0, new Object[] { 1, 2, 3 });
        TreeNode q = TreeNode.insertByOrder(0, new Object[] { 1, 2, 3 });
        boolean expected = true;
        boolean actual = isSameTree(p, q);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode p = TreeNode.insertByOrder(0, new Object[] { 1, 2 });
        TreeNode q = TreeNode.insertByOrder(0, new Object[] { 1, null, 2 });
        boolean expected = false;
        boolean actual = isSameTree(p, q);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        TreeNode p = TreeNode.insertByOrder(0, new Object[] { 1, 2, 1 });
        TreeNode q = TreeNode.insertByOrder(0, new Object[] { 1, 1, 2 });
        boolean expected = false;
        boolean actual = isSameTree(p, q);
        assertEquals(expected, actual);
    }
}
