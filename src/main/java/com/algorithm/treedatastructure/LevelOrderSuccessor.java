package com.algorithm.treedatastructure;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.left.left = new Node(4);
        root.left.right = new Node(18);
        root.right = new Node(26);
        root.right.left = new Node(24);
        root.right.right = new Node(27);
        root.left.right.left = new Node(14);
        root.left.right.left.left = new Node(13);
        root.left.right.left.right = new Node(15);
        root.left.right.right = new Node(19);

        Node key = root.right.left; // node 24

        Node res = levelOrderSuccessor(root, key);

        if (res != null) {
            System.out.println("LevelOrder successor of " + key.val + " is " + res.val);
            return;
        }
        System.out.println("LevelOrder successor of " + key.val + " is NULL");
    }

    static Node levelOrderSuccessor(Node root, Node key) {
        // Base Case
        if (root == null)
            return null;

        // If root equals to key
        if (root == key) {
            // If left child exists it will be
            // the Postorder Successor
            if (root.left != null) {
                return root.left;
            }
            // Else if right child exists it will be
            // the Postorder Successor
            if (root.right != null) {
                return root.right;
            }
            return null; // No Successor
        }

        // Create an empty queue for level
        // order traversal
        Queue<Node> q = new LinkedList<Node>();

        // Enqueue Root
        q.add(root);

        while (!q.isEmpty()) {
            Node nd = q.peek();
            q.remove();

            if (nd.left != null) {
                q.add(nd.left);
            }

            if (nd.right != null) {
                q.add(nd.right);
            }

            if (nd == key) {
                break;
            }
        }

        return q.peek();
    }
}
