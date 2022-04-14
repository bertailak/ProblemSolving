package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.TreeNode;

public class SearchBST {

    // https://leetcode.com/problems/search-in-a-binary-search-tree/

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        if (root.val < val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 4, 2, 7, 1, 3 });
        int val = 2;
        TreeNode expected = TreeNode.insertByOrder(0, new Object[] { 2, 1, 3 });
        TreeNode actual = searchBST(root, val);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 4, 2, 7, 1, 3 });
        int val = 5;
        TreeNode expected = TreeNode.insertByOrder(0, new Object[] {});
        TreeNode actual = searchBST(root, val);
        assertEquals(expected, actual);
    }
}
