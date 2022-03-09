package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.ListNode;

public class DeleteDuplicates {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode fast = head;
        ListNode slow = dummy;
        slow.next = fast;

        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummy.next;
    }

    @Test
    public void test1() {
        ListNode head = ListNode.insertByOrder(new int[] { 1, 2, 3, 3, 4, 4, 5 });
        ListNode expected = ListNode.insertByOrder(new int[] { 1, 2, 5 });
        ListNode actual = deleteDuplicates(head);
        assertEquals(expected, actual);
    }
}
