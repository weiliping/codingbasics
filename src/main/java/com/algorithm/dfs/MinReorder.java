package com.algorithm.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinReorder {

    /**
     * #1466
     * https://leetcode-cn.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
     * @param args
     */
    public static void main(String[] args) {
//        int[][] conns = new int[][] { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
//        System.out.println(new MinReorder().minReorder(6, conns));
//        int[][] conns2 = new int[][] { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } };
//        System.out.println(new MinReorder().minReorder(5, conns2));
//        int[][] conns3 = new int[][] { { 1, 2 }, { 2, 0 }};
//        System.out.println(new MinReorder().minReorder(3, conns3));
        int[][] conns4 = new int[][] { { 4,3 }, { 2,3 }, {1, 2}, {1, 0}};
        System.out.println(new MinReorder().minReorder(5, conns4));
    }

    public int minReorder(int n, int[][] connections) {
        if (connections == null || connections.length == 0 || connections[0] == null || connections[0].length == 0) {
            return 0;
        }

        HashMap<Integer, List<Integer>> dirs = new HashMap<>();
        ArrayList<Integer>[] grah = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            grah[i] = new ArrayList<>();
        }
        int rLen = connections.length;

        for (int i = 0; i < rLen; i++) {
            int[] conn = connections[i];
            List<Integer> subDirs = dirs.getOrDefault(conn[0], new ArrayList<>());
            subDirs.add(conn[1]);
            dirs.put(conn[0], subDirs);
            grah[conn[0]].add(conn[1]);
            grah[conn[1]].add(conn[0]);
        }
        int[] res = new int[1];
        for (int i = 1; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(grah, i, visited, res, dirs);
        }
        return res[0];
    }

    static boolean dfs(ArrayList<Integer>[] grah, int start, boolean[] visited, int[] res,
            HashMap<Integer, List<Integer>> dirs) {
        if (!visited[start]) {
            visited[start] = true;
            for (Integer i : grah[start]) {
                if (i == 0 || dfs(grah, i, visited, res, dirs)) {
                    List<Integer> subRes = dirs.getOrDefault(start, new ArrayList<>());
                    if (!subRes.contains(i)) {
                        res[0]++;
                        subRes.add(i);
                        dirs.put(start, subRes);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
