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

        if (this.val != obj.val)
            return false;

        if (this.next == null && obj.next == null)
            return true;

        if ((this.next == null && obj.next != null) || (this.next != null && obj.next == null))
            return false;

        return this.next.equals(obj.next);
    }

    @Override
    public int hashCode() {
        return this.val;
    }
}
