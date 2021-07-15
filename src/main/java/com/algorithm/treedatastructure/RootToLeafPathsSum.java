package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RootToLeafPathsSum {

    /**
     * #113
     * https://leetcode-cn.com/problems/path-sum-ii/
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int sum = 22;
        List<List<Integer>> paths = new RootToLeafPathsSum().pathSum(root, sum);
        for (List<Integer> p : paths) {
            System.out.println(Arrays.toString(p.toArray()));
        }
    }

    public List<List<Integer>> pathSum(TreeNode node, int sum) {
        Stack<Integer> s = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        pathSumHelper(node, sum, s, res);
        return res;
    }

    void pathSumHelper(TreeNode node, int sum, Stack<Integer> s, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        s.add(node.val);
        if (sum == node.val && node.left == null && node.right == null) {
            res.add(new ArrayList<>(s));
        }
        pathSumHelper(node.left, sum - node.val, s, res);
        pathSumHelper(node.right, sum - node.val, s, res);
        s.pop();
    }
}
