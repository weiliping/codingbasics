package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class SortList {

    /**
     * #148
     * https://leetcode-cn.com/problems/sort-list/
     * @param args
     */
    public static void main(String[] args) {
        ListNode h = new ListNode(4);
        h.next = new ListNode(2);
        h.next.next = new ListNode(1);
        h.next.next.next = new ListNode(3);
        ListNode n = sortList(h);
        printout(n);
    }

    static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }

    static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
