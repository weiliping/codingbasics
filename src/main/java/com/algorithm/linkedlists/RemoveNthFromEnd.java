package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class RemoveNthFromEnd {
    /**
     * #19
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        printout(new RemoveNthFromEnd().removeNthFromEnd(root, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode pre = head, curr = head;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            return head.next;
        }

        while (curr.next != null) {
            curr = curr.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
