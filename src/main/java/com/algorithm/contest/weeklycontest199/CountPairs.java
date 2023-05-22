package com.algorithm.contest.weeklycontest199;

import com.algorithm.treedatastructure.TreeNode;

public class CountPairs {

    public int countPairs(TreeNode root, int distance) {
        int[] ans = new int[1];
        dfs(root, distance, ans);
        return ans[0];
    }

    public void handle(TreeNode root, int[] state, int d, int[] ans) {
        int[] ret = dfs(root, d, ans);
        for (int i = 0; i <= d; i++) {
            for (int j = 0; j <= d; j++) {
                if (i + j + 1 <= d) {
                    ans[0] += ret[i] * state[j];
                }
            }
        }
        for (int i = 0; i < d; i++) {
            state[i + 1] += ret[i];
        }
    }

    public int[] dfs(TreeNode root, int d, int[] ans) {
        int[] state = new int[d + 1];
        if (root.left == null && root.right == null) {
            state[0] = 1;
            return state;
        }
        if (root.left != null) {
            handle(root.left, state, d, ans);
        }
        if (root.right != null) {
            handle(root.right, state, d, ans);
        }
        return state;
    }
}
