package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.ListNode;

public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = list1;
        ListNode start = list1.next;
        int index = 1;

        while (index++ < a) {
            prev = prev.next;
            start = start.next;
        }
        ListNode end = start.next;
        while (index++ <= b) {
            end = end.next;
        }
        prev.next = list2;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = end;

        return list1;
    }

    @Test
    public void test1() {
        assertEquals(ListNode.insertByOrder(new int[] { 10, 1, 13, 1000000, 1000001, 1000002, 5 }),
                mergeInBetween(ListNode.insertByOrder(new int[] { 10, 1, 13, 6, 9, 5 }), 3, 4,
                        ListNode.insertByOrder(new int[] { 1000000, 1000001, 1000002 })));
    }
}
