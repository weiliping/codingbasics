package com.algorithm.contest.weeklycontest173;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheCity {

    public static void main(String[] args) {
        FindTheCity f = new FindTheCity();
        int n = 4, edges[][] = new int[][] {{0,1,3}, {1,2,1}, {1,3,4}, {2,3,1}}, distanceThreshold = 4;
        System.out.println(f.findTheCity(n, edges, distanceThreshold));

        int n1 = 5, edges1[][] =
                new int[][] { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } },
                distanceThreshold1 = 2;
        System.out.println(f.findTheCity(n1, edges1, distanceThreshold1));

        int n2 = 6, e1[][] = new int[][] {{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}}, d1 = 20;

        System.out.println(f.findTheCity(n2, e1, d1));
        int n3 = 5, e2[][] = new int[][] {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}, d2 = 2;
        System.out.println(f.findTheCity(n3, e2, d2));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[][] weights = new int[n][n];
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
            weights[e[0]][e[1]] = e[2];
            weights[e[1]][e[0]] = e[2];
        }
        int cnt = Integer.MAX_VALUE, id = -1;
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            Arrays.fill(dist, -1);
            int ans = bfs(i, distanceThreshold, weights, graph, visited, dist, n);
            if (ans <= cnt) {
                cnt = ans;
                id = i;
            }
        }
        return id;
    }

    int bfs(int s, int distance, int[][] weights, List<Integer>[] graph, boolean[] visited, int[] dist, int n) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        visited[s] = true;
        dist[s] = 0;
        while(!queue.isEmpty()) {
            int r = queue.poll();
            for (int g : graph[r]) {
                if (dist[g] == -1 || dist[g] > weights[r][g] + dist[r]) {
                    dist[g] = weights[r][g] + dist[r];
                    if (!visited[g]) {
                        visited[g] = true;
                        queue.offer(g);
                    }
                }
            }
            visited[r] = false;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == -1) {
                continue;
            }
            if (dist[i] <= distance) {
                res++;
            }
        }
        return res;
    }
    void dfs(int i, int distance, int[][] weights, List<Integer>[] graph, boolean[] visited, int[] res, boolean[] set) {
        for (int c : graph[i]) {
            if (visited[c]){
                continue;
            }
            if (weights[i][c] <= distance) {
                visited[c] = true;
                if (!set[c]) {
                    set[c] = true;
                    res[0]++;
                }
                dfs(c, distance - weights[i][c], weights, graph, visited, res, set);
                visited[c] = false;
            }
        }
    }
}
