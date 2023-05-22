package com.algorithm.contest.weeklycontest268;

public class MaxDistance {
    public int maxDistance(int[] colors) {
        int n = colors.length, max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    int sub = j - i;
                    if (sub > max) {
                        max = sub;
                    }
                }
            }
        }
        return max;
    }
}
