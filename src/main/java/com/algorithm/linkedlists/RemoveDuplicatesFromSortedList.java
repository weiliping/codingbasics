package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class RemoveDuplicatesFromSortedList {

    /**
     * #83
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(4);
        ListNode h = removeDuplicates(head);
        printout(h);
    }

    public static ListNode removeDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val != p.next.val) {
                p = p.next;
                continue;
            }
            ListNode newNext = p.next.next;
            p.next = newNext;
        }
        return head;
    }
}
