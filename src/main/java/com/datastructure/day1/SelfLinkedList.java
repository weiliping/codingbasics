package com.datastructure.day1;

class LinkedNode {
    int v;
    LinkedNode next;

    public LinkedNode(int val) {
        v = val;
    }
}

public class SelfLinkedList {
//    private static int size;
    private static LinkedNode head;

    public SelfLinkedList(int v) {
        head = new LinkedNode(v);
    }

    public void add(int v) {
        if (exist(v)) {
            return;
        }
        LinkedNode p = new LinkedNode(0);
        p.next = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new LinkedNode(v);

    }

    public boolean delete(int v) {
        return false;
    }

    public boolean exist(int v) {
        LinkedNode p = new LinkedNode(0);
        p.next = head;

        while (p != null) {
            if (p.v == v) {
                return true;
            }
            p = p.next;
        }
        return false;
    }
}
