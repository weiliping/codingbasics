package com.algorithm.contest.weeklycontest270;

import com.algorithm.linkedlists.ListNode;

public class DeleteMiddle {
    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        p.next = new ListNode(3);
        p.next.next = new ListNode(4);
        p.next.next.next = new ListNode(7);
        p.next.next.next.next = new ListNode(1);
        p.next.next.next.next.next = new ListNode(2);
        p.next.next.next.next.next.next = new ListNode(6);
        deleteMiddle(p);
        ListNode p2 = new ListNode(1);
//        p2.next = new ListNode(2);
//        p2.next.next = new ListNode(3);
//        p2.next.next.next = new ListNode(4);
        deleteMiddle(p2);
    }
    public static ListNode deleteMiddle(ListNode head) {
        ListNode fast = head, slow = fast;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode curr = new ListNode(-1);
        curr.next = head;
        ListNode nHead = curr;
        while (slow != null) {
            curr = curr.next;
            slow = slow.next;
        }
        curr.next = curr.next.next;
        return nHead.next;
    }
}
