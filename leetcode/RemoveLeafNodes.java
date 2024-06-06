package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.TreeNode;

public class RemoveLeafNodes {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target)
            return null;

        return root;
    }

    @Test
    public void test1() {
        assertEquals(TreeNode.insertByOrder(0, new Object[] { 1, null, 3, null, null, null, 4 }),
                removeLeafNodes(TreeNode.insertByOrder(0, new Object[] { 1, 2, 3, 2, null, 2, 4 }), 2));
    }

    @Test
    public void test2() {
        assertEquals(TreeNode.insertByOrder(0, new Object[] { 1, 3, null, null, 2 }),
                removeLeafNodes(TreeNode.insertByOrder(0, new Object[] { 1, 3, 3, 3, 2 }), 3));
    }

    @Test
    public void test3() {
        assertEquals(TreeNode.insertByOrder(0, new Object[] { 1 }),
                removeLeafNodes(TreeNode.insertByOrder(0, new Object[] { 1, 2, null, 2, null, null, null, 2 }), 2));
    }
}
