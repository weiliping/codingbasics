package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class RemoveLinkedListElements {

    /**
     * #203
     * https://leetcode-cn.com/problems/remove-linked-list-elements
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        removeElements(head, 6);
        printout(head);
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode t = new ListNode(0);
        t.next = head;
        ListNode p = t;
        while (p.next != null) {
            if (p.next.val == val) {
                ListNode tmp = p.next;
                p.next = tmp.next;
                tmp.next = null;
            } else {
                p = p.next;
            }
        }
        return t.next;
    }
}
