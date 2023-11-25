package leetcode;

import leetcode.model.ListNode;

public class SplitListToParts {

    // https://leetcode.com/problems/split-linked-list-in-parts

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] list = new ListNode[k];

        int len = 0;

        ListNode h = new ListNode(0, head);

        while (h != null) {
            h = h.next;
            len++;
        }

        int j = 0;
        while (len > 0) {

            int l = (int) Math.ceil((1.0 * len) / (k - j));
            ListNode h2 = head.next;

            while (l >= 0 && h2.next != null) {
                head = head.next;
                h2 = h2.next;
                
                l--;
            }

            len -= l;
        }

        return list;
    }
}
