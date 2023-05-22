package com.algorithm.contest.weeklycontest163;

import static com.algorithm.utils.CommonUtils.printArrayInteger;

import java.util.ArrayList;
import java.util.List;

public class ShiftGrid {
    public static void main(String[] args) {
        ShiftGrid s = new ShiftGrid();
        int grid1[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, k = 1;
        List<List<Integer>> res = s.shiftGrid(grid1, k);
        printArrayInteger(res);
        int grid2[][] = new int[][] { { 3, 8, 1, 9 }, { 19, 7, 2, 5 }, { 4, 6, 11, 10 }, { 12, 0, 21, 13 } }, k2 = 4;
        List<List<Integer>> res2 = s.shiftGrid(grid2, k2);
        printArrayInteger(res2);
        int grid3[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, k3 = 9;
        List<List<Integer>> res3 = s.shiftGrid(grid3, k3);
        printArrayInteger(res3);
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int t = m * n;
        k = k % t;
        if (k == 0) {
            return toArray(grid);
        }

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int p = j + k;
                int ii = (i + p / n) % m;
                int jj = p % n;
                dp[ii][jj] = grid[i][j];
            }
        }

        return toArray(dp);
    }

    List<List<Integer>> toArray(int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] g : grid) {
            List<Integer> sub = new ArrayList<>();
            for (int a : g) {
                sub.add(a);
            }
            res.add(sub);
        }
        return res;
    }
}
