package com.algorithm.selfpractice.round2;

import com.algorithm.linkedlists.ListNode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        for (int i = m; i < n; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
