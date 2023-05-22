package com.datastructure.day1;

class ReverseNode {
    int v;
    ReverseNode next;

    public ReverseNode(int val) {
        v = val;
    }
}

public class ReverseLinkedList {

    public static void main(String args[]) {
        ReverseNode root = new ReverseNode(1);
        root.next = new ReverseNode(2);
        root.next.next = new ReverseNode(3);
        root.next.next.next = new ReverseNode(4);
        root.next.next.next.next = new ReverseNode(5);
        reverseNodeTemp(root);
    }

    public static ReverseNode reverseNode(ReverseNode root) {
        if (root == null) {
            return root;
        }
        ReverseNode p = new ReverseNode(0);
        p.next = root;
        ReverseNode curr = p.next, next = curr.next;
        while (next != null) {
            curr.next = next.next;
            next.next = p.next;
            p.next = next;
            next = curr.next;
        }
        return p.next;
    }

    public static ReverseNode reverseNodeTemp(ReverseNode root) {
        ReverseNode curr = root, p = new ReverseNode(0);
        while (curr != null) {
            ReverseNode next = curr.next;
            curr.next = null;
            ReverseNode temp = p.next;
            p.next = curr;
            p.next.next = temp;
            curr = next;
        }
        return p.next;
    }
}
