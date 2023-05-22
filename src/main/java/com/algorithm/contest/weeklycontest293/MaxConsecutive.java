package com.algorithm.contest.weeklycontest293;

import java.util.Arrays;

public class MaxConsecutive {
    public static void main(String[] args) {
        // int bottom = 2, top = 9, special[] = new int[] { 4, 6 };
        // System.out.println(maxConsecutive(bottom, top, special));

        // int bottom1 = 6, top1 = 8, special1[] = new int[] { 7, 6, 8 };
        // System.out.println(maxConsecutive(bottom1, top1, special1));

        int bottom2 = 3, top2 = 15, special2[] = new int[] { 7, 9, 13 };
        System.out.println(maxConsecutive(bottom2, top2, special2));
    }

    public static int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int n = special.length;
        int max = special[0] - bottom;
        if (max < 0) {
            max = 0;
        }

        int r = top - special[n - 1];
        if (max < r) {
            max = r;
        }

        for (int i = 1; i < n; i++) {
            int d = special[i] - special[i - 1] - 1;
            if (max < d) {
                max = d;
            }
        }
        return max;
    }
}
