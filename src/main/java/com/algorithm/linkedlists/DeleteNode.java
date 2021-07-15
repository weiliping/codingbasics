package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class DeleteNode {
    /**
     * #237
     * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new DeleteNode().deleteNode(head);
        printout(head);
    }

    public void deleteNode(ListNode head) {
        head.val = head.next.val;
        head.next = head.next.next;
    }
}
