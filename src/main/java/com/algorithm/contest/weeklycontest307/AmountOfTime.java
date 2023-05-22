package com.algorithm.contest.weeklycontest307;

import java.util.HashMap;
import java.util.Map;

import com.algorithm.treedatastructure.TreeNode;

public class AmountOfTime {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        System.out.println(amountOfTime(root, 3));
        TreeNode root2 = new TreeNode(1);
        System.out.println(amountOfTime(root2, 1));
    }

    public static int amountOfTime(TreeNode root, int start) {
        Map<Integer, int[]> mp = new HashMap<>();
        dfs(root, mp);
        int[] res = new int[1];
        dfsHelper(root, mp, res, 0, start);
        return res[0];
    }

    static void dfsHelper(TreeNode root, Map<Integer, int[]> mp, int[] rs, int p, int start) {
        if (root == null) {
            return;
        }
        int[] deps = mp.get(root.val);
        if (root.val == start) {
            rs[0] = Math.max(p, Math.max(deps[0], deps[1]));
            return;
        }
        dfsHelper(root.left, mp, rs, Math.max(p, deps[1]) + 1, start);
        dfsHelper(root.right, mp, rs, Math.max(p, deps[0]) + 1, start);
    }

    static void dfs(TreeNode root, Map<Integer, int[]> mp) {
        if (root == null) {
            return;
        }
        int[] deps = new int[2];
        if (root.left != null) {
            if (!mp.containsKey(root.left.val)) {
                dfs(root.left, mp);
            }
            int[] lDeps = mp.get(root.left.val);
            deps[0] = Math.max(lDeps[0], lDeps[1]) + 1;
        }
        if (root.right != null) {
            if (!mp.containsKey(root.right.val)) {
                dfs(root.right, mp);
            }
            int[] rDeps = mp.get(root.right.val);
            deps[1] = Math.max(rDeps[0], rDeps[1]) + 1;
        }
        mp.put(root.val, deps);
    }
}
