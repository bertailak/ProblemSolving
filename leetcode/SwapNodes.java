package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import leetcode.model.ListNode;

public class SwapNodes {

    // https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

    public ListNode swapNodes(ListNode head, int k) {
        HashMap<Integer, ListNode> map = new HashMap<>();

        ListNode dummy = new ListNode();
        dummy.next = head;

        int i = 0;
        while (dummy.next != null) {
            dummy = dummy.next;
            map.put(++i, dummy);
        }

        int temp = map.get(k).val;
        ListNode first = map.get(k);
        first.val = map.get(i - k + 1).val;

        ListNode second = map.get(i - k + 1);
        second.val = temp;

        return head;
    }

    @Test
    public void test1() {
        ListNode head = ListNode.insertByOrder(new int[] { 1, 2, 3, 4, 5 });
        int k = 2;
        ListNode expected = ListNode.insertByOrder(new int[] { 1, 4, 3, 2, 5 });
        ListNode actual = swapNodes(head, k);
        assertEquals(expected, actual);
    }
}
