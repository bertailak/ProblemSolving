package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.ListNode;

public class ReverseList {

    // https://leetcode.com/problems/reverse-linked-list/

    public ListNode reverseList(ListNode head) {
        ListNode list = null;
        while (head != null) {
            list = new ListNode(head.val, list);
            head = head.next;
        }
        return list;
    }

    @Test
    public void test1() {
        ListNode head = ListNode.insertByOrder(new int[] { 1, 2, 3, 4, 5 });
        ListNode expected = ListNode.insertByOrder(new int[] { 5, 4, 3, 2, 1 });
        ListNode actual = reverseList(head);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        ListNode head = ListNode.insertByOrder(new int[] { 1, 2 });
        ListNode expected = ListNode.insertByOrder(new int[] { 2, 1 });
        ListNode actual = reverseList(head);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        ListNode head = ListNode.insertByOrder(new int[] {});
        ListNode expected = ListNode.insertByOrder(new int[] {});
        ListNode actual = reverseList(head);
        assertEquals(expected, actual);
    }

}
