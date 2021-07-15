package com.algorithm.selfpractice;

import static com.algorithm.linkedlists.PrintNode.printout;

import com.algorithm.linkedlists.ListNode;

public class ReverseList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode head = new ReverseList().reverseList(node);

        printout(head);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        node2.next.next.next = new ListNode(4);
        ListNode head2 = new ReverseList().reverseListII(node2);
        printout(head2);
    }

    public ListNode reverseListII(ListNode node) {
        ListNode newHead = null, p = node;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        return newHead;
    }

    public ListNode reverseList(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode p = new ListNode(0);
        p.next = node;
        ListNode curr = p.next, next = curr.next;
        while (next != null) {
            curr.next = next.next;
            next.next = p.next;
            p.next = next;
            next = curr.next;
        }
        return p.next;
    }

    public ListNode deleteNNode(ListNode node, int n) {
        if (node == null || node.next == null) {
            return null;
        }
        ListNode step = node, p = node;

        for (int i = 0; i < n; i++) {
            step = step.next;
        }

        if (step == null) {
            return node.next;
        }

        while (step != null) {
            step = step.next;
            p = p.next;
        }

        p.next = p.next.next;

        return node;
    }
}
