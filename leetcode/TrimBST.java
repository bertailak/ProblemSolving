package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.TreeNode;

public class TrimBST {

    // https://leetcode.com/problems/trim-a-binary-search-tree/

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        return root;
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 1, 0, 2 });
        int low = 1;
        int high = 2;
        TreeNode expected = TreeNode.insertByOrder(0, new Object[] { 1, null, 2 });
        TreeNode actual = trimBST(root, low, high);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 3, 0, 4, null, 2, null, null, null, null, 1 });
        int low = 1;
        int high = 3;
        TreeNode expected = TreeNode.insertByOrder(0, new Object[] { 3, 2, null, 1 });
        TreeNode actual = trimBST(root, low, high);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 3, 1, 4, null, 2 });
        int low = 3;
        int high = 4;
        TreeNode expected = TreeNode.insertByOrder(0, new Object[] { 3, null, 4 });
        TreeNode actual = trimBST(root, low, high);
        assertEquals(expected, actual);
    }

}
