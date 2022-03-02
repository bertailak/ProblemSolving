package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import leetcode.model.ListNode;

public class MergeTwoLists {

    // https://leetcode.com/problems/merge-two-sorted-lists/

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> l = new ArrayList<>();

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    l.add(list1.val);
                    list1 = list1.next;
                } else {
                    l.add(list2.val);
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                l.add(list1.val);
                list1 = list1.next;
            } else if (list2 != null) {
                l.add(list2.val);
                list2 = list2.next;
            }
        }

        ListNode list = null;
        if (l.size() > 0) {
            list = new ListNode(l.get(l.size() - 1));
            for (int i = l.size() - 2; i >= 0; i--) {
                list = new ListNode(l.get(i), list);
            }
        }
        return list;
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
