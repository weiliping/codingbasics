package com.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

public class MaxSum {

    public static void main(String[] args) {
        int[] nums1 = new int[] { 2, 4, 5, 8, 10 };
        int[] nums2 = new int[] { 4, 6, 8, 9 };
        System.out.println(new MaxSum().maxSum(nums1, nums2));
    }

    public static final long MOD = 1000000007;

    private int[] nums1, nums2;
    private Map<Integer, Integer> pos1, pos2;
    private long[][] dp;

    private int getNum(int sp, int idx) {
        return sp == 1 ? nums1[idx] : nums2[idx];
    }

    private Integer getPos(int sp, int num) {
        return sp == 1 ? pos2.get(num) : pos1.get(num);
    }

    private long dfs(int sp, int idx) {
        if (idx < 0) {
            return 0;
        }
        if (dp[sp][idx] > 0) {
            return dp[sp][idx];
        }
        long ans = 0;
        int current = getNum(sp, idx);
        ans = Math.max(ans, dfs(sp, idx - 1) + current);

        Integer jump = getPos(sp, current);
        if (jump != null) {
            ans = Math.max(ans, dfs(3 - sp, jump - 1) + current);
        }
        return dp[sp][idx] = ans;
    }

    public int maxSum(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.pos1 = new HashMap<>(nums1.length);
        this.pos2 = new HashMap<>(nums2.length);
        this.dp = new long[3][Math.max(nums1.length, nums2.length) + 5];
        for (int i = 0; i < nums1.length; ++i) {
            pos1.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; ++i) {
            pos2.put(nums2[i], i);
        }
        long a = dfs(1, nums1.length - 1);
        long b = dfs(2, nums2.length - 1);
        return (int) (Math.max(a, b) % MOD);
    }
}
