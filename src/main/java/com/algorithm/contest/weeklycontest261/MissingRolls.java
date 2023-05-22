package com.algorithm.contest.weeklycontest261;

import java.util.Arrays;

public class MissingRolls {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(missingRolls(new int[] {1, 5, 6}, 3, 4)));
        System.out.println(Arrays.toString(missingRolls(new int[] {1, 2, 3, 4}, 6, 4)));
        System.out.println(Arrays.toString(missingRolls(new int[] {1}, 3, 1)));
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, totalSum = (m + n) * mean;
        int mSum = 0;
        for (int r : rolls) {
            mSum += r;
        }

        int nSum = totalSum - mSum;

        if (nSum < n || nSum > 6 * n) {
            return new int[0];
        }

        int[] res = new int[n];

        int val = nSum / n;
        Arrays.fill(res, val);
        int left = nSum % n;
        if (left != 0) {
            for (int i = 0; i < left; i++) {
                res[i]++;
            }
        }
        return res;
    }
}
