package com.algorithm.selfpractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortestBridge {

    public static void main(String[] args) {
        ShortestBridge s = new ShortestBridge();
        int[][] is = new int[][] {{0,1,0}, {0,0,0},{0,0,1}};
        System.out.println(s.shortestBridge(is));
        int[][] a = new int[][] {{1,1,1,1,1}, {1,0,0,0,1}, {1,0,1,0,1}, {1,0,0,0,1}, {1,1,1,1,1}};
        System.out.println(s.shortestBridge(a));
    }

    public int shortestBridge(int[][] A) {
        int n = A.length, m = A[0].length;

        int[][] colors = countIslands(A);
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        Set<Integer> target = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (colors[i][j] == 1) {
                    queue.offer(new int[] {i, j, 0});
                    continue;
                }
                if (colors[i][j] == 2) {
                    target.add(i * m + j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] t = queue.poll();

            int k = t[0] * m + t[1];
            if (target.contains(k)) {
                return t[2] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int di = t[0] + DIRS[i][0];
                int dj = t[1] + DIRS[i][1];

                if (di >= 0 && di < n && dj >= 0 && dj < m) {
                    if (colors[di][dj] != 1) {
                        queue.offer(new int[]{di, dj, t[2] + 1});
                        colors[di][dj] = 1;
                    }
                }
            }
        }
        return -1;
    }

    static final int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int[][] countIslands(int[][] islands) {
        int n = islands.length, m = islands[0].length;
        int[][] colors = new int[n][m];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int islandCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (islands[i][j] == 1 && colors[i][j] == 0) {
                    colors[i][j] = ++islandCnt;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] t = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int dI = t[0] + DIRS[k][0];
                            int dJ = t[1] + DIRS[k][1];

                            if (dI >= 0 && dI < n && dJ >= 0 && dJ < m) {
                                if (islands[dI][dJ] == 1 && colors[dI][dJ] == 0) {
                                    colors[dI][dJ] = islandCnt;
                                    queue.offer(new int[] { dI, dJ });
                                }
                            }
                        }
                    }
                }
            }
        }
        return colors;
    }
}
