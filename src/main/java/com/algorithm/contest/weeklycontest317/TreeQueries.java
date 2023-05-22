package com.algorithm.contest.weeklycontest317;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.algorithm.treedatastructure.TreeNode;

public class TreeQueries {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(treeQueries(root, new int[] { 4 })));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(1);
        root1.left.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(6);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(7);
        System.out.println(Arrays.toString(treeQueries(root1, new int[] { 3, 2, 4, 8 })));

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(5);
        root2.right.left = new TreeNode(3);
        root2.right.left.left = new TreeNode(2);
        root2.right.left.right = new TreeNode(4);
        // 1,0,3,3,3
        System.out.println(Arrays.toString(treeQueries(root2, new int[] { 3, 5, 4, 2, 4 })));
    }

    public static int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int[] res = new int[n];
        Map<Integer, int[]> mp = new HashMap<>();
        Map<Integer, int[][]> nodes = new HashMap<>();
        dfs(root, 0, mp, nodes);
        for (int i = 0; i < n; i++) {
            int[] node = mp.get(queries[i]);
            int[][] currNodes = nodes.get(node[0]);
            if (currNodes[1][0] == 0) {
                res[i] = node[0] - 1;
                continue;
            }
            if (currNodes[0][0] == queries[i]) {
                res[i] = currNodes[1][1] + node[0];
            } else {
                res[i] = currNodes[0][1] + node[0];
            }
        }
        return res;
    }

    public static void dfs(TreeNode root, int level, Map<Integer, int[]> mp, Map<Integer, int[][]> nodes) {
        if (root == null) {
            return;
        }

        dfs(root.left, level + 1, mp, nodes);
        dfs(root.right, level + 1, mp, nodes);
        int[][] curLevelNodes = nodes.get(level);
        if (curLevelNodes == null) {
            curLevelNodes = new int[2][2];
        }
        int max = 0;
        if (root.left != null) {
            int[] left = mp.get(root.left.val);
            max = Math.max(max, left[1] + 1);
        }
        if (root.right != null) {
            int[] right = mp.get(root.right.val);
            max = Math.max(max, right[1] + 1);
        }
        mp.put(root.val, new int[] { level, max });
        if (curLevelNodes[0][0] == 0) {
            curLevelNodes[0] = new int[] { root.val, max };
        } else if (curLevelNodes[1][0] == 0) {
            if (curLevelNodes[0][1] < max) {
                curLevelNodes[1][0] = curLevelNodes[0][0];
                curLevelNodes[1][1] = curLevelNodes[0][1];
                curLevelNodes[0] = new int[] { root.val, max };
            } else {
                curLevelNodes[1] = new int[] { root.val, max };
            }
        } else {
            if (curLevelNodes[0][1] < max) {
                curLevelNodes[1][0] = curLevelNodes[0][0];
                curLevelNodes[1][1] = curLevelNodes[0][1];
                curLevelNodes[0] = new int[] { root.val, max };
            } else if (curLevelNodes[1][1] < max) {
                curLevelNodes[1] = new int[] { root.val, max };
            }
        }
        nodes.put(level, curLevelNodes);
    }
}
