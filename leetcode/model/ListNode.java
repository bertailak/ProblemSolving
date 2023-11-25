package leetcode.model;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode insertByOrder(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        ListNode node = new ListNode(nums[nums.length - 1]);

        for (int i = nums.length - 2; i >= 0; i--) {
            node = new ListNode(nums[i], node);
        }

        return node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode obj = (ListNode) o;

        return equals(this, obj);
    }

    public boolean equals(ListNode node1, ListNode node2) {
        if (node1 == node2) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val &&
                equals(node1.next, node2.next);
    }

    @Override
    public int hashCode() {
        return this.val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode copy = this;
        while (copy != null) {
            sb.append(copy.val + ", ");
            copy = copy.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
