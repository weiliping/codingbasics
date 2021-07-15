package com.algorithm.treedatastructure;

public class TreeMaxPathSum {

    /**
     * #124
     * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPathSumRe(root, res);
        return res[0];
    }

    static int maxPathSumRe(TreeNode root, int[] res) {
        if (root == null)
            return 0;
        int left = maxPathSumRe(root.left, res);
        int right = maxPathSumRe(root.right, res);
        res[0] = Math.max(res[0], root.val + Math.max(left, 0) + Math.max(right, 0));
        return Math.max(root.val, root.val + Math.max(left, right));
    }
}
