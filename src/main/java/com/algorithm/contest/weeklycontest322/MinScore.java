package com.algorithm.contest.weeklycontest322;

import java.util.ArrayList;
import java.util.List;

public class MinScore {
    public static void main(String[] args) {
        int n = 4, roads[][] = new int[][] { { 1, 2, 9 }, { 2, 3, 6 }, { 2, 4, 5 }, { 1, 4, 7 } };
        System.out.println(minScore(n, roads));
        int n1 = 4, roads1[][] = new int[][] { { 1, 2, 2 }, { 1, 3, 4 }, { 3, 4, 7 }, { 1, 4, 7 } };
        System.out.println(minScore(n1, roads1));
    }

    public static int minScore(int n, int[][] roads) {
        List<int[]>[] graphs = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graphs[i] = new ArrayList<>();
        }
        for (int[] r : roads) {
            graphs[r[0]].add(new int[] { r[1], r[2] });
            graphs[r[1]].add(new int[] { r[0], r[2] });
        }

        boolean[] visited = new boolean[n + 1];
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        dfs(graphs, n, visited, res);
        return res[0];
    }

    static void dfs(List<int[]>[] graphs, int i, boolean[] visited, int[] res) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int[] ind : graphs[i]) {
            if (ind[1] < res[0]) {
                res[0] = ind[1];
            }
            dfs(graphs, ind[0], visited, res);
        }
    }
}
