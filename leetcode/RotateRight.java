package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import leetcode.model.ListNode;

public class RotateRight {

    // https://leetcode.com/problems/rotate-list/

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        ListNode clone = head;
        HashMap<Integer, ListNode> map = new HashMap<>();

        int index = 0;
        while (clone != null) {
            map.put(index++, clone);
            clone = clone.next;
        }
        k = k % index;
        if (k == 0)
            return head;

        ListNode end = map.get(index - k - 1);
        end.next = null;
        map.get(index - 1).next = map.get(0);

        return map.get(index - k);
    }

    @Test
    public void test1() {
        ListNode head = ListNode.insertByOrder(new int[] { 1, 2, 3, 4, 5 });
        int k = 2;
        ListNode expected = ListNode.insertByOrder(new int[] { 4, 5, 1, 2, 3 });
        ListNode actual = rotateRight(head, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        ListNode head = ListNode.insertByOrder(new int[] {});
        int k = 0;
        ListNode expected = ListNode.insertByOrder(new int[] {});
        ListNode actual = rotateRight(head, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        ListNode head = ListNode.insertByOrder(new int[] {});
        int k = 1;
        ListNode expected = ListNode.insertByOrder(new int[] {});
        ListNode actual = rotateRight(head, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        ListNode head = ListNode.insertByOrder(new int[] { 1 });
        int k = 1;
        ListNode expected = ListNode.insertByOrder(new int[] { 1 });
        ListNode actual = rotateRight(head, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        ListNode head = ListNode.insertByOrder(new int[] { 1, 2 });
        int k = 2;
        ListNode expected = ListNode.insertByOrder(new int[] { 1, 2 });
        ListNode actual = rotateRight(head, k);
        assertEquals(expected, actual);
    }
}
