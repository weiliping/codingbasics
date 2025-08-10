package com.algorithm.contest.weeklycontest432;

import java.util.Arrays;

public class MaximumAmount {
    public static void main(String[] args) {
        int[][] coins = new int[][]{{0,1,-1}, {1,-2,3}, {2, -3, 4}};
        MaximumAmount m = new MaximumAmount();
        System.out.println(m.maximumAmount(coins));
        int[][] coins1 = new int[][]{{6, -16}, {0, -18}};
        System.out.println(m.maximumAmount(coins1));
        int[][] coins2 = new int[][]{{-16, -18}, {-18, -14}};
        System.out.println(m.maximumAmount(coins2));
    }
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        Integer[][][] mem = new Integer[m][n][3];        
        mem[0][0] = new Integer[]{coins[0][0], Integer.MIN_VALUE, Integer.MIN_VALUE};
        int v = helpDfs(coins, m - 1, n - 1, 2, mem);
        return v;
    }

    public int helpDfs(int[][] coins, int i, int j, int k, Integer[][][] mem) {
        if (i < 0 || j < 0) {
            return Integer.MIN_VALUE;
        }        
        int x = coins[i][j];
        if (i == 0 && j == 0) {
            return k > 0 ? Math.max(0, x) : x;
        }
        Integer m = mem[i][j][k];
        if (m == null) {
            Integer up = Math.max(helpDfs(coins, i, j - 1, k, mem), helpDfs(coins, i - 1, j, k, mem)) + x;
            if (k > 0) {
                Integer up1 = Math.max(helpDfs(coins, i, j - 1, k - 1, mem), helpDfs(coins, i - 1, j, k - 1, mem));
                mem[i][j][k] = Math.max(up, up); 
            } else {
                mem[i][j][k] = up; 
            }
            
        }
        return mem[i][j][k];
    }

    private static int toVal(Integer[] up) {
        int v = up[0];
        if (v == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return v;
    }

    private static Integer[] calc(Integer[] up, int v) {
        Integer[] values = new Integer[]{up[0], up[1], up[2]};
        if (up[2] == Integer.MIN_VALUE) {
            values[2] = up[2];
        } else {
            int d1 = up[0] - up[1];
            int d2 = up[1] - up[2];
            // d1 < d2

            if (v < d1) {

            }
            values[2] = Math.max(up[2], v);
        }
        return values;
    }
    public int maximumAmountI(int[][] coins) {
        int[] v = new int[]{Integer.MIN_VALUE};
        int[] max = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int m = coins.length, n = coins[0].length;
        help(coins, m, n, 0, 0, 0, v, max);
        return v[0];
    }

    public void help(int[][] coins, int m, int n, int i, int j, int cur, int[] v, int[] max) {
        if (i == m || j == n) {
            return;
        }
        if (max[0] > coins[i][j]) {
            if (max[1] > coins[i][j]) {
                int t = max[1];
                max[1] = coins[i][j];
                max[0] = t;
            } else {
                max[0] = coins[i][j];
            }
        }
        cur += coins[i][j];
        if (i == m - 1 && j == n - 1) {
            System.out.println( cur +" " + Arrays.toString(max));
            int back = 0;
            if (max[0] != Integer.MAX_VALUE && max[0] < 0) {
                back += max[0];
            }
            if (max[1] != Integer.MAX_VALUE && max[1] < 0) {
                back += max[1];
            }
            v[0] = Math.max(v[0], cur + Math.abs(back));
            return;
        }
        if (i < m) {
            help(coins, m, n, i + 1, j, cur, v, max.clone());
        }
        if (j < n) {
            help(coins, m, n, i, j + 1, cur, v, max.clone());
        }
    }
}
