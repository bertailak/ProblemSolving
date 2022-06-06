package leetcode;

import java.util.Stack;

import leetcode.model.ListNode;

public class GetIntersectionNode {

    // https://leetcode.com/problems/intersection-of-two-linked-lists/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        
        while( a != b){
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
        
        return a;
    }
}
