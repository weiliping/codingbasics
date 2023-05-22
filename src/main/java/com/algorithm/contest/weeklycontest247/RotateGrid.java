package com.algorithm.contest.weeklycontest247;

import java.util.Arrays;

public class RotateGrid {

    public static void main(String[] args) {
        //        int n = 10, m = 8, k = 12;
        //        int[][] grid = new int[n][m];
        //
        //        for (int i = 0; i < n; i++) {
        //            for (int j = 0; j < m; j++) {
        //                grid[i][j] = i * m + j + 1;
        //            }
        //        }
        //
        //        int[][] rotGrid = rotateGrid(grid, k);
        //        for (int[] r : rotGrid) {
        //            System.out.println(Arrays.toString(r));
        //        }

        int[][] grid1 = new int[][] {{40, 10}, {30, 20}};
        int[][] rotGrid = rotateGrid(grid1, 1);
        for (int[] r : rotGrid) {
            System.out.println(Arrays.toString(r));
        }
    }

    public static int[][] rotateGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int round = Math.min(n, m) / 2, j = 0;
        int rs = 0, re = n - 1, cs = 0, ce = m - 1;
        while (round > j) {
            int i = 0;
            int len = 2 * (m + n - 2 * (2 * j + 1)) ;
            int[][] nums = new int[len][3];
            for (int ci = cs; ci <= ce; ci++) {
                nums[i++] = new int[] {rs, ci, grid[rs][ci]};
            }
            rs++;

            for (int ri = rs; ri <= re; ri++) {
                nums[i++] = new int[] {ri, ce, grid[ri][ce]};
            }
            ce--;

            if (cs <= ce) {
                for (int ci = ce; ci >= cs; ci--) {
                    nums[i++] = new int[] {re, ci, grid[re][ci]};
                }
                re--;
            }

            if (rs <= re) {
                for (int ri = re; ri >= rs; ri--) {
                    nums[i++] = new int[] {ri, cs, grid[ri][cs]};
                }
                cs++;
            }
            int kk = k % len;
            for (int ind = 0; ind < len; ind++) {
                int[] inds = nums[ind];
                int valInd = (ind + kk) % len;
                grid[inds[0]][inds[1]] = nums[valInd][2];
            }
            j++;
        }
        return grid;
    }
}
