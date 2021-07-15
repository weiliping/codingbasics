package com.algorithm.contest.weeklycontest223;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumHammingDistance {

    /**
     * #1722
     * https://leetcode-cn.com/problems/minimize-hamming-distance-after-swap-operations/
     * @param args
     */
    public static void main(String[] args) {
        int[] source = new int[] { 1, 2, 3, 4 };
        int[] target = new int[] { 2, 1, 4, 5 };
        int[][] allowedSwaps = new int[][] { { 0, 1 }, { 2, 3 } };
        System.out.println(minimumHammingDistance(source, target, allowedSwaps));

        int[] source1 = new int[] { 1, 2, 3, 4 };
        int[] target1 = new int[] { 1, 3, 2, 4 };
        int[][] allowedSwaps1 = new int[][]{};
        System.out.println(minimumHammingDistance(source1, target1, allowedSwaps1));

        int[] source3 = new int[] { 5, 1, 2, 4, 3 };
        int[] target3 = new int[] { 1, 5, 4, 2, 3 };
        int[][] allowedSwaps3 = new int[][] { { 0, 4 }, { 4, 2 }, { 1, 3 }, { 1, 4 } };
        System.out.println(minimumHammingDistance(source3, target3, allowedSwaps3));
    }

    static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = target.length, cnt = 0;
        if (allowedSwaps == null || allowedSwaps.length == 0) {
            for (int i = 0; i < n; i++) {
                if (source[i] != target[i]) {
                    cnt++;
                }
            }
            return cnt;
        }
        int[] parent = new int[n];
        Arrays.setAll(parent, i -> i);
        for (int[] a : allowedSwaps) {
            union(parent, a[0], a[1]);
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int g = find(parent, i);
            if (!map.containsKey(g)) {
                map.put(g, new HashSet<>());
            }
            map.get(g).add(i);
        }

        for (Set<Integer> r : map.values()) {
            cnt += hammingDistance(source, target, r);
        }
        return cnt;
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

    static int hammingDistance(int[] source, int[] target, Set<Integer> r) {
        Map<Integer, Integer> s = new HashMap<>();
        for (int i : r) {
            Integer num = s.getOrDefault(source[i], 0);
            s.put(source[i], num + 1);
        }
        int cnt = 0;
        for (int i : r) {
            if (s.containsKey(target[i])) {
                Integer n = s.get(target[i]);
                if (n == 1) {
                    s.remove(target[i]);
                } else {
                    s.put(target[i], n - 1);
                }
            }
        }
        for (Integer i : s.values()) {
            cnt += i;
        }
        return cnt;
    }
}
