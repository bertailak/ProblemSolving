package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.Test;

import leetcode.model.ListNode;

public class MergeKLists {

    // https://leetcode.com/problems/merge-k-sorted-lists/

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                pq.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        ListNode list = null;
        if (pq.size() > 0) {
            list = new ListNode(pq.poll());
            while (!pq.isEmpty()) {
                list = new ListNode(pq.poll(), list);
            }
        }
        return list;
    }

    @Test
    public void test1() {
        ListNode[] lists = new ListNode[] { ListNode.insertByOrder(new int[] { 1, 4, 5 }),
                ListNode.insertByOrder(new int[] { 1, 3, 4 }),
                ListNode.insertByOrder(new int[] { 2, 6 }) };
        ListNode expected = ListNode.insertByOrder(new int[] { 1, 1, 2, 3, 4, 4, 5, 6 });
        ListNode actual = mergeKLists(lists);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        ListNode[] lists = new ListNode[] {};
        ListNode expected = ListNode.insertByOrder(new int[] {});
        ListNode actual = mergeKLists(lists);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        ListNode[] lists = new ListNode[] { ListNode.insertByOrder(new int[] {}) };
        ListNode expected = ListNode.insertByOrder(new int[] {});
        ListNode actual = mergeKLists(lists);
        assertEquals(expected, actual);
    }

}
