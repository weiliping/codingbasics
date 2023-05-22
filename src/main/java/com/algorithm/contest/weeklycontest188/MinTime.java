package com.algorithm.contest.weeklycontest188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTime {

    public static void main(String[] args) {
        MinTime m = new MinTime();
        List<Boolean> hasApple = new ArrayList<>();
        hasApple.add(false);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(true);
        hasApple.add(false);
        int n = 7, edges[][] = new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        System.out.println(m.minTime(n, edges, hasApple));

        List<Boolean> hasApple1 = new ArrayList<>();
        hasApple1.add(true);
        hasApple1.add(true);
        hasApple1.add(true);
        hasApple1.add(true);
        int n1 = 4, edges1[][] = new int[][]{{0,1},{1,2},{0, 3}};
        System.out.println(m.minTime(n1, edges1, hasApple1));

        List<Boolean> hasApple2 = new ArrayList<>();
        hasApple2.add(false);
        hasApple2.add(true);
        hasApple2.add(false);
        hasApple2.add(false);
        int n2 = 4, edges2[][] = new int[][]{{0,2},{0,3},{1, 2}};
        System.out.println(m.minTime(n2, edges2, hasApple2));
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        parents[0] = -1;
        int m = edges.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int[] e = edges[i];
            parents[e[1]] = e[0];
            graph[e[1]].add(e[0]);
            graph[e[0]].add(e[1]);
        }

        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (hasApple.get(i)) {
                if (parents[i] == -1) {
                    parents[i] = graph[i].get(0);
                }
                visited[i] = true;
                int s = find(parents, i, visited);
                cnt += s;
            }
        }
        return cnt << 1;
    }

    static int find(int[] parents, int x, boolean[] visited) {
        int i = 1;
        while (parents[x] > 0) {
            int t = parents[x];
            if (!visited[t]) {
                visited[t] = true;
                i++;
            }
            parents[x] = 0;
            x = t;
        }
        return i;
    }
}
