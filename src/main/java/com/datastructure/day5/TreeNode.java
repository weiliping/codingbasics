package com.datastructure.day5;

public class TreeNode {
    public static TreeNode root;
    static {
        root = new TreeNode(16);
        root.left = new TreeNode(8);
        root.right = new TreeNode(24);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(2);
        root.left.left.left.left = new TreeNode(1);
        root.left.left.left.right = new TreeNode(3);
        root.left.left.right = new TreeNode(6);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(7);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.left.left = new TreeNode(9);
        root.left.right.left.right = new TreeNode(11);
        root.left.right.right = new TreeNode(14);
        root.left.right.right.left = new TreeNode(13);
        root.left.right.right.right = new TreeNode(15);
        root.right.left = new TreeNode(20);
        root.right.left.left = new TreeNode(18);
        root.right.left.left.left = new TreeNode(17);
        root.right.left.left.right = new TreeNode(19);
        root.right.left.right = new TreeNode(22);
        root.right.left.right.left = new TreeNode(21);
        root.right.left.right.right = new TreeNode(23);
        root.right.right = new TreeNode(28);
        root.right.right.left = new TreeNode(26);
        root.right.right.left.left = new TreeNode(25);
        root.right.right.left.right = new TreeNode(27);
        root.right.right.right = new TreeNode(30);
        root.right.right.right.right = new TreeNode(31);
        root.right.right.right.left = new TreeNode(29);
    }

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v) {
        val = v;
    }
}
