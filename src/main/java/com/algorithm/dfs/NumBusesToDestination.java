package com.algorithm.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class NumBusesToDestination {

    /**
     * #815
     * https://leetcode-cn.com/problems/bus-routes
     * @param args
     */
    public static void main(String[] args) {
//        int[][] routes = new int[][] { { 1, 9, 12, 20, 23, 24, 35, 38 }, { 10, 21, 24, 31, 32, 34, 37, 38, 43 },
//                { 10, 19, 28, 37 }, { 8 }, { 14, 19 }, { 11, 17, 23, 31, 41, 43, 44 }, { 21, 26, 29, 33 },
//                { 5, 11, 33, 41 }, { 4, 5, 8, 9, 24, 44 } };
//        int S = 37, T = 28;
        int[][] routes = new int[][] { { 1, 2, 7 }, { 3, 6, 7 } };
        int S = 1, T = 6;
        System.out.println(numBusesToDestinationIII(routes, S, T));
    }

    public static int numBusesToDestinationIII(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        int N = routes.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isJoin(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        Set<Integer> targets = new HashSet<>();
        Queue<Point> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < N; i++) {
            if (Arrays.binarySearch(routes[i], S) > -1) {
                visited.add(i);
                queue.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], T) > -1) {
                targets.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.remove();

            if (targets.contains(p.x)) {
                return p.y + 1;
            }

            for (int l : graph.get(p.x)) {
                if (!visited.contains(l)) {
                    visited.add(l);
                    queue.offer(new Point(l, p.y + 1));
                }
            }
        }

        return -1;
    }

    public static boolean isJoin(int[] s1, int[] s2) {
        int i = 0, j = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i] == s2[j]) {
                return true;
            }

            if (s1[i] > s2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return false;
    }

    public static int numBusesToDestinationII(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        int N = routes.length;

        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < N; ++i) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList());
        }
        Set<Integer> seen = new HashSet();
        Set<Integer> targets = new HashSet();
        Queue<Point> queue = new ArrayDeque();

        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            if (Arrays.binarySearch(routes[i], S) >= 0) {
                seen.add(i);
                queue.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], T) >= 0) {
                targets.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Point info = queue.poll();
            int node = info.x, depth = info.y;
            if (targets.contains(node)) {
                return depth + 1;
            }
            for (Integer nei : graph.get(node)) {
                if (!seen.contains(nei)) {
                    seen.add(nei);
                    queue.offer(new Point(nei, depth + 1));
                }
            }
        }

        return -1;
    }

    static boolean intersect(int[] A, int[] B) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                return true;
            }
            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        int totalLines = routes.length;
        HashMap<Integer, ArrayList<Integer>> states = new HashMap<>();
        for (int i = 0; i < totalLines; i++) {
            for (int state : routes[i]) {
                ArrayList<Integer> lines = states.getOrDefault(state, new ArrayList<>());
                lines.add(i);
                states.put(state, lines);
            }
        }
        ArrayList<Integer> out = new ArrayList<>();
        boolean[] visitedLines = new boolean[totalLines];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(states, routes, S, T, out, res, visitedLines);
        int min = res.size() > 0 ? Integer.MAX_VALUE : 1;
        for (List<Integer> r : res) {
            min = Math.min(min, r.size());
        }
        return min;
    }

    static void dfs(HashMap<Integer, ArrayList<Integer>> states, int[][] routes, int s, int t,
            ArrayList<Integer> out, ArrayList<ArrayList<Integer>> res,
            boolean[] visitedLines) {
        if (s == t) {
            res.add(new ArrayList<>(out));
            return;
        }
        if (states.get(s) != null) {
            for (int l : states.get(s)) {
                if (!visitedLines[l]) {
                    visitedLines[l] = true;
                    out.add(l);
                    for (int r : routes[l]) {
                        if (s != r) {
                            dfs(states, routes, r, t, out, res, visitedLines);
                        }
                    }
                    out.remove(out.size() - 1);
                    visitedLines[l] = false;
                }
            }
        }
    }
}
