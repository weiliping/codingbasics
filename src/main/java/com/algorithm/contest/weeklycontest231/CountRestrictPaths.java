package com.algorithm.contest.weeklycontest231;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountRestrictPaths {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][] { { 1, 2, 3 }, { 1, 3, 3 }, { 2, 3, 1 }, { 1, 4, 2 }, { 5, 2, 2 }, { 3, 5, 1 },
                { 5, 4, 10 } };
        System.out.println(new CountRestrictPaths().countRestrictedPaths(n, edges));
//        int n2 = 10;
//        int[][] edges2 = new int[][] { { 4, 10, 6 }, { 10, 5, 8 }, { 8, 4, 8 }, { 9, 3, 3 }, { 4, 6, 2 }, { 5, 1, 9 },
//                { 1, 4, 6 }, { 2, 9, 2 }, { 5, 9, 9 }, { 2, 6, 3 }, { 6, 10, 3 }, { 7, 2, 3 }, { 3, 6, 3 },
//                { 1, 10, 6 }, { 1, 6, 5 }, { 7, 5, 2 }, { 4, 7, 9 }, { 10, 2, 10 } };
//        System.out.println(new CountRestrictPaths().countRestrictedPaths(n2, edges2));
    }

    int mod = 1000000007;
    public int countRestrictedPaths(int n, int[][] edges) {
        double[] distance = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        ArrayList<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new Pair(edge[1], edge[2]));
            graph[edge[1]].add(new Pair(edge[0], edge[2]));
        }
        distance[n] = 0;
        boolean[] vis = new boolean[n + 1];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(n, 0));
        vis[n] = true;
        Pair cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            vis[cur.dis] = false;
            for (Pair next : graph[cur.dis]) {
                if (distance[next.dis] == Integer.MAX_VALUE || distance[cur.dis] + next.weight < distance[next.dis]) {
                    distance[next.dis] = distance[cur.dis] + next.weight;
                    if (!vis[next.dis]) {
                        vis[next.dis] = true;
                        queue.offer(new Pair(next.dis, distance[next.dis]));
                    }
                }
            }
        }
        ArrayList<Integer>[] graph2 = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph2[i] = new ArrayList<>();
        }
        int[] ans = new int[n + 1];
        ans[1] = 1;
        int[] count = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis = new boolean[n + 1];
        vis[1] = true;
        int current;
        while (!q.isEmpty()) {
            current = q.poll();
            for (Pair next : graph[current]) {
                if (distance[next.dis] < distance[current]) {
                    graph2[current].add(next.dis);
                    count[next.dis]++;
                    if (!vis[next.dis]) {
                        vis[next.dis] = true;
                        q.offer(next.dis);
                    }
                }
            }
        }
        q.offer(1);
        while (!q.isEmpty()) {
            current = q.poll();
            for (int next : graph2[current]) {
                ans[next] = (ans[next] + ans[current]) % mod;
                count[next]--;
                if (count[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return ans[n];
    }
}

class Pair {
    int dis;
    double weight;

    public Pair(int dis, double weight) {
        this.dis = dis;
        this.weight = weight;
    }
}
