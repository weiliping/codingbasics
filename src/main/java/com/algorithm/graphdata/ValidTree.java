package com.algorithm.graphdata;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ValidTree {
    public static void main(String[] args) {
        int n = 5;
//        int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
        System.out.println(validTreeDfs(n, edges));
    }

    public static boolean validTreeDfs(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[1]].add(e[0]);
            graph[e[0]].add(e[1]);
        }
        boolean[] visited = new boolean[n];

        if (!dfsHelper(graph, visited, 0 , 1)) {
            return false;
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    static boolean dfsHelper(ArrayList<Integer>[] graph, boolean[] visited, int pre, int i) {
        if (visited[i]) {
            return false;
        }
        visited[i] = true;
        for(Integer a : graph[i]) {
            if (a != pre && !dfsHelper(graph, visited, i, a)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validTree(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[1]].add(e[0]);
            graph[e[0]].add(e[1]);
        }
        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        res.add(0);
        queue.offer(0);

        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (Integer a : graph[t]) {
                if (res.contains(a)) {
                    return false;
                }
                res.add(a);
                queue.offer(a);
                graph[a].remove((Integer) t);
            }
        }
        return res.size() == n;
    }
}
