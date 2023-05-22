package com.algorithm.contest.weeklycontest271;

import java.util.HashSet;
import java.util.Set;

public class CountPoints {

    public int countPoints(String rings) {
        int[] G = new int[10];
        int[] R = new int[10];
        int[] B = new int[10];
        char[] chrs = rings.toCharArray();
        int ans = 0, n = chrs.length;
        for (int i = 1; i < n; i += 2) {
            int ind = chrs[i] - '0';
            if (chrs[i - 1] == 'R') {
                R[ind]++;
                continue;
            }
            if (chrs[i - 1] == 'B') {
                B[ind]++;
                continue;
            }
            G[ind]++;
        }
        for (int i = 0; i < 10; i++) {
            if (R[i] > 0 && G[i] > 0 && B[i] > 0) {
                ans++;
            }
        }
        return ans;
    }
}
