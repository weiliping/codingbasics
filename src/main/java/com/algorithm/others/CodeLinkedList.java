package com.algorithm.others;

import java.util.Arrays;
import java.util.Stack;

public class CodeLinkedList {

    static Node head; // head of the list

    /* Node Class */
    static class Node {

        int data;
        Node next;

        // Constructor to create a new node
        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printlist(Node node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }

    Node reverselist(Node node) {
        Node prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    void rearrange(Node node) {

        // 1) Find the middle point using tortoise and hare method
        Node slow = node, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) Split the linked list in two halves
        // node1, head of first half    1 -> 2 -> 3
        // node2, head of second half   4 -> 5
        Node node1 = node;
        Node node2 = slow.next;
        slow.next = null;

        // 3) Reverse the second half, i.e., 5 -> 4
        node2 = reverselist(node2);

        // 4) Merge alternate nodes
        node = new Node(0); // Assign dummy Node

        // curr is the pointer to this dummy Node, which will
        // be used to form the new list
        Node curr = node;
        while (node1 != null || node2 != null) {

            // First add the element from first list
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }

            // Then add the element from second list
            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }

        // Assign the head of the new list to head pointer
        node = node.next;
    }

    public static void main(String[] args) {

        //        CodeLinkedList list = new CodeLinkedList();
        //        list.head = new Node(1);
        //        list.head.next = new Node(2);
        //        list.head.next.next = new Node(3);
        //        list.head.next.next.next = new Node(4);
        //        list.head.next.next.next.next = new Node(5);
        //
        //        list.printlist(head); // printout original list
        //        list.rearrange(head); // rearrange list as per ques
        //        System.out.println("");
        //        list.printlist(head); // printout modified list
        int len1 = 3;
        int len2 = 4;

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("dd");

        Stack<Integer> result = new Stack<Integer>();

        int i = 0;
        result.push(i++);
        System.out.println("dd");
    }
}