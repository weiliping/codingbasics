package com.algorithm.contest.weeklycontest266;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximalPathQuality {
    private int maxTime;
    private int[] values;

    public static void main(String[] args) {
        MaximalPathQuality m = new MaximalPathQuality();

        int[] values = new int[] { 0, 32, 10, 43 };
        int[][] edges = new int[][] { { 0, 1, 10 }, { 1, 2, 15 }, { 0, 3, 10 } };
        int maxTime = 49;
        System.out.println(m.maximalPathQuality(values, edges, maxTime));
        int[] values1 = new int[] { 5,10,15,20 };
        int[][] edges1 = new int[][] { { 0, 1, 10 }, { 0, 3, 10 } };
        int maxTime1 = 30;
        System.out.println(m.maximalPathQuality(values1, edges1, maxTime1));
    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new int[] { e[1], e[2] });
            graph[e[1]].add(new int[] { e[0], e[2] });
        }
        this.values = values;
        this.maxTime = maxTime;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int[] ans = new int[1];
        dfs(graph, visited, 0, 0, values[0], ans);
        return ans[0];
    }

    void dfs(List<int[]>[] graph, boolean[] visited, int node, int time, int value, int[] ans) {
        if (node == 0) {
            ans[0] = Math.max(ans[0], value);
        }

        for (int[] curr : graph[node]) {
            int nextNode = curr[0];
            if (time + curr[1] <= maxTime) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    dfs(graph, visited, nextNode, time + curr[1], value + values[nextNode], ans);
                    visited[nextNode] = false;
                } else {
                    dfs(graph, visited, nextNode, time + curr[1], value, ans);
                }
            }
        }
    }
}
