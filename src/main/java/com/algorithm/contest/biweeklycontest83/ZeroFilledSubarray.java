package com.algorithm.contest.biweeklycontest83;

import java.util.HashMap;
import java.util.Map;

public class ZeroFilledSubarray {
    public static Map<Integer, Long> mp = new HashMap<>();

    public static void main(String[] args) {
        // System.out.println(zeroFilledSubarray(new int[] { 1, 3, 0, 0, 2, 0, 0, 4 }));
        System.out.println(zeroFilledSubarray(new int[] { 0, 0, 0, 2, 0, 0 }));
        System.out.println(zeroFilledSubarray(new int[] { 2, 10, 2019 }));
    }

    public static long zeroFilledSubarray(int[] nums) {
        long res = 0l;
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                cnt++;
                res += cnt;
                continue;
            }
            cnt = 0;
        }
        return res;
    }
}
