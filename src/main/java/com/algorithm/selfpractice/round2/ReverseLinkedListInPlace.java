package com.algorithm.selfpractice.round2;

import com.algorithm.linkedlists.ListNode;

public class ReverseLinkedListInPlace {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next = new ListNode(5);
        ReverseLinkedListInPlace r = new ReverseLinkedListInPlace();
        ListNode curr = r.reverseList(head);
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy.next;
        ListNode next = curr.next;
        while (next != null) {
            curr.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
            next = curr.next;
        }
        return dummy.next;
    }
}
