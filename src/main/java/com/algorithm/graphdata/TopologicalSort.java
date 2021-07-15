package com.algorithm.graphdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TopologicalSort {

    public static void main(String[] args) {
        int[][] edges = new int[][] {{4, 2}, {4, 3}, {2, 0}, {2, 1}, {3, 1}};
        int n = 5;
        List<Integer> res = new TopologicalSort().allValidPath(edges, n);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> allValidPath(int[][] edges, int n) {
        List<Integer> res = new ArrayList<>();

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] in = new int[n];

        for (int[] g : edges) {
            graph[g[0]].add(g[1]);
            in[g[1]]++;
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                q.offer(i);
                res.add(i);
            }
        }
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int e : graph[i]) {
                in[e]--;
                if (in[e] == 0) {
                    res.add(e);
                    q.offer(e);
                }
            }
        }
        if (res.size() != n) {
            return new ArrayList<>();
        }
        return res;
    }
}
