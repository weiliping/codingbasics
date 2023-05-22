package com.algorithm.contest.weeklycontest157;

public class MinCostToMoveChips {

    public static void main(String[] args) {
        MinCostToMoveChips m = new MinCostToMoveChips();
        System.out.println(m.minCostToMoveChips(new int[] {1, 2, 3}));
        System.out.println(m.minCostToMoveChips(new int[] {2, 2, 2, 3, 3}));
    }
    public int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;

        for (int p : position) {
            if ((p & 1) == 0) {
                even++;
                continue;
            }
            odd++;
        }

        return Math.min(even, odd);
    }
}
