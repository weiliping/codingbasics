package com.algorithm.treedatastructure;

public class SymmetricTree {

    /**
     * #101
     * https://leetcode-cn.com/problems/symmetric-tree/
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.right = new TreeNode(2);
        r.left.left = new TreeNode(3);
        r.left.right = new TreeNode(4);
        r.right.left = new TreeNode(4);
        r.right.right = new TreeNode(3);
        System.out.println(isSymmetric(r));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetricHelper(root.left, root.right);
    }

    static boolean symmetricHelper(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }

        if ((n1 == null && n2 != null) || (n1 != null && n2 == null) || n1.val != n2.val) {
            return false;
        }

        return symmetricHelper(n1.left, n2.right) && symmetricHelper(n1.right, n2.left);
    }
}
