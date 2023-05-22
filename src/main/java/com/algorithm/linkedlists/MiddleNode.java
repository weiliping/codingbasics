package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class MiddleNode {
    /**
     * #876
     * https://leetcode-cn.com/problems/middle-of-the-linked-list/
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printout(middleNode(head));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
