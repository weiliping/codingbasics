package com.algorithm.contest.weeklycontest426;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MaxTargetNodes {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length;
        int m = edges2.length;
        int[] ans = new int[n];
        List<Integer>[] graph1 = new ArrayList[1000];
        for (int i = 0; i < 1000; i++) {
            graph1[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int u = edges1[i][0];
            int v = edges1[i][1];
            graph1[u].add(v);
            graph1[v].add(u);
        }
        List<Integer>[] graph2 = new ArrayList[1000];    
        for (int i = 0; i < 1000; i++) {
            graph2[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = edges2[i][0];
            int v = edges2[i][1];
            graph2[u].add(v);
            graph2[v].add(u);
        }
        return ans;
    }

    public int[] buildGraph(List<Integer>[] graph1, int k, int n) {
        int[] graph = new int[n];
        for (int i = 0; i < n; i++) {
            int j = 1;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            boolean[] visited = new boolean[n];
            visited[i] = true;
            graph[i] = 1;
            j = 1;
            while (j < k) {
                int s = queue.size();
                while (s > 0) {
                    int u = queue.poll();
                    for (int v : graph1[u]) {
                        if (!visited[v]) {
                            visited[v] = true;
                            queue.add(v);
                        }
                    }
                    s--;
                }
                graph[i] += queue.size();
                j++;
            }
        }
        return graph;
    }
}
