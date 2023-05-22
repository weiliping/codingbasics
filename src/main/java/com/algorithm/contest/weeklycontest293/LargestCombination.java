package com.algorithm.contest.weeklycontest293;

public class LargestCombination {
    public static void main(String[] args) {
        int[] candidates = new int[] { 16, 17, 71, 62, 12, 24, 14 };
        System.out.println(largestCombination(candidates));

        int[] candidates1 = new int[] { 8, 8 };
        System.out.println(largestCombination(candidates1));
    }

    public static int largestCombination(int[] candidates) {
        int[] cnts = new int[24];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 24; i++) {
            for (int can : candidates) {
                cnts[i] += (can >> i) & 1;
            }
            if (max < cnts[i]) {
                max = cnts[i];
            }
        }
        return max;
    }
}
