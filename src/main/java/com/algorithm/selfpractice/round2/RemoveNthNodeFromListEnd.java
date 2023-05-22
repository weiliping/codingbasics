package com.algorithm.selfpractice.round2;

import com.algorithm.linkedlists.ListNode;

public class RemoveNthNodeFromListEnd {

    public ListNode removeNthFormEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);

        dummy.next = head;
        ListNode p = dummy, p2 = dummy;

        for (int i = 0; i < n + 1; i++) {
            p = p.next;
        }

        if (p == null) {
            return head.next;
        }

        while (p != null) {
            p2 = p2.next;
            p = p.next;
        }

        p2.next = p2.next.next;
        return head;
    }
}
