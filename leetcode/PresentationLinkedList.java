package leetcode;

import leetcode.model.ListNode;

public class PresentationLinkedList {

    public static void print(ListNode l) {
        // ListNode l = list;
        System.out.println(l);
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);

        list.next = second;
        second.next = third;
        print(list);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        
        while(head!=null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        
        return prev;
    }
}