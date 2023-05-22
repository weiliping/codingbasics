package com.algorithm.treedatastructure;

public class SumRootToLeafNumbers {

    /**
     * #129
     * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return sumNumsDFS(root, 0);
    }

    int sumNumsDFS(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumNumsDFS(root.left, sum) + sumNumsDFS(root.right, sum);
    }
}
