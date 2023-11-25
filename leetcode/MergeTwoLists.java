package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.ListNode;

public class MergeTwoLists {

    // https://leetcode.com/problems/merge-two-sorted-lists/

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    head.next = list1;
                    list1 = list1.next;
                } else {
                    head.next = list2;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                head.next = list1;
                list1 = list1.next;
            } else if (list2 != null) {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        return dummy.next;
    }

    @Test
    public void test1() {
        ListNode list1 = ListNode.insertByOrder(new int[] { 1, 2, 4 });
        ListNode list2 = ListNode.insertByOrder(new int[] { 1, 3, 4 });
        ListNode expected = ListNode.insertByOrder(new int[] { 1, 1, 2, 3, 4, 4 });
        ListNode actual = mergeTwoLists(list1, list2);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        ListNode list1 = ListNode.insertByOrder(new int[] {});
        ListNode list2 = ListNode.insertByOrder(new int[] {});
        ListNode expected = ListNode.insertByOrder(new int[] {});
        ListNode actual = mergeTwoLists(list1, list2);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        ListNode list1 = ListNode.insertByOrder(new int[] {});
        ListNode list2 = ListNode.insertByOrder(new int[] { 0 });
        ListNode expected = ListNode.insertByOrder(new int[] { 0 });
        ListNode actual = mergeTwoLists(list1, list2);
        assertEquals(expected, actual);
    }
}
