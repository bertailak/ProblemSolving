package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.TreeNode;

public class MaxDepth {

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/

    public static int maxDepth(TreeNode root) {
        return maxDepthRecursion(root, 0);
    }

    public static int maxDepthRecursion(TreeNode root, int depth) {
        if (root == null)
            return depth;
        else
            return Math.max(maxDepthRecursion(root.left, depth + 1), maxDepthRecursion(root.right, depth + 1));
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 3, 9, 20, null, null, 15, 7 });
        System.out.println(maxDepth(root));
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 3, 9, 20, null, null, 15, 7 });
        int expected = 3;
        int actual = maxDepth(root);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 1, null, 2 });
        int expected = 2;
        int actual = maxDepth(root);
        assertEquals(expected, actual);
    }

}
