package com.algorithm.contest.weeklycontest221;

import java.util.Arrays;

public class FindBall {

    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,1,1,-1,-1}, {1,1,1,-1,-1}, {-1,-1,-1,1,1}, {1,1,1,1,-1}, {-1,-1,-1,-1,-1}};
        System.out.println(Arrays.toString(findBall(grid)));

        int[][] grid1 = new int[][] {{-1}};
        System.out.println(Arrays.toString(findBall(grid1)));

        int[][] grid2 = new int[][] {{1,1,1,1,1,1}, {-1,-1,-1,-1,-1,-1}, {1,1,1,1,1,1}, {-1,-1,-1,-1,-1,-1}};
        System.out.println(Arrays.toString(findBall(grid2)));
    }

    public static int[] findBall(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans[] = new int[m];
        for (int j = 0; j < m; j++) {
            int i = 0, k = j;
            while (i < n && k < m) {
                if ((k == 0 && grid[i][k] == -1) || (k == m - 1 && grid[i][k] == 1)) {
                    ans[j] = -1;
                    break;
                }
                if ((grid[i][k] == 1 && grid[i][k + 1] == -1) || (grid[i][k] == -1 && grid[i][k - 1] == 1)) {
                    ans[j] = -1;
                    break;
                }
                if (grid[i][k] == 1) {
                    i++;
                    k++;
                } else if (grid[i][k] == -1) {
                    i++;
                    k--;
                }
                if (i == n) {
                    ans[j] = k;
                }
            }
        }
        return ans;
    }
}
