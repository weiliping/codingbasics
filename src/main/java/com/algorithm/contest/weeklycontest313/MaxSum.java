package com.algorithm.contest.weeklycontest313;

public class MaxSum {
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 6, 2, 1, 3 }, { 4, 2, 1, 5 }, { 9, 2, 8, 7 }, { 4, 1, 2, 9 } };
        System.out.println(maxSum(grid));
    }

    public static int maxSum(int[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int sum = grid[i][j];
                sum += grid[i - 1][j];
                sum += grid[i - 1][j - 1];
                sum += grid[i - 1][j + 1];
                sum += grid[i + 1][j];
                sum += grid[i + 1][j - 1];
                sum += grid[i + 1][j + 1];
                if (res < sum) {
                    res = sum;
                }
            }
        }
        return res;
    }
}
