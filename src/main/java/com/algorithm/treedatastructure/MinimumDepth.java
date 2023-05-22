package com.algorithm.treedatastructure;

import java.util.LinkedList;

public class MinimumDepth {

    /**
     * #111
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
     * 
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println(minDepth(root));
        System.out.println(minDepthBfs(root));
    }

    public static int minDepthBfs(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            depth++;

            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = root.left == null ? 1 : minDepth(root.left);
        int rightDepth = root.right == null ? 1 : minDepth(root.right);
        return Math.min(leftDepth, rightDepth);
    }
}
