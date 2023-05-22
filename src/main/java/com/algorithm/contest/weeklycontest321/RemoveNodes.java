package com.algorithm.contest.weeklycontest321;

import com.algorithm.linkedlists.ListNode;
import com.algorithm.linkedlists.PrintNode;

public class RemoveNodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        PrintNode.printout(removeNodes(head));

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(1);

        PrintNode.printout(removeNodes(head1));
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode p = new ListNode(-1), cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            ListNode pNode = p.next;
            while (pNode != null && pNode.val < cur.val) {
                pNode = pNode.next;
            }
            if (pNode == null) {
                p.next = cur;
            } else {
                cur.next = pNode;
                p.next = cur;
            }
            cur = next;
        }

        ListNode prev = null, next, curr = p.next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
