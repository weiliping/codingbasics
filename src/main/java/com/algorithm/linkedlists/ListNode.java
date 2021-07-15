package com.algorithm.linkedlists;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode nextNode) {
        val = x;
        next = nextNode;
    }

    public ListNode() {
    }
}
