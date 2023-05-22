package com.datastructure.day1;

class ReorderNode {
    int v;
    ReorderNode next;
    public ReorderNode(int val) {
        v = val;
    }
}
public class ReorderLinkedList {

    public static void main(String args[]) {
        ReorderNode node = new ReorderNode(1);
        node.next = new ReorderNode(2);
        node.next.next = new ReorderNode(3);
        node.next.next.next = new ReorderNode(4);
        node.next.next.next.next = new ReorderNode(5);
        ReorderNode head = reorderNode(node);
        while (head != null) {
            String str = head.next == null ? "NULL" : "";
            System.out.print(head.v + "->" + str);
            head = head.next;
        }
    }

    public static ReorderNode reorderNode(ReorderNode node) {
        ReorderNode right = findMid(node);
        ReorderNode reverse = reverseNode(right);
        return mergeNode(node, reverse);
    }

    public static ReorderNode findMid(ReorderNode node) {
        if (node == null) {
            return node;
        }

        ReorderNode slow = node, fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ReorderNode reverseNode(ReorderNode node) {
        if (node == null) {
            return node;
        }

        ReorderNode reverseN = null, p = node;

        while (p != null) {
            ReorderNode t = p.next;
            p.next = reverseN;
            reverseN = p;
            p = t;
        }
        return reverseN;
    }

    public static ReorderNode mergeNode(ReorderNode h1, ReorderNode h2) {
        if (h1 == null) {
            return h2;
        }

        if (h2 == null) {
            return h1;
        }

        ReorderNode p = h1;
        while (p != null && h2.next != null) {
            ReorderNode t = h2;
            h2 = h2.next;
            t.next = p.next;
            p.next = t;
            p = p.next.next;
        }
        return h1;
    }
}
