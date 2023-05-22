package com.algorithm.contest.weeklycontest191;

import java.util.Arrays;

public class MaxArea {

    public static void main(String[] args) {
        MaxArea m = new MaxArea();
        System.out.println(m.maxArea(5, 4, new int[] { 3, 1 }, new int[] { 1 }));
        System.out.println(m.maxArea(5, 4, new int[] { 1, 2, 4 }, new int[] { 1, 3 }));
        System.out.println(m.maxArea(5, 4, new int[] { 3 }, new int[] { 3 }));
    }

    static final int MOD = (int) 1e9 + 7;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int hLen = horizontalCuts.length, vLen = verticalCuts.length;
        int maxH = horizontalCuts[0], maxV = verticalCuts[0];
        for (int i = 1; i < hLen; i++) {
            int diff = horizontalCuts[i] - horizontalCuts[i - 1];
            if (diff > maxH) {
                maxH = diff;
            }
        }

        int hDiff = h - horizontalCuts[hLen - 1];
        if (hDiff > maxH) {
            maxH = hDiff;
        }
        for (int i = 1; i < vLen; i++) {
            int diff = verticalCuts[i] - verticalCuts[i - 1];
            if (diff > maxV) {
                maxV = diff;
            }
        }
        int vDiff = w - verticalCuts[vLen - 1];
        if (vDiff > maxV) {
            maxV = vDiff;
        }
        long res = ((long) maxH * maxV);
        return (int) (res % MOD);
    }
}
