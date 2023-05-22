package com.algorithm.graphdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {

    /**
     * #310
     * https://leetcode-cn.com/problems/minimum-height-trees/
     * @param args
     */
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][] { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
        System.out.println(Arrays.toString(findMinHeightTrees(n, edges).toArray()));
        System.out.println(Arrays.toString(findMinHeightTreesII(n, edges).toArray()));
    }

    static List<Integer> findMinHeightTreesII(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<Set<Integer>> graph = new ArrayList<>(n);
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] a : edges) {
            graph.get(a[1]).add(a[0]);
            graph.get(a[0]).add(a[1]);
        }

        for (int i = 0; i < n; ++i) {
            if (graph.get(i).size() == 1) {
                queue.offer(i);
            }
        }

        while (n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int t = queue.poll();
                for (Integer a : graph.get(t)) {
                    graph.get(a).remove(t);
                    if (graph.get(a).size() == 1) {
                        queue.offer(a);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] a : edges) {
            graph.get(a[1]).add(a[0]);
            graph.get(a[0]).add(a[1]);
        }

        List<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (int i : leaves) {
                int t = graph.get(i).iterator().next();
                graph.get(t).remove(i);
                if (graph.get(t).size() == 1) {
                    newLeaves.add(t);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
