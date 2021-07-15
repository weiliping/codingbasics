package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class PartitionList {

    /**
     * https://leetcode-cn.com/problems/partition-list/
     * https://leetcode.com/articles/partition-list/
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        printout(new PartitionList().partition(head, 3));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0), after = new ListNode(0);
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
