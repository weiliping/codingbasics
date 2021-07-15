package com.algorithm.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class OrangesRotting {
   static int[] dr = new int[] { -1, 0, 1, 0 };
   static int[] dc = new int[] { 0, -1, 0, 1 };

    /**
     * #994
     * https://leetcode-cn.com/problems/rotting-oranges/solution/fu-lan-de-ju-zi-by-leetcode-solution/
     * @param args
     */
    public static void main(String[] args) {
//                int[][] grid = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
//                int[][] grid = new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
//                int[][] grid = new int[][] { {1, 2}};
//        int[][] grid = new int[][] { { 1 } };
//        int[][] grid = new int[][] { { 0 } };
//        int[][] grid = new int[][] { { 0, 2, 2 } };
        int[][] grid = new int[][] { { 2, 2, 2, 1, 1 } };
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRottingBfs(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    int idx = i * C + j;
                    queue.offer(idx);
                    depth.put(idx, 0);
                }
            }
        }
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            Integer idx = queue.remove();
            int r = idx / C, c = idx % C;

            for (int k = 0; k < 4; k++) {
                int i = r + dr[k];
                int j = c + dc[k];

                if (i >= 0 && i < R && j >= 0 && j < C && grid[i][j] == 1) {
                    grid[i][j] = 2;
                    int indx = i * C + j;
                    queue.offer(indx);
                    maxDepth = depth.get(idx) + 1;
                    depth.put(indx, maxDepth);
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return maxDepth;
    }

    public static int orangesRotting(int[][] grid) {
        List<int[]> starts = new ArrayList<>();
        int s = grid.length, l = grid[0].length;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < l; j++) {
                if (grid[i][j] == 2) {
                    starts.add(new int[] { i, j });
                }
            }
        }

        boolean[] visited = new boolean[s * l];
        int[] returnRes = new int[s * l];
        int maxDepth = Integer.MIN_VALUE;

        for (int[] idx : starts) {
            dfs(grid, visited, returnRes, idx[0], idx[1], s, l, -1);
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && grid[i / l][i % l] == 1) {
                return -1;
            }
            maxDepth = Math.max(maxDepth, returnRes[i]);
        }
        if (maxDepth == Integer.MIN_VALUE) {
            return 0;
        }
        return maxDepth;
    }

    static int toSingleIndex (int i, int j, int cLen) {
        return i * cLen + j;
    }

    static void dfs(int[][] grid, boolean[] visited, int[] res, int i, int j, int rLen, int cLen, int pIndx) {
        int idx = toSingleIndex(i, j, cLen);
        if (!visited[idx]) {
            visited[idx] = true;
            if (pIndx < 0) {
                res[idx] = 0;
            } else {
                res[idx] = res[pIndx] + 1;
            }
            if (i > 0 && grid[i - 1][j]  == 1) {
                dfs(grid, visited, res, i - 1, j, rLen, cLen, idx);
            }

            if (i + 1 < rLen && grid[i + 1][j] == 1) {
                dfs(grid, visited, res,i + 1, j, rLen, cLen, idx);
            }

            if (j > 0 && grid[i][j - 1]  == 1) {
                dfs(grid, visited, res, i, j - 1, rLen, cLen, idx);
            }

            if (j + 1 < cLen && grid[i][j + 1]  == 1) {
                dfs(grid, visited, res, i, j + 1, rLen, cLen, idx);
            }
        }
    }
}
