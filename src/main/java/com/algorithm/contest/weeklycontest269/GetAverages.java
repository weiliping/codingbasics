package com.algorithm.contest.weeklycontest269;

import java.util.Arrays;

public class GetAverages {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        int d = (k << 1) + 1;
        for (int i = k; i < n - k; i++) {
            long s = sum[i + k + 1] - sum[i - k];
            res[i] = Long.valueOf(s / d).intValue();
        }
        return res;
    }
}
