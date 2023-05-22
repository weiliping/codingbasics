package com.algorithm.linkedlists;

public final class PrintNode {
    private PrintNode() {
    }

    public static ListNode toNode(int[] nums) {
        ListNode p = new ListNode(0), head = p;
        for (int i : nums) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return head.next;
    }

    public static void printout(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode p = node;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            sb.append(p.val).append(", ");
            p = p.next;
        }
        System.out.println(sb.substring(0, sb.length() - 2));
    }
}
