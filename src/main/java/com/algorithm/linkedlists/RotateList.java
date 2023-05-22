package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class RotateList {
    /**
     * #61
     * https://leetcode-cn.com/problems/rotate-list
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        n.next.next.next.next.next = new ListNode(6);
        ListNode root = rotateRight(n, 3);
        printout(root);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int n = 1;
        ListNode curr = head;
        while (curr.next != null) {
            n++;
            curr = curr.next;
        }

        curr.next = head;

        int m = n - k % n;
        for (int i = 0; i < m; i++) {
            curr = curr.next;
        }

        ListNode nHead = curr.next;
        curr.next = null;
        return nHead;
    }
}
