package com.algorithm.contest.weeklycontest200;

import java.util.ArrayList;

public class MinSwaps {

    public static void main(String[] args) {
        // 3
        int[][] grid = new int[][] { { 0, 0, 1 }, { 1, 1, 0 }, { 1, 0, 0 } };
        System.out.println(minSwaps(grid));
        // -1
        int[][] grid1 = new int[][] { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 1, 1, 0 } };
        System.out.println(minSwaps(grid1));
        // 0
        int[][] grid2 = new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(minSwaps(grid2));
        // 2
        int[][] grid3 = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
        System.out.println(minSwaps(grid3));
        // 4
        int[][] grid4 = new int[][] {
                { 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1 }
        };
        System.out.println(minSwaps(grid4));

        //2
        int[][] grid5 = new int[][] {
                { 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0 },
                { 1, 1, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0 }
        };
        System.out.println(minSwaps(grid5));
    }

    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    cnt++;
                } else {
                    break;
                }
            }
            list.add(cnt);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int threshold = n - 1 - i;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) >= threshold) {
                    list.remove(j);
                    res += j;
                    break;
                }
            }
        }
        if (!list.isEmpty()) {
            return -1;
        }
        return res;
    }
}
