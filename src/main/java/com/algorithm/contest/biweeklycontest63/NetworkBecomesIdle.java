package com.algorithm.contest.biweeklycontest63;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NetworkBecomesIdle {

    public static void main(String[] args) {
        NetworkBecomesIdle n = new NetworkBecomesIdle();
        int[][] edges = new int[][]{{0, 1}, {1, 2}};
        int[] patience = new int[] {0, 2, 1};

        System.out.println(n.networkBecomesIdle(edges, patience));
        int[][] edges1 = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        int[] patience1 = new int[] {0, 10, 10};

        System.out.println(n.networkBecomesIdle(edges1, patience1));
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] visiteds = new boolean[n];
        visiteds[0] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int cnt = 1, res = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int p = queue.poll(), time = (cnt << 1);
                for (int child : graph[p]) {
                    if (!visiteds[child]) {
                        visiteds[child] = true;
                        int pat = patience[child];
                        if (time <= pat) {
                            if (res < time) {
                                res = time;
                            }
                        } else {
                            int t = time / pat;
                            if (time % pat == 0) {
                                t--;
                            }
                            int s = t * pat + time;
                            if (res < s) {
                                res = s;
                            }
                        }
                        queue.offer(child);
                    }
                }
            }
            cnt++;
        }
        return res + 1;
    }

}
