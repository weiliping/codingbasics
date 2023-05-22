package com.algorithm.greedyalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHammingDistanceII {

    public static void main(String[] args) {
        int[] source = new int[] { 5, 1, 2, 4, 3 };
        int[] target = new int[] { 1, 5, 4, 2, 3 };
        int[][] allowedSwaps = new int[][] { { 0, 4 }, { 4, 2 }, { 1, 3 }, { 1, 4 } };
        System.out.println(minimumHammingDistance(source, target, allowedSwaps));
    }

    private static void union(int[] arr, int i, int j) {
        int x = find(arr, i);
        int y = find(arr, j);
        if (x != y) {
            arr[y] = x;
        }
    }

    private static int find(int[] arr, int node) {
        if (arr[node] == node) {
            return node;
        }
        return find(arr, arr[node]);
    }

    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < allowedSwaps.length; i++) {
            int v = allowedSwaps[i][0];
            int u = allowedSwaps[i][1];
            union(parent, v, u);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int g = find(parent, i);
            if (!map.containsKey(g)) {
                map.put(g, new ArrayList<>());
            }
            map.get(g).add(i);
        }
        int res = 0;
        for (List<Integer> list: map.values()) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int idx: list) {
                cnt.put(source[idx], cnt.getOrDefault(source[idx], 0) + 1);
            }
            for (int idx:list) {
                if (cnt.containsKey(target[idx])) {
                    cnt.put(target[idx], cnt.getOrDefault(target[idx], 1) - 1);
                    if (cnt.get(target[idx]) == 0) {
                        cnt.remove(target[idx]);
                    }
                }
            }
            for (int v: cnt.values()) {
                res += v;
            }
        }
        return res;
    }
}
