package com.algorithm.treedatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    /**
     * #102
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = levelOrder(root);
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
        List<List<Integer>> resB = levelOrderBacking(root);
        for (List<Integer> r : resB) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static void printLevelOrder(TreeNode root) {
        List<List<Integer>> resB = levelOrderBacking(root);
        for (List<Integer> r : resB) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        nodeQueue.offer(null);
        List<Integer> subRes = new ArrayList<>();
        while (true) {
            TreeNode curr = nodeQueue.poll();
            if (curr != null) {
                subRes.add(curr.val);
                if (curr.left != null) {
                    nodeQueue.offer(curr.left);
                }
                if (curr.right != null) {
                    nodeQueue.offer(curr.right);
                }
            } else {
                res.add(subRes);
                subRes = new ArrayList<>();
                if (nodeQueue.isEmpty()) {
                    break;
                }
                nodeQueue.offer(null);
            }
        }
        return res;
    }

    public static List<List<Integer>> levelOrderBacking(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        levelOrderHelper(root, 0, res);
        return res;
    }

    static void levelOrderHelper(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        levelOrderHelper(root.left, level + 1, res);
        levelOrderHelper(root.right, level + 1, res);
    }
}
