package com.algorithm.leetcode;

class Solution2954 {

    static int MOD = (int) 1e9 + 7;
    static int N = (int) 1e5;
    static long[] FAC = new long[N + 1];
    static long[] INV_FAC = new long[N + 1];
    static {
        FAC[0] = 1;
        for (int i = 1; i <= N; i++) {
            FAC[i] = FAC[i - 1] * i % MOD;
        }
        INV_FAC[N] = modInverse(FAC[N]);
        for (int i = N - 1; i >= 0; i--) {
            INV_FAC[i] = INV_FAC[i + 1] * (i + 1) % MOD;
        }
    }

    public static void main(String[] args) {
        Solution2954 solution = new Solution2954();
        // System.out.println((int) 1e9 + 7);
        System.out.println(solution.numberOfSequence(4, new int[] { 1 }));
    }

    public static long modInverse(long x) {
        return power(x, MOD - 2);
    }

    public static long power(long x, long y) {
        long res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
            y >>= 1;
        }
        return res % MOD;
    }

    public static int nCr(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }

        long res = 1;
        res = res * FAC[n] % MOD;
        res = res * INV_FAC[r] % MOD;
        res = res * INV_FAC[n - r] % MOD;
        return (int) (res % MOD);
    }

    public int numberOfSequence(int n, int[] sick) {
        int m = sick.length, t = n - m;
        int res = nCr(t, sick[0]);
        t -= sick[0];
        res = res * nCr(t, n - sick[m - 1] - 1) % MOD;
        t -= n - sick[m - 1] - 1;
        int e = 0;
        for (int i = 1; i < m; i++) {
            int k = sick[i] - sick[i - 1] - 1;
            if (k > 0) {
                e += k - 1;
                res = res * nCr(t, k) % MOD;
                t -= k;
            }
        }
        return (int) (res * power(2, e) % MOD);
    }
}
