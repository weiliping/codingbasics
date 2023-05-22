package com.algorithm.contest.weeklycontest83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumFuelCost {

    public static void main(String[] args) {
        int[][] roads = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 } };
        int seats = 5;
        System.out.println(minimumFuelCost(roads, seats));

        int[][] roads1 = new int[][] { { 3, 1 }, { 3, 2 }, { 1, 0 }, { 0, 4 }, { 0, 5 }, { 4, 6 } };
        int seats1 = 2;
        System.out.println(minimumFuelCost(roads1, seats1));

        int[][] roads2 = new int[0][];
        int seats2 = 1;
        System.out.println(minimumFuelCost(roads2, seats2));
    }

    public static long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        if (n == 1) {
            return 0l;
        }

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        boolean[] visited = new boolean[n];
        long[] res = new long[1];
        int[] cnts = new int[n];
        Arrays.fill(cnts, 1);
        dfs(graph, 0, visited, res, seats, cnts);
        return res[0];
    }

    static void dfs(List<Integer>[] graph, int i, boolean[] visited, long[] res, int seats, int[] cnts) {
        if (graph[i].size() == 0) {
            return;
        }

        visited[i] = true;
        for (Integer ind : graph[i]) {
            if (visited[ind]) {
                continue;
            }
            dfs(graph, ind, visited, res, seats, cnts);
            cnts[i] += cnts[ind];
            if (seats == 1) {
                res[0] += cnts[ind];
            } else {
                res[0] += cnts[ind] / seats;
                if (cnts[ind] % seats != 0) {
                    res[0]++;
                }
            }
        }
    }
}
