package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import leetcode.model.ListNode;

public class RemoveNthFromEnd {

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }

        return removeNthFromEndRecursive(head, length - n);
    }

    public ListNode removeNthFromEndRecursive(ListNode head, int index) {
        if (index == 0) {
            return head.next;
        }
        head.next = removeNthFromEndRecursive(head.next, index - 1);

        return head;
    }

    @Test
    public void test1() {
        ListNode head = ListNode.insertByOrder(new int[] { 1, 2, 3, 4, 5 });
        int n = 2;
        ListNode expected = ListNode.insertByOrder(new int[] { 1, 2, 3, 5 });
        ListNode actual = removeNthFromEnd(head, n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        ListNode head = ListNode.insertByOrder(new int[] { 1 });
        int n = 1;
        ListNode expected = ListNode.insertByOrder(new int[] {});
        ListNode actual = removeNthFromEnd(head, n);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        ListNode head = ListNode.insertByOrder(new int[] { 1, 2 });
        int n = 1;
        ListNode expected = ListNode.insertByOrder(new int[] { 1 });
        ListNode actual = removeNthFromEnd(head, n);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        ListNode head = ListNode.insertByOrder(new int[] { 1, 2, 3 });
        int n = 1;
        ListNode expected = ListNode.insertByOrder(new int[] { 1, 2 });
        ListNode actual = removeNthFromEnd(head, n);
        assertEquals(expected, actual);
    }

}
