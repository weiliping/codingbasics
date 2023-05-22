package com.algorithm.treedatastructure;

public class LowestCommonAncestor {

    /**
     * #236
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode n = new LowestCommonAncestor().lowestCommonAncestor(root, root.left, root.right);
        System.out.println(n.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        // Post order traveral
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p and q in two subtrees
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
