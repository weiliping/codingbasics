package com.algorithm.contest.weeklycontest231;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountRestrictedPaths {

    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
//        int n = 5;
//        int[][] edges = new int[][] { { 1, 2, 3 }, { 1, 3, 3 }, { 2, 3, 1 }, { 1, 4, 2 }, { 5, 2, 2 }, { 3, 5, 1 },
//                { 5, 4, 10 } };
//        System.out.println(countRestrictedPaths(n, edges));

//        int n1 = 7;
//        int[][] edges1 = new int[][] { { 1, 3, 1 }, { 4, 1, 2 }, { 7, 3, 4 }, { 2, 5, 3 }, { 5, 6, 1 },
//                { 6, 7, 2 }, { 7, 5, 3 }, { 2, 6, 4 } };
//        System.out.println(countRestrictedPaths(n1, edges1));


        int n2 = 10;
        int[][] edges2 = new int[][] { { 4, 10, 6 }, { 10, 5, 8 }, { 8, 4, 8 }, { 9, 3, 3 }, { 4, 6, 2 }, { 5, 1, 9 },
                { 1, 4, 6 }, { 2, 9, 2 }, { 5, 9, 9 }, { 2, 6, 3 }, { 6, 10, 3 }, { 7, 2, 3 }, { 3, 6, 3 },
                { 1, 10, 6 }, { 1, 6, 5 }, { 7, 5, 2 }, { 4, 7, 9 }, { 10, 2, 10 } };
        System.out.println(countRestrictedPaths(n2, edges2));
    }

    public static int countRestrictedPaths(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[][] weights = new int[n][n];
        for (int[] edge : edges) {
            int i = edge[0] - 1, j = edge[1] - 1;
            weights[i][j] = edge[2];
            weights[j][i] = edge[2];
            graph.get(i).add(j);
            graph.get(j).add(i);
        }
        int[] ws = new int[n];
        Arrays.fill(ws, -1);
        ws[n - 1] = 0;
        List<Integer> nodes = new ArrayList<>();
        nodes.add(0);
        dfsWeight(graph, 0, n, nodes, new ArrayList<>(), weights, ws);
        long[] res = new long[1];
        List<Integer> nodes2 = new ArrayList<>();
        nodes2.add(0);
        dfsPath(graph, 0, ws, n, nodes2, res);
        return (int) (res[0] % MOD);
    }

    static void dfsWeight(List<List<Integer>> graph, int i, int n, List<Integer> nodes, List<Integer> all,
            int[][] weights, int[] ws) {
        if (i == n - 1) {
            for (Integer node : nodes) {
                if (!all.contains(node)) {
                    List<Integer> nd = new ArrayList<>();
                    nd.add(node);
                    dfsHelper(graph, node, n, nd, weights, ws);
                }
            }
            return;
        }

        List<Integer> target = graph.get(i);
        for (Integer t : target) {
            if (nodes.contains(t)) {
                continue;
            }
            nodes.add(t);
            dfsWeight(graph, t, n, nodes, all, weights, ws);
            nodes.remove(nodes.size() - 1);
        }
    }

    static Integer dfsHelper(List<List<Integer>> graph, int i, int n, List<Integer> nodes, int[][] weights, int[] ws) {
        if (i == n - 1) {
            return 0;
        }
        List<Integer> target = graph.get(i);
        Integer minDistance = Integer.MAX_VALUE;
        boolean completed = true;
        for (Integer t : target) {
            if (!nodes.contains(t)) {
                nodes.add(t);
                Integer sub = dfsHelper(graph, t, n, nodes, weights, ws);
                if (sub != Integer.MAX_VALUE) {
                    sub += weights[i][t];
                    minDistance = Math.min(sub, minDistance);
                }
                nodes.remove(nodes.size() - 1);
                continue;
            }
            completed = false;
        }
        if (minDistance != Integer.MAX_VALUE && completed) {
            ws[i] = minDistance;
        }
        return minDistance;
    }

    static void dfsPath(List<List<Integer>> graph, int i, int[] dp, int n, List<Integer> nodes, long[] res) {
        if (i == n - 1) {
            res[0]++;
            return;
        }
        List<Integer> targets = graph.get(i);
        for (Integer t : targets) {
            if (!nodes.contains(t)) {
                nodes.add(t);
                if (dp[i] > dp[t] && dp[t] != -1) {
                    dfsPath(graph, t, dp, n, nodes, res);
                }
                nodes.remove(nodes.size() - 1);
            }
        }
    }
}
