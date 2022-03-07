package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

import leetcode.model.TreeNode;

public class LowestCommonAncestor {

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (true) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                break;
        }

        return root;
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
        TreeNode p = TreeNode.insertByOrder(0, new Object[] { 2 });
        TreeNode q = TreeNode.insertByOrder(0, new Object[] { 8 });
        TreeNode expected = TreeNode.insertByOrder(0, new Object[] { 6 });
        TreeNode actual = lowestCommonAncestor(root, p, q);
        assertEquals(expected.val, actual.val);
    }

}