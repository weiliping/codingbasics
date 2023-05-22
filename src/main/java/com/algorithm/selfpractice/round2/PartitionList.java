package com.algorithm.selfpractice.round2;

import com.algorithm.linkedlists.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode after = new ListNode(0), before = new ListNode(0);
        ListNode bp = before, ap = after, p = head;

        while (p != null) {
            if (p.val < x) {
                bp.next = p;
                bp = bp.next;
            } else {
                ap.next = p;
                ap = ap.next;
            }
            p = p.next;
        }
        ap.next = null;
        bp.next = after.next;
        return before.next;
    }
}
