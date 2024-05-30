package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution3123 {
    public static void main(String[] args) {
        Solution3123 sol = new Solution3123();
        int n = 6;
        int[][] edges = new int[][] {{0,1,4},{0,2,1},{1,3,2},{1,4,3},{1,5,1},{2,3,1},{3,5,3},{4,5,2}};
        System.out.println(Arrays.toString(sol.findAnswerI(n, edges)));

        // int n1 = 7;
        // int[][] edges1 = new int[][] {{2,3,7},{5,2,1},{4,3,10},{6,3,1},{1,2,10},{0,6,6},{5,3,3}};
        // System.out.println(Arrays.toString(sol.findAnswer(n1, edges1)));
    }
    public boolean[] findAnswerI(int n, int[][] edges) {
        List<Integer[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int[] edge = edges[i];
            graph[edge[0]].add(new Integer[]{edge[1], edge[2], i});
            graph[edge[1]].add(new Integer[]{edge[0], edge[2], i});
        }
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            int[] e = queue.poll();
            if (res[e[1]] < e[0]) {
                continue;
            }
            for (Integer[] c : graph[e[1]]) {
                int j = c[0], w = c[1];
                int t = w + e[0];
                if (res[j] > t) {
                    res[j] = t;
                    queue.add(new int[]{w + e[0], j});
                }
            }
        }
        boolean[] ans = new boolean[m];
        if (res[n - 1] == Integer.MAX_VALUE) {
            return ans;
        }
        dfs(n - 1, res, graph, new boolean[n], ans);
        return ans;
    }

    public void dfs(int i, int[] minV, List<Integer[]>[] graph, boolean[] visits, boolean[] ans) {
        if (visits[i]) {
            return;
        }
        visits[i] = true;
        for (Integer[] e :  graph[i]) {
            if (minV[e[0]] + e[1] != minV[i]) {
                continue;
            }
            ans[e[2]] = true;
            dfs(e[0], minV, graph, visits, ans);
        }
    }

    public boolean[] findAnswer(int n, int[][] edges) {
        List<Integer[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int[] edge = edges[i];
            graph[edge[0]].add(new Integer[]{edge[1], i});
            graph[edge[1]].add(new Integer[]{edge[0], i});
        }
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        List<Integer> inds = new ArrayList<>();
        boolean[] ans = new boolean[m];
        dfsHelper(graph, edges, 0, n - 1, inds, 0, res, ans);
        return ans;
    }

    public void dfsHelper(List<Integer[]>[] graph, int[][] edges, int i, int maxInd, List<Integer> inds, int v, int[] res, boolean[] ans) {
        for (Integer[] child : graph[i]) {
            int t = v + edges[child[1]][2];
            if (res[child[0]] < t) {
                continue;
            }
            List<Integer> subInds = new ArrayList<>(inds);
            subInds.add(child[1]);
            if (child[0] == maxInd) {
                if (res[child[0]] > t) {
                    Arrays.fill(ans, false);
                    res[child[0]] = t;
                }
                for (Integer k : subInds) {
                    ans[k] = true;
                }
                continue;
            }    
            res[child[0]] = t;
            dfsHelper(graph, edges, child[0], maxInd, subInds, t, res, ans);
        }
    }
}
