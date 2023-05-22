package com.algorithm.treedatastructure;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllLevelOrderSiblings {
    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        System.out.println("Input: [12, 7, 1, 9, null, 10, 5]");
        connect(root);

        Node current = root;
        System.out.println("Output: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    private static void connect(final Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node previous = null;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (previous != null) {
                previous.next = currentNode;
            }
            previous = currentNode;

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }
}
