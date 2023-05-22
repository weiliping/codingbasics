package com.algorithm.contest.weeklycontest324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsPossible {

    public static void main(String[] args) {
        // int n = 5;
        // List<List<Integer>> edges = new ArrayList<>();
        // edges.add(Arrays.asList(1, 2));
        // edges.add(Arrays.asList(2, 3));
        // edges.add(Arrays.asList(3, 4));
        // edges.add(Arrays.asList(4, 2));
        // edges.add(Arrays.asList(1, 4));
        // edges.add(Arrays.asList(2, 5));
        // System.out.println(isPossible(n, edges));

        // int n2 = 5;
        // List<List<Integer>> edges2 = new ArrayList<>();
        // edges2.add(Arrays.asList(1, 2));
        // edges2.add(Arrays.asList(3, 4));
        // System.out.println(isPossible(n2, edges2));

        int n3 = 21;
        List<List<Integer>> edges3 = new ArrayList<>();
        Integer[][] nums = new Integer[][] { { 2, 19 }, { 16, 17 }, { 8, 14 }, { 2, 16 }, { 12, 20 }, { 12, 14 },
                { 16, 18 }, { 15, 16 }, { 10, 21 }, { 3, 5 }, { 13, 18 }, { 17, 20 }, { 14, 17 }, { 9, 12 }, { 5, 15 },
                { 5, 6 }, { 3, 7 }, { 2, 21 }, { 10, 13 }, { 8, 16 }, { 7, 18 }, { 4, 6 }, { 9, 1 }, { 13, 21 },
                { 18, 20 }, { 7, 14 }, { 4, 19 }, { 5, 8 }, { 3, 11 }, { 11, 1 }, { 7, 12 }, { 4, 7 }, { 3, 16 },
                { 13, 17 }, { 17, 19 }, { 9, 13 }, { 7, 19 }, { 10, 16 }, { 4, 13 }, { 4, 5 }, { 2, 15 }, { 12, 19 },
                { 11, 16 }, { 2, 9 }, { 11, 17 }, { 17, 1 }, { 16, 21 }, { 4, 10 }, { 10, 14 }, { 14, 16 }, { 4, 1 },
                { 13, 20 }, { 5, 20 }, { 4, 14 }, { 4, 21 }, { 10, 20 }, { 2, 14 }, { 8, 15 }, { 4, 8 }, { 6, 19 },
                { 15, 1 }, { 19, 1 }, { 8, 19 }, { 15, 21 }, { 3, 12 }, { 11, 18 }, { 9, 17 }, { 18, 19 }, { 7, 21 },
                { 3, 21 }, { 16, 19 }, { 11, 15 }, { 5, 1 }, { 8, 17 }, { 3, 15 }, { 8, 1 }, { 10, 19 }, { 3, 8 },
                { 6, 16 }, { 2, 8 }, { 5, 18 }, { 11, 13 }, { 11, 20 }, { 14, 21 }, { 6, 20 }, { 4, 20 }, { 12, 13 },
                { 5, 12 }, { 10, 11 }, { 9, 15 }, { 3, 19 }, { 9, 20 }, { 14, 18 }, { 21, 1 }, { 13, 19 }, { 8, 21 },
                { 2, 13 }, { 3, 10 }, { 9, 18 }, { 19, 21 }, { 6, 7 }, { 3, 18 }, { 2, 18 }, { 6, 14 }, { 3, 17 },
                { 5, 21 }, { 14, 20 }, { 8, 9 }, { 16, 1 }, { 3, 4 }, { 13, 1 }, { 5, 9 }, { 4, 15 }, { 17, 21 },
                { 20, 21 }, { 2, 17 }, { 13, 14 }, { 11, 14 }, { 9, 16 }, { 10, 18 }, { 6, 15 }, { 6, 12 }, { 3, 13 },
                { 5, 11 }, { 6, 1 }, { 12, 17 }, { 8, 10 }, { 5, 10 }, { 8, 18 }, { 4, 12 }, { 10, 1 }, { 6, 13 },
                { 4, 18 }, { 7, 20 }, { 7, 16 }, { 2, 6 }, { 12, 21 }, { 4, 17 }, { 15, 18 }, { 13, 16 }, { 15, 20 },
                { 7, 10 }, { 6, 10 }, { 2, 20 }, { 7, 15 }, { 18, 1 }, { 12, 1 }, { 3, 20 }, { 7, 1 }, { 14, 15 },
                { 4, 9 }, { 11, 19 }, { 7, 9 }, { 5, 17 }, { 18, 21 }, { 6, 21 }, { 8, 11 }, { 6, 17 }, { 3, 14 },
                { 7, 11 }, { 5, 7 }, { 7, 13 }, { 6, 8 }, { 6, 9 }, { 10, 12 }, { 5, 16 }, { 2, 4 }, { 17, 18 },
                { 9, 11 }, { 12, 16 }, { 3, 6 }, { 12, 18 }, { 3, 9 }, { 11, 12 }, { 14, 19 }, { 10, 15 }, { 5, 13 },
                { 8, 13 }, { 15, 17 }, { 2, 10 }, { 11, 21 }, { 20, 1 }, { 6, 18 }, { 2, 12 }, { 19, 20 }, { 6, 11 },
                { 8, 12 }, { 2, 3 }, { 12, 15 }, { 2, 11 }, { 9, 10 }, { 7, 17 }, { 9, 19 }, { 13, 15 }, { 7, 8 },
                { 4, 11 }, { 2, 5 }, { 5, 19 }, { 16, 20 }, { 15, 19 }, { 9, 14 }, { 14, 1 }, { 10, 17 }, { 9, 21 },
                { 2, 7 }, { 8, 20 }, { 5, 14 }, { 4, 16 } };
        for (Integer[] num : nums) {
            List<Integer> a = Arrays.asList(num);
            edges3.add(a);
        }
        System.out.println(isPossible(n3, edges3));
        int n4 = 5;
        List<List<Integer>> edges4 = new ArrayList<>();
        edges4.add(Arrays.asList(2, 3));
        edges4.add(Arrays.asList(5, 1));
        edges4.add(Arrays.asList(5, 4));
        edges4.add(Arrays.asList(3, 4));
        edges4.add(Arrays.asList(2, 4));
        edges4.add(Arrays.asList(1, 2));
        edges4.add(Arrays.asList(2, 5));
        System.out.println(isPossible(n4, edges4));
    }

    public static boolean isPossible(int n, List<List<Integer>> edges) {
        int[] inDegrees = new int[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> e : edges) {
            inDegrees[e.get(0)]++;
            inDegrees[e.get(1)]++;
            graph[e.get(0)].add(e.get(1));
            graph[e.get(1)].add(e.get(0));
        }

        int cnt = 0;
        int[] indes = new int[4];
        Arrays.fill(indes, -1);
        for (int i = 1; i <= n; i++) {
            if ((inDegrees[i] & 1) != 0) {
                if (cnt >= 4) {
                    return false;
                }
                indes[cnt++] = i;
            }
        }

        if (cnt == 0) {
            return true;
        }

        if ((cnt & 1) != 0) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (indes[i] != -1 && inDegrees[indes[i]] == n - 1) {
                return false;
            }
        }
        if (cnt == 4) {
            if (!graph[indes[0]].contains(Integer.valueOf(indes[1])) &&
                    !graph[indes[2]].contains(Integer.valueOf(indes[3]))) {
                return true;
            }
            if (!graph[indes[0]].contains(Integer.valueOf(indes[2])) &&
                    !graph[indes[1]].contains(Integer.valueOf(indes[3]))) {
                return true;
            }
            if (!graph[indes[0]].contains(Integer.valueOf(indes[3])) &&
                    !graph[indes[1]].contains(Integer.valueOf(indes[2]))) {
                return true;
            }
        }
        if (cnt == 2) {
            if (!graph[indes[0]].contains(Integer.valueOf(indes[1]))) {
                return true;
            }
            for (int i = 1; i <= n; i++) {
                if (inDegrees[i] <= n - 3 &&
                        !graph[i].contains(Integer.valueOf(indes[0])) &&
                        !graph[i].contains(Integer.valueOf(indes[1]))) {
                    return true;
                }
            }
        }
        return false;
    }
}
