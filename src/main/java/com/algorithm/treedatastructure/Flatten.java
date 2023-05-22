package com.algorithm.treedatastructure;

public class Flatten {

    /**
     * #114
     * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Flatten f = new Flatten();
        f.flattenNonRecursive(root);
        TreeNode p = root;
        while (p != null) {
            System.out.println(p.val);
            p = p.right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
        }

        if (root.right != null) {
            flatten(root.right);
        }

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }

    public void flattenNonRecursive(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode p = curr.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
