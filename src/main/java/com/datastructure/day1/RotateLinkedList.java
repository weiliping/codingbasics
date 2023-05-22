package com.datastructure.day1;

class ListNode {
    int v;
    ListNode next;

    public ListNode(int val) {
        v = val;
    }
}

public class RotateLinkedList {

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        n.next.next.next.next.next = new ListNode(6);
        ListNode root = rotateKNode(n, 3);
        System.out.println(root);
    }

    public static ListNode rotateKNode(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int n = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            n++;
        }

        int m = n - k % n;
        p.next = head;

        for (int i = 0; i < m; i++) {
            p = p.next;
        }

        ListNode newH = p.next;
        p.next = null;
        return newH;
    }
}
