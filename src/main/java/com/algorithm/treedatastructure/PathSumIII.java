package com.algorithm.treedatastructure;

import java.util.HashMap;

public class PathSumIII {
    /**
     * #437
     * https://leetcode-cn.com/problems/path-sum-iii
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        System.out.println(pathSum(root, 8));
        System.out.println(pathSumI(root, 8));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(-2);
        root1.right = new TreeNode(-3);
        root1.left.left = new TreeNode(1);
        root1.right.left = new TreeNode(-2);
        root1.left.left.left = new TreeNode(-1);
        System.out.println(pathSum(root1, -1));
        System.out.println(pathSumI(root1, -1));

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        root2.right.right.right = new TreeNode(4);
        root2.right.right.right.right = new TreeNode(5);
        System.out.println(pathSum(root2, 3));
        System.out.println(pathSumI(root2, 3));
    }

    public static int pathSum(TreeNode root, int sum) {
        int[] res = new int[1];
        sumHelper(root, res, sum);
        return res[0];
    }

    private static void sumHelper(TreeNode root, int[] res, int sum) {
        if (root == null) {
            return;
        }
        pathSumHelper(root, res, sum);
        sumHelper(root.left, res, sum);
        sumHelper(root.right, res, sum);
    }

    private static void pathSumHelper(TreeNode root, int[] res, int sum) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            res[0]++;
        }
        int remain = sum - root.val;
        pathSumHelper(root.left, res, remain);
        pathSumHelper(root.right, res, remain);
    }

    public static int pathSumI(TreeNode root, int sum) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int[] res = new int[1];
        process(root, res, 0, sum, sums);
        return res[0];
    }

    private static void process(TreeNode node, int[] res, int currSum, int sum, HashMap<Integer, Integer> sums) {
        if (node == null) {
            return;
        }
        currSum += node.val;
        if (sums.containsKey(currSum - sum)) {
            res[0] += sums.get(currSum - sum);
        }
        if (!sums.containsKey(currSum)) {
            sums.put(currSum, 0);
        }
        sums.put(currSum, sums.getOrDefault(currSum, 0) + 1);
        process(node.left, res, currSum, sum, sums);
        process(node.right, res, currSum, sum, sums);
        sums.put(currSum, sums.get(currSum) - 1);
    }
}
