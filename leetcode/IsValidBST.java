package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import leetcode.model.TreeNode;

public class IsValidBST {

    // https://leetcode.com/problems/validate-binary-search-tree/

    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        order(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1))
                return false;
        }
        return true;
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
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 2, 1, 3 });
        boolean expected = true;
        boolean actual = isValidBST(root);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 5, 1, 4, null, null, 3, 6 });
        boolean expected = false;
        boolean actual = isValidBST(root);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 5, 4, 6, null, null, 3, 7 });
        boolean expected = false;
        boolean actual = isValidBST(root);
        assertEquals(expected, actual);
    }

}
