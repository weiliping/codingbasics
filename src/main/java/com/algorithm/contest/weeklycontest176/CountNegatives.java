package com.algorithm.contest.weeklycontest176;

public class CountNegatives {
    public static void main(String[] args) {
        CountNegatives c = new CountNegatives();
        int[][] grid = new int[][] {{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}};
        System.out.println(c.countNegatives(grid));

        int[][] grid1 = new int[][] {{3,2}, {1,0}};
        System.out.println(c.countNegatives(grid1));

        int[][] grid2 = new int[][] {{1,-1}, {-1,-1}};
        System.out.println(c.countNegatives(grid2));

        int[][] grid3 = new int[][] {{-1}};
        System.out.println(c.countNegatives(grid3));
    }

    public int countNegatives(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (grid[i][m - 1] >= 0) {
                break;
            }
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] >= 0) {
                    break;
                }
                cnt++;
            }
        }
        return cnt;
    }
}
