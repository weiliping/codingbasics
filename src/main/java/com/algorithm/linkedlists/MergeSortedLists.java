package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class MergeSortedLists {
    /**
     * #21
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);
        ListNode mergedhead = new MergeSortedLists().mergeTwoLists(head1, head2);
        printout(mergedhead);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
