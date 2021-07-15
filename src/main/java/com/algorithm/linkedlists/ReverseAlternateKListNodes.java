package com.algorithm.linkedlists;

public class ReverseAlternateKListNodes {
    static ListNode head;

    public static void main(String[] args) {
        ReverseAlternateKListNodes list = new ReverseAlternateKListNodes();

        for (int i = 20; i > 0; i--) {
            list.push(i);
        }
        System.out.println("Given Linked List :");
        list.printList(head);
        head = list.kAltReverse(head, 3);
        System.out.println("");
        System.out.println("Modified Linked List :");
        list.printList(head);
    }

    ListNode kAltReverse(ListNode node, int k) {
        ListNode current = node;
        ListNode next, prev = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
  
        if (node != null) {
            node.next = current;
        }
  
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }
  
        if (current != null) {
            current.next = kAltReverse(current.next, k);
        }
        return prev;
    }

    void printList(ListNode node) {
        while (node != null) {
            node = node.next;
        }
    }

    void push(int newdata) {
        ListNode myListNode = new ListNode(newdata);
        myListNode.next = head;
        head = myListNode;
    }
}
