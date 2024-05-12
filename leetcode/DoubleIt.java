package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.ListNode;

public class DoubleIt {

    public ListNode doubleIt(ListNode head) {
        ListNode l = doubleIt2(head);
        if (head.val > 9) {
            l.val -= 10;
            ListNode h = new ListNode(1);
            h.next = l;
            return h;
        }
        return l;
    }

    public ListNode doubleIt2(ListNode head) {
        if (head == null)
            return null;
        head.next = doubleIt2(head.next);
        head.val *= 2;
        if (head.next != null && head.next.val > 9) {
            head.next.val -= 10;
            head.val++;
        }
        return head;
    }

    @Test
    public void test1() {
        assertEquals(ListNode.insertByOrder(new int[] { 3, 7, 8 }),
                doubleIt(ListNode.insertByOrder(new int[] { 1, 8, 9 })));
    }

    @Test
    public void test2() {
        assertEquals(ListNode.insertByOrder(new int[] { 1, 9, 9, 8 }),
                doubleIt(ListNode.insertByOrder(new int[] { 9, 9, 9 })));
    }

    @Test
    public void test3() {
        assertEquals(ListNode.insertByOrder(new int[] { 2, 0 }),
                doubleIt(ListNode.insertByOrder(new int[] { 1, 0 })));
    }
}
