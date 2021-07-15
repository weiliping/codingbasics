package com.algorithm.treedatastructure;

public class NodeConnect {

    /**
     * #116
     * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
     *
     * @param args
     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        new NodeConnect().connect(root);

        System.out.println(root.next == null);
        System.out.println(root.left.next == root.right);
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null) {
            root.right.next = root.next != null ? root.next.left : null;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
