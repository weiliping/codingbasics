package com.algorithm.selfpractice;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int v) {
        val = v;
    }
}
public class MaxDepth {

    static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
