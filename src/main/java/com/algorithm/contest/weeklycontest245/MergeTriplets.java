package com.algorithm.contest.weeklycontest245;

public class MergeTriplets {

    public static void main(String[] args) {


    }
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x = 0, y = 0, z = 0;
        for (int[] t : triplets) {
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                x = Math.max(x, t[0]);
                y = Math.max(y, t[1]);
                z = Math.max(z, t[2]);
            }
        }
        return x == target[0] && y == target[1] && z == target[2];
    }
}
