package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;
import leetcode.model.TreeNode;

public class ReverseOddLevels {

    // https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/

    public TreeNode reverseOddLevels(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode next = q.poll();
                list.add(next.val);
                if (next.left != null) {
                    q.add(next.left);
                    q.add(next.right);
                }
            }
        }

        int level = -1;
        int index = 0;
        int pow = 1;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            if (level > 0) {
                pow *= 2;
            }
            index += pow;

            for (int i = 0; i < size; i++) {
                TreeNode next = q.poll();
                if (next.left != null) {
                    q.add(next.left);
                    q.add(next.right);
                }

                if (level % 2 == 1) {
                    next.val = list.get(index - i - 1);
                }
            }
        }

        return root;
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 1, 2, 3 });
        TreeNode expected = TreeNode.insertByOrder(0, new Object[] { 1, 3, 2 });
        assertEquals(expected, reverseOddLevels(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 1, 2, 3, 1, 1, 1, 1 });
        TreeNode expected = TreeNode.insertByOrder(0, new Object[] { 1, 3, 2, 1, 1, 1, 1 });
        assertEquals(expected, reverseOddLevels(root));
    }
}
