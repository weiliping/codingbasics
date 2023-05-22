package com.algorithm.contest.weeklycontest254;

public class MinNonZeroProduct {
    public static void main(String[] args) {
        MinNonZeroProduct m = new MinNonZeroProduct();
        System.out.println(m.minNonZeroProduct(31));
    }

    static final int MOD = (int) 1e9 + 7;

    public int minNonZeroProduct(int p) {
        long a = (1L << p) - 1L;
        long b = a - 1L;
        long c = b / 2L;
        long ans = ((a % MOD) * pow(b % MOD, c)) % MOD;
        return (int) ans;
    }

    public static long pow(long b, long c) {
        long ans = 1;
        while (c > 0) {
            if ((c & 1) == 1) {
                ans = (ans * b) % MOD;
            }
            c >>= 1;
            b = (b * b) % MOD;
        }
        return ans;
    }
}
