package com.algorithm.linkedlists;

import static com.algorithm.linkedlists.PrintNode.printout;

public class ReverseList {

    /**
     * #206
     * https://leetcode-cn.com/problems/reverse-linked-list
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode head = new ReverseList().reverseList(node);
        printout(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null, p = head;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        return newHead;
    }
}
