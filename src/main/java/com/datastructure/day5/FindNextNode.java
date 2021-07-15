package com.datastructure.day5;

public class FindNextNode {
    public static void main(String[] args) {
        for (int i = 1; i < 32; i++) {
            FindNextNode nextNode = new FindNextNode();
            TreeNode preN = nextNode.findNextNode(TreeNode.root, i);
            System.out.println("i = " + i + " " + (preN == null ? -1 : preN.val));
        }
    }

    public TreeNode findNextNode(TreeNode root, int val) {
        TreeNode parent = null, firstLParent = null, p = root;

        while (p != null && p.val != val) {
            parent = p;
            if (p.val < val) {
                p = p.right;
            } else {
                firstLParent = p;
                p = p.left;
            }
        }

        if (p == null) {
            return p;
        }

        if (p.right != null) {
            return getLeftNode(p.right);
        }

        if (parent == null || firstLParent == null) {
            return null;
        } else {
            if (p == parent) {
                return p;
            }
            return firstLParent;
        }
    }

    static TreeNode getLeftNode(TreeNode p) {
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
}
