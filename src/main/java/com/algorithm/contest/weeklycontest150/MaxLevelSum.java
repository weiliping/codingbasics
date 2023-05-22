package com.algorithm.contest.weeklycontest150;

import java.util.LinkedList;

import com.algorithm.treedatastructure.TreeNode;

public class MaxLevelSum {
    public static void main(String[] args) {

    }

    public int maxLevelSum(TreeNode root) {
        int sum = Integer.MIN_VALUE, level = 1, res = -1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int levelSum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (levelSum > sum) {
                res = level;
                sum = levelSum;
            }
            level++;
        }
        return res;
    }
}
