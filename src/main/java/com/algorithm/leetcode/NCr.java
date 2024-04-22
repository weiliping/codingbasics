package com.algorithm.leetcode;

public class NCr {

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

    public static long factorial(int n) {
        return FAC[n];
    }

    public static long invFactorial(int n) {
        return INV_FAC[n];
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
        return (int) res % MOD;
    }

    public static int nCr(int n, int r) {
        long res = 1;
        res = res * FAC[n] % MOD;
        res = res * INV_FAC[r] % MOD;
        res = res * INV_FAC[n - r] % MOD;
        return (int) (res % MOD);
    }

    public static void main(String[] args) {
        System.out.println(factorial(10000));
    }
}
