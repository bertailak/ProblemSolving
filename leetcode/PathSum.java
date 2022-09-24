package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import leetcode.model.TreeNode;

public class PathSum {

    // https://leetcode.com/problems/path-sum-ii/

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if (root != null) {
            List<Integer> list = new ArrayList<>();
            dfs(list, root, targetSum);
        }
        return result;
    }

    public void dfs(List<Integer> list, TreeNode root, int targetSum) {
        if (root.left == null && root.right == null && targetSum == root.val) {
            list.add(root.val);
            result.add(List.copyOf(list));
            list.remove(list.size() - 1);
        }
        if (root.left != null) {
            list.add(root.val);
            dfs(list, root.left, targetSum - root.val);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.val);
            dfs(list, root.right, targetSum - root.val);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.insertByOrder(0, new Object[] { 1, 2, 3 });
        assertEquals(List.of(List.of(1, 2)), pathSum(root, 3));
    }

}
