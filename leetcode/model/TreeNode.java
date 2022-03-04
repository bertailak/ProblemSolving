package leetcode.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode getMin() {
        if (this.left != null) {
            return getMin(this.left);
        }
        return this;
    }

    TreeNode getMin(TreeNode node) {
        if (node.left != null) {
            return getMin(node.left);
        }
        return node;
    }

    public void printTree() {
        Queue<TreeNode> s = new LinkedList<>();
        HashMap<Integer, TreeNode> m = new HashMap<>();

        int ind = 0;
        s.add(this);
        m.put(ind++, this);

        while (!s.isEmpty()) {
            TreeNode node = s.poll();
            if (node == null) {
                ind += 2;
            } else {
                s.add(node.left);
                s.add(node.right);
                m.put(ind++, node.left);
                m.put(ind++, node.right);
            }
        }
        Object[] obj = new Object[ind];
        for (Map.Entry<Integer, TreeNode> entry : m.entrySet()) {
            int key = (int) entry.getKey();
            TreeNode value = entry.getValue();
            if (value != null) {
                obj[key] = value.val;
            }
        }
        int j = obj.length - 1;
        while (j > 0) {
            if (obj[j] == null) {
                j--;
            } else {
                break;
            }
        }

        for (int i = 0; i <= j; i++) {
            System.out.print(obj[i] + ", ");
        }
        System.out.println();
    }

    public static TreeNode insertRecursive(TreeNode root, Object key) {
        if (root == null) {
            root = new TreeNode((int) key);
            return root;
        }
        if ((int) key < root.val) {
            root.left = insertRecursive(root.left, key);
        } else if ((int) key > (int) root.val) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }

    public static TreeNode insertByOrder(int index, Object[] keys) {
        if (index < keys.length && keys[index] != null) {
            TreeNode root = new TreeNode((int) keys[index]);
            root.left = insertByOrder(index * 2 + 1, keys);
            root.right = insertByOrder(index * 2 + 2, keys);
            return root;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode obj = (TreeNode) o;

        return equals(this, obj);
    }

    public boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == node2) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val &&
                equals(node1.left, node2.left) &&
                equals(node1.right, node2.right);
    }

    @Override
    public int hashCode() {
        return this.val;
    }

}
