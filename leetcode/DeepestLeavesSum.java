package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import leetcode.model.TreeNode;

public class DeepestLeavesSum {

    // https://leetcode.com/problems/deepest-leaves-sum/

    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;

        while (!queue.isEmpty()) {
            int size = 0;
            sum = 0;
            while (count-- > 0) {
                TreeNode top = queue.poll();
                sum += top.val;
                if (top.left != null) {
                    queue.add(top.left);
                    size++;
                }
                if (top.right != null) {
                    queue.add(top.right);
                    size++;
                }
            }

            count = size;
        }

        return sum;
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.insertByOrder(0,
                new Object[] { 1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, null, null, 8 });
        int expected = 15;
        int actual = deepestLeavesSum(root);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.insertByOrder(0,
                new Object[] { 6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5 });
        int expected = 19;
        int actual = deepestLeavesSum(root);
        assertEquals(expected, actual);
    }
}
