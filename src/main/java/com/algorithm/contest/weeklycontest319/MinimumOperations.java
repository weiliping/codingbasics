package com.algorithm.contest.weeklycontest319;

import java.util.ArrayDeque;
import java.util.Arrays;

import com.algorithm.treedatastructure.TreeNode;

public class MinimumOperations {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(9);
        root.right.right.left = new TreeNode(10);
        System.out.println(minimumOperations(root));
    }

    public static int minimumOperations(TreeNode root) {
        int cnt = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root.left != null) {
            queue.offer(root.left);
        }
        if (root.right != null) {
            queue.offer(root.right);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            int[][] vals = new int[n][2];
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                vals[i][0] = node.val;
                vals[i][1] = i;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            Arrays.sort(vals, (a, b) -> a[0] - b[0]);
            for (int i = 0; i < n; i++) {
                while (vals[i][1] != i) {
                    int temp = vals[vals[i][1]][1];
                    vals[vals[i][1]][1] = vals[i][1];
                    vals[i][1] = temp;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
