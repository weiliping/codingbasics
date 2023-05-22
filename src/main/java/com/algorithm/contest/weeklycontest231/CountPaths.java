package com.algorithm.contest.weeklycontest231;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountPaths {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][] { { 1, 2, 3 }, { 1, 3, 3 }, { 2, 3, 1 }, { 1, 4, 2 }, { 5, 2, 2 }, { 3, 5, 1 },
                { 5, 4, 10 } };
        System.out.println(new CountPaths().countRestrictedPaths(n, edges));
    }

    static final int MOD = (int) 1e9 + 7;
    public int countRestrictedPaths(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[n] = 0;
        boolean[] visit = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});
        visit[n] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            visit[curr[0]] = false;

            for (int[] next : graph[curr[0]]) {
                if (dis[next[0]] == Integer.MAX_VALUE || dis[curr[0]] + next[1] < dis[next[0]]) {
                    dis[next[0]] = dis[curr[0]] + next[1];
                    if (!visit[next[0]]) {
                        visit[next[0]] = true;
                        queue.offer(new int[]{next[0], dis[next[0]]});
                    }
                }
            }
        }

        int[] res = new int[n + 1];
        Arrays.fill(res, -1);
        return dfs(res, 1, n, graph, dis);
    }

    int dfs(int[] res, int curr, int n, List<int[]>[] graph, int[] dis) {
        if (curr == n) {
            return 1;
        }

        if (res[curr] >= 0) {
            return res[curr];
        }
        int cnt = 0;
        for (int[] next : graph[curr]) {
            if (dis[curr] > dis[next[0]]) {
                cnt += dfs(res, next[0], n, graph, dis);
                cnt = cnt % MOD;
            }
        }
        res[curr] = cnt;
        return cnt;
    }
}
