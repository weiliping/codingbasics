package com.algorithm.contest.weeklycontest164;

public class CountServers {
    public static void main(String[] args) {
        CountServers c = new CountServers();
        int grid[][] = new int[][] {{1,0},{0,1}};
        System.out.println(c.countServers(grid));

        int grid1[][] = new int[][] {{1,0},{1,1}};
        System.out.println(c.countServers(grid1));

        int grid2[][] = new int[][] {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(c.countServers(grid2));

        int grid3[][] = new int[][] {{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}};
        System.out.println(c.countServers(grid3));
    }
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m], col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
