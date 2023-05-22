package com.algorithm.contest.biweeklycontest66;

public class MinCost {
    public static void main(String[] args) {
        MinCost m = new MinCost();
        System.out.println(m.minCost(new int[]{1, 0}, new int[]{2, 3}, new int[] {5, 4, 3}, new int[]{8, 2, 6, 7}));
    }
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int r1 = startPos[0], c1 = startPos[1];
        int r2 = homePos[0], c2 = homePos[1];
        int res = 0;
        if (r2 >= r1) {
            for (int i = r1 + 1; i <= r2; i++) {
                res += rowCosts[i];
            }
        } else {
            for (int i = r2; i < r1; i++) {
                res += rowCosts[i];
            }
        }
        if (c2 >= c1) {
            for (int i = c1 + 1; i <= c2; i++) {
                res += colCosts[i];
            }
        } else {
            for (int i = c2; i < c1; i++) {
                res += colCosts[i];
            }
        }
        return res;
    }
}
