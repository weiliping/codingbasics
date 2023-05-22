package com.algorithm.grokking.dfs;

import com.algorithm.treedatastructure.TreeNode;

public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumRootToLeafNumbers(root));
    }


    public static int sumRootToLeafNumbers(TreeNode root) {
        return pathSumHelper(root, 0);
    }

    static int pathSumHelper(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        int res = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return res ;
        }
        return pathSumHelper(root.left, res) + pathSumHelper(root.right, res);
    }
}
