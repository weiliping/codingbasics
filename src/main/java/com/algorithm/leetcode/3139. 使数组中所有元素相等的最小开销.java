package com.algorithm.leetcode;

class Solution3139 {
    public static void main(String[] args) {
        String a = "ddd";
        int b = (int) 'a';
        new int[2].clone()
    }
    public static final int MOD = 1000000007;
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        long n = nums.length;
        int min = nums[0], max = nums[0];
        long sum = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        long base = max * n - sum;
        if (n <= 2 || (cost1<<1) <= cost2) {
            return (int) base * cost1 % MOD;
        }
        int i = (int) ((n * max - min * 2 - base + n - 3) / (n - 2));
        long res1 = f(max, base, n, min, max, cost1, cost2);
        if (i <= max) {
            long res2 = f(max + 1, base, n, min, max, cost1, cost2);
            return (int) Math.min(res1, res2) % MOD;
        }
        long res3 = f(i - 1, base, n, min, max, cost1, cost2);
        long res4 = f(i, base, n, min, max, cost1, cost2);
        long res5 = f(i + 1, base, n, min, max, cost1, cost2);
        res1 = Math.min(res1, res3);
        res1 = Math.min(res1, res4);
        res1 = Math.min(res1, res5);
        return (int) res1 % MOD;
    }

    private long f(int x, long base, long n, int min, int max, int c1, int c2) {
        long s = base + (x - max) * n;
        int d = x - min;
        if ((d << 1) <= s) {
            return (s >> 1) * c2 + (s & 1) * c1;
        }
        return (s - d) * c2 + ((d << 1) - s) * c1;
    }
}
