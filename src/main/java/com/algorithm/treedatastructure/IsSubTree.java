package com.algorithm.treedatastructure;

import java.util.PriorityQueue;

public class IsSubTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        // root.left.right.left = new TreeNode(0);
        // TreeNode root = new TreeNode(4);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(2);
        // root.right.left = new TreeNode(0);
        // TreeNode subRoot = new TreeNode(4);
        // subRoot.left = new TreeNode(1);
        // subRoot.right = new TreeNode(2);
        // IsSubTree is = new IsSubTree();
        // System.out.println(is.isSubtree(root, subRoot));

        // System.out.println(is.compareVersion("0.1", "1.1"));

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.offer(1);
        queue.offer(5);
        queue.offer(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        boolean isSameLeft = isSameTree(root.left, subRoot.left);
        boolean isSameRight = isSameTree(root.right, subRoot.right);
        return isSameLeft & isSameRight;
    }

    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int m = versions1.length, n = versions2.length;
        int len = Math.min(m, n);
        int i = 0;
        for (; i < len; i++) {
            Integer v1 = Integer.parseInt(versions1[i]);
            Integer v2 = Integer.parseInt(versions2[i]);
            if (v1 == v2) {
                continue;
            }
            return v1 > v2 ? 1 : -1;
        }
        if (m == n) {
            return 0;
        }

        if (m > len) {
            while (i < m) {
                Integer v1 = Integer.parseInt(versions1[i]);
                if (v1 != 0) {
                    return 1;
                }
                i++;
            }
            return 0;
        }
        while (i < n) {
            Integer v2 = Integer.parseInt(versions2[i]);
            if (v2 != 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}
