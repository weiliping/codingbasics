package com.algorithm.others;

class ListNode {
    int val;
    ListNode next;

    ListNode(int i) {
        val = i;
        next = null;
    }
}

public class ReverseLinkedList {

    public ListNode reverse(ListNode node) {
        ListNode prev = null, next, curr = node;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        ListNode n = new ReverseLinkedList().reverse(node);
        System.out.println("3333");
    }
}
