package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class RemoveDuplicatesFromSortedListII {

    /**
     * #82
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        printout(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;
        ListNode p = t;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int dupVal = p.next.val;
                while (p.next != null && p.next.val == dupVal) {
                    p.next = p.next.next;
                }
                continue;
            }
            p = p.next;
        }
        return t.next;
    }
}
