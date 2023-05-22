package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class OddEvenList {
    /**
     * #328
     * https://leetcode-cn.com/problems/odd-even-linked-list/
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new OddEvenList().oddEvenList(head);
        printout(head);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head, curr = head.next;
        while (curr != null && curr.next != null) {
            ListNode tmp = pre.next;
            pre.next = curr.next;
            curr.next = curr.next.next;
            pre.next.next = tmp;
            curr = curr.next;
            pre = pre.next;
        }
        return head;
    }
}
