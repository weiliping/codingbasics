package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

import com.algorithm.linkedlists.ListNode;

public class ReverseSubList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        printout(head);

        printout(reverseSubList(head, 1, 5));
    }
    
    public static ListNode reverseSubList(ListNode head, int p, int q) {
        if (head == null || p == q) {
            return head;
        }
        ListNode pr = new ListNode(-1), fast = head;
        pr.next = head;
        ListNode slow = pr;

        while (p > 1 && slow != null) {
            slow = slow.next;
            p--;
        }

        while (q > 0 && fast != null) {
            fast = fast.next;
            q--;
        }

        ListNode prev = slow, curr = slow.next, next = curr.next;

        while (next != null && next != fast) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }

        return pr.next;
    }
}
