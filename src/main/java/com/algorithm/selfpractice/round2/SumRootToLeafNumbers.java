package com.algorithm.selfpractice.round2;

import com.algorithm.treedatastructure.TreeNode;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        return dfsSum(root, sum);
    }

    static int dfsSum(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        }

        return dfsSum(root.left, sum) + dfsSum(root.right, sum);
    }
}
