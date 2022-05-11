package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.TreeNode;

public class AverageOfSubtree {

    // https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/

    public int averageOfSubtree(TreeNode root) {
        int[] result = GetAverageOfSubtree(root);
        return result[2];
    }

    public int[] GetAverageOfSubtree(TreeNode root) {
        if (root.left == null && root.right == null)
            return new int[] { root.val, 1, 1 };

        int[] result = new int[] { root.val, 1, 0 };
        if (root.left != null) {
            int[] child = GetAverageOfSubtree(root.left);
            result[0] += child[0];
            result[1] += child[1];
            result[2] += child[2];
        }
        if (root.right != null) {
            int[] child = GetAverageOfSubtree(root.right);
            result[0] += child[0];
            result[1] += child[1];
            result[2] += child[2];
        }

        int average = (int) Math.floor(result[0] / result[1]);
        if (average == root.val)
            result[2]++;

        return result;
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 4, 8, 5, 0, 1, null, 6 });
        int expected = 5;
        int actual = averageOfSubtree(root);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 1 });
        int expected = 1;
        int actual = averageOfSubtree(root);
        assertEquals(expected, actual);
    }

}
