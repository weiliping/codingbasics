package com.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
    String v;
    TreeNode left;
    TreeNode right;

    public TreeNode(String val) {
        v = val;
    }
}

public class BfsSearch {

    public static void main(String[] args) {
        TreeNode root = new TreeNode("1");
        root.left = new TreeNode("2");
        root.right = new TreeNode("3");

        root.left.left = new TreeNode("4");
        root.left.right = new TreeNode("5");
        root.right.left = new TreeNode("6");
        root.right.right = new TreeNode("7");
        root.right.right.left = new TreeNode("8");
        root.right.right.right = new TreeNode("9");
        printTreeLeft(root);
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            System.out.println(t.v);
            if (t.left != null) {
                queue.offer(t.left);
            }
            if (t.right != null) {
                queue.offer(t.right);
            }
        }
    }

    public static void printTreeLeft(TreeNode root) {
        if (root == null) {
            return;
        }

        printTreeLeft(root.left);
        printTreeLeft(root.right);
        System.out.print(root.v + ", ");
    }
}
