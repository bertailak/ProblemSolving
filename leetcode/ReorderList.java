package leetcode;

import leetcode.model.ListNode;

public class ReorderList {
    // https://leetcode.com/problems/reorder-list/description/

    public void reorderList(ListNode node) {
        ListNode mid = node;
        ListNode fast = node;

        while (fast != null || fast.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        ListNode inverted = invert(mid);

        while (node != null || inverted != null) {
            ListNode next = node.next;

            inverted.next = next;
            node.next = inverted;
            node = node.next;

            inverted = inverted.next;
        }
    }

    private ListNode invert(ListNode node) {
        ListNode curr = node;
        ListNode next = node.next;
        ListNode prev = null;

        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        return curr;
    }
}
