package com.algorithm.contest.weeklycontest191;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinReorder {
    public static void main(String[] args) {
        MinReorder m = new MinReorder();
        int n1 = 6, conn[][] = new int[][] {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(m.minReorder(n1, conn));
        int n2 = 5, conn2[][] = new int[][] {{1,0},{1,2},{3,2},{3,4}};
        System.out.println(m.minReorder(n2, conn2));
        int n3 = 3, conn3[][] = new int[][] {{1,0},{2,0}};
        System.out.println(m.minReorder(n3, conn3));
    }
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] conn : connections) {
            List<Integer> c = mp.getOrDefault(conn[0], new ArrayList<>());
            c.add(conn[1]);
            mp.put(conn[0], c);
            graph[conn[0]].add(conn[1]);
            graph[conn[1]].add(conn[0]);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            for (int child : graph[curr]) {
                if (visited[child]) {
                    continue;
                }
                queue.offer(child);
                List<Integer> parents = mp.get(child);
                if (parents == null || !parents.contains(curr)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
