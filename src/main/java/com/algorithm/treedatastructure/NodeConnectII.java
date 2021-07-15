package com.algorithm.treedatastructure;

import java.util.LinkedList;
import java.util.Queue;

public class NodeConnectII {

    /**
     * #117
     * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);
        NodeConnectII conII = new NodeConnectII();
        conII.connect(root);
        System.out.println(root.next == null);
        System.out.println(root.left.next == root.right);
        System.out.println(root.left.right.next == root.right.right);
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node p = root.next;

        while (p != null) {
            if (p.left != null) {
                p = p.left;
                break;
            }
            if (p.right != null) {
                p = p.right;
                break;
            }
            p = p.next;
        }

        if (root.right != null) {
            root.right.next = p;
        }

        if (root.left != null) {
            root.left.next = root.right != null ? root.right : p;
        }
        connect(root.right);
        connect(root.left);

        return root;
    }

    public Node connectII(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node t = queue.poll();
                if (i < len - 1) {
                    t.next = queue.peek();
                }
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
        }
        return root;
    }
}
