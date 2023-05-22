package com.algorithm.contest.weeklycontest299;

public class CountHousePlacements {
    public static void main(String[] args) {

    }

    private static final int MOD = (int) 1e9 + 7;

    public static int countHousePlacements(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 2;
        if (n <= 1) {
            return f[n] * f[n];
        }

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            if (f[i] >= MOD) {
                f[i] -= MOD;
            }
        }
        return (int) ((long) f[n] * f[n] % MOD);
    }
}
