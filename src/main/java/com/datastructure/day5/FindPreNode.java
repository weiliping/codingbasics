package com.datastructure.day5;
public class FindPreNode {
    public static void main(String[] args) {
        for (int i = 1; i < 32; i++) {
            FindPreNode preNode = new FindPreNode();
            TreeNode preN = preNode.getPrevNode(TreeNode.root, i);
            System.out.println("i= " + i + " prev= " + (preN == null ? -1 : preN.val));
        }
    }

    public TreeNode getPrevNode(TreeNode root, int val) {
        TreeNode parent = null, firstRParent = null, p = root;

        while (p != null && p.val != val) {
            parent = p;
            if (p.val > val) {
                p = p.left;
            } else {
                firstRParent = p;
                p = p.right;
            }
        }

        if (p == null) {
            return p;
        }

        if (p.left != null) {
            return getRightNode(p.left);
        }

        if (parent == null || firstRParent == null) {
            return null;
        } else {
            if (p == parent) {
                return parent;
            }
            return firstRParent;
        }
    }

    static TreeNode getRightNode(TreeNode p) {
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
}
