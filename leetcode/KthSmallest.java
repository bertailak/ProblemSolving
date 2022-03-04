package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import leetcode.model.TreeNode;

public class KthSmallest {

    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/

    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        order(root);
        return list.get(k - 1);
    }

    public void order(TreeNode root) {
        if (root == null)
            return;
        order(root.left);
        list.add(root.val);
        order(root.right);
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 3, 1, 4, null, 2 });
        int k = 1;
        int expected = 1;
        int actual = kthSmallest(root, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 5, 3, 6, 2, 4, null, null, 1 });
        int k = 3;
        int expected = 3;
        int actual = kthSmallest(root, k);
        assertEquals(expected, actual);
    }

}
