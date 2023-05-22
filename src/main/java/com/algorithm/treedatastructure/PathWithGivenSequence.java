package com.algorithm.treedatastructure;

public class PathWithGivenSequence {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        System.out.println(isValidSequence(root, new int[] {0, 1, 0, 1}));
        System.out.println(isValidSequence(root, new int[] {0, 0, 1}));
        System.out.println(isValidSequence(root, new int[] {0, 1, 1}));
    }

    public static boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) {
            return arr.length == 0;
        }
        return validSeqHelper(root, arr, 0);
    }

    static boolean validSeqHelper(TreeNode root, int[] arr, int i) {
        if (root == null || i >= arr.length || root.val != arr[i]) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return validSeqHelper(root.left, arr, i + 1) || validSeqHelper(root.right, arr, i + 1);
    }
}
