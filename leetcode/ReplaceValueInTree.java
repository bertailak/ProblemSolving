package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import leetcode.model.TreeNode;

public class ReplaceValueInTree {

    private void recursive(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> order = new LinkedList<>();
        q.add(root);
        order.add(0);
        int preSum1 = 0;
        int preSum2 = 0;
        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < size; i++) {

                TreeNode top = q.poll();
                int ord = order.poll();
                if (top.left != null) {
                    q.add(top.left);
                    int o = 2 * ord;
                    order.add(o);
                    if (o < level) {
                        sum1 += top.left.val;
                    } else {
                        sum2 += top.left.val;
                    }
                }
                if (top.right != null) {
                    q.add(top.right);
                    int o = 2 * ord + 1;
                    order.add(o);
                    if (o < level) {
                        sum1 += top.right.val;
                    } else {
                        sum2 += top.right.val;
                    }
                }
                if (ord < level / 2)
                    top.val = preSum2;
                else
                    top.val = preSum1;
            }
            level *= 2;

            if (level <= 2)
                continue;

            preSum1 = sum1;
            preSum2 = sum2;
        }
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        recursive(root);
        return root;
    }

    @Test
    public void test1() {
        assertEquals(TreeNode.insertByOrder(0, new Object[] { 0, 0, 0 }),
                replaceValueInTree(TreeNode.insertByOrder(0, new Object[] { 3, 1, 2 })));
    }

    @Test
    public void test2() {
        assertEquals(TreeNode.insertByOrder(0, new Object[] { 0, 0, 0, 7, 7, null, 11 }),
                replaceValueInTree(TreeNode.insertByOrder(0, new Object[] { 5, 4, 9, 1, 10, null, 7 })));
    }

    @Test
    public void test3() {
        assertEquals(TreeNode.insertByOrder(0, new Object[] { 0, 0, 0, 7, 7, null, 11 }),
                replaceValueInTree(TreeNode.insertByOrder(0,
                        new Object[] { 49, 40, 35, 42, 7, null, null, 50, null, null, 44})));
    }
}
