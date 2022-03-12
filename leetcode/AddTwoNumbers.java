package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.model.ListNode;

public class AddTwoNumbers {

    // https://leetcode.com/problems/add-two-numbers/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode temp = sum;
        int num = 0;

        while (l1 != null || l2 != null || num > 0) {
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }

            ListNode l = new ListNode(num % 10);
            temp.next = l;
            temp = temp.next;

            num /= 10;
        }

        return sum.next;
    }

    @Test
    public void test1() {
        ListNode l1 = ListNode.insertByOrder(new int[] { 2, 4, 3 });
        ListNode l2 = ListNode.insertByOrder(new int[] { 5, 6, 4 });
        ListNode expected = ListNode.insertByOrder(new int[] { 7, 0, 8 });
        ListNode actual = addTwoNumbers(l1, l2);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        ListNode l1 = ListNode.insertByOrder(new int[] { 9, 9, 9, 9, 9, 9, 9 });
        ListNode l2 = ListNode.insertByOrder(new int[] { 9, 9, 9, 9 });
        ListNode expected = ListNode.insertByOrder(new int[] { 8, 9, 9, 9, 0, 0, 0, 1 });
        ListNode actual = addTwoNumbers(l1, l2);
        assertEquals(expected, actual);
    }

}