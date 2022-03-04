package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.TreeNode;

public class InvertTree {

    // https://leetcode.com/problems/invert-binary-tree/

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 2, 1, 3 });
        TreeNode expected = TreeNode.insertByOrder(0, new Object[] { 2, 3, 1 });
        TreeNode actual = invertTree(root);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] {});
        TreeNode expected = TreeNode.insertByOrder(0, new Object[] {});
        TreeNode actual = invertTree(root);
        assertEquals(expected, actual);
    }

}
