package com.datastructure.day5;

public class HasPathSum {
    /**
     * #112
     * https://leetcode-cn.com/problems/path-sum/
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(root, 23));
        System.out.println(hasPathSum(root, 24));
        System.out.println(hasPathSum(root, 27));
        System.out.println(hasPathSum(root, 18));
        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == val) {
            return true;
        }
        int odd = val - root.val;
        return hasPathSum(root.left, odd) || hasPathSum(root.right, odd);
    }
}
