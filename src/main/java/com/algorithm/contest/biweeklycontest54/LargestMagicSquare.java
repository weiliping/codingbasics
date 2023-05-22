package com.algorithm.contest.biweeklycontest54;

public class LargestMagicSquare {
    public static void main(String[] args) {
        LargestMagicSquare l = new LargestMagicSquare();
        int[][] grid = new int[][] {
                { 7, 1, 4, 5, 6 },
                { 2, 5, 1, 6, 4 },
                { 1, 5, 4, 3, 2 },
                { 1, 2, 7, 3, 4 } };
        System.out.println(l.largestMagicSquare(grid));

        int[][] grid2 = new int[][] { { 5, 1, 3, 1 }, { 9, 3, 3, 1 }, { 1, 3, 3, 8 } };
        System.out.println(l.largestMagicSquare(grid2));
    }

    public int largestMagicSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] sumCol = new int[n][m + 1];
        int[][] sumRow = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumCol[i][j + 1] = sumCol[i][j] + grid[i][j];
                sumRow[i + 1][j] = sumRow[i][j] + grid[i][j];
            }
        }

        int k = Math.min(n, m);
        while (k > 1) {
            for (int i = 0; i + k - 1 < n; i++) {
                for (int j = 0; j + k - 1 < m; j++) {
                    if (isMagicSquare(grid, sumCol, sumRow, i, j, k)) {
                        return k;
                    }
                }
            }
            k--;
        }
        return k;
    }

    static boolean isMagicSquare(int[][] grid, int[][] sumCol, int[][] sumRow, int i, int j, int k) {
        int sum = sumCol[i][j + k] - sumCol[i][j];
        if (sum != sumRow[i + k][j] - sumRow[i][j]) {
            return false;
        }
        for (int m = 0; m < k; m++) {
            if (sum != sumCol[i + m][j + k] - sumCol[i + m][j]) {
                return false;
            }
        }
        for (int n = 1; n < k; n++) {
            if (sum != sumRow[i + k][j + n] - sumRow[i][j + n]) {
                return false;
            }
        }

        int s = 0;
        for (int in = 0; in < k; in++) {
            s += grid[i + in][j + in];
        }

        if (sum != s) {
            return false;
        }

        s = 0;
        int maxJ = j + k - 1;
        for (int in = k - 1; in >= 0; in--) {
            s += grid[i + in][maxJ - in];
        }

        if (sum != s) {
            return false;
        }
        return true;
    }
}
