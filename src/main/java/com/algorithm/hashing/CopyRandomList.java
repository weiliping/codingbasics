package com.algorithm.hashing;

public class CopyRandomList {
    /**
     * https://leetcode-cn.com/problems/copy-list-with-random-pointer
     *
     * @param args
     */
    public static void main(String[] args) {
        Node p = new Node(7);
        p.next = new Node(13);
        p.next.next = new Node(11);
        p.next.next.next = new Node(10);
        p.next.next.next.next = new Node(1);
        p.next.random = p;
        p.next.next.random = p.next.next.next.next;
        p.next.next.next.random = p.next.next;
        p.next.next.next.next.random = p;
        Node n = new CopyRandomList().copyRandomList(p);
        while (n != null) {
            System.out.println(n.val);
            if (n.random != null) {
                System.out.println(n.random.val);
            } else {
                System.out.println("null");
            }
            n = n.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        //copy node
        Node p = head;
        while (p != null) {
            Node t = new Node(p.val);
            t.next = p.next;
            p.next = t;
            p = t.next;
        }

        //copy random
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        //remove old node
        p = head;
        Node res = p.next;
        while (p != null) {
            Node t = p.next;
            p.next = t.next;
            if (t.next != null) {
                t.next = t.next.next;
            }
            p = p.next;
        }
        return res;
    }
}
