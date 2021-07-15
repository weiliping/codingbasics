package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class IntersectionNote {

    /**
     * #160
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);

        ListNode headB = new ListNode(3);
        headB.next = new ListNode(2);
        headB.next.next = new ListNode(4);
        printout(new IntersectionNote().getIntersectionNode(headA, headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int l1 = getNodeLen(headA), l2 = getNodeLen(headB);

        if (l1 > l2) {
            return helper(headA, headB, l1 - l2);
        }
        return helper(headB, headA, l2 - l1);
    }

    static ListNode helper(ListNode h1, ListNode h2, int i) {
        while (i > 0) {
            h1 = h1.next;
            i--;
        }

        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
    }

    static int getNodeLen(ListNode node) {
        ListNode p = node;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }
}
