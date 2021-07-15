package com.algorithm.contest.weeklycontest218;

public class ConcatenatedBinary {

    static final int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        ConcatenatedBinary c = new ConcatenatedBinary();
        System.out.println(c.concatenatedBinary(42));
//        System.out.println(c.concatenatedBinary(12));
//        System.out.println(c.concatenatedBinary(3));
//        System.out.println(c.concatenatedBinary(1));
    }

    public int concatenatedBinary(int n) {
        long res = 1;
        boolean f;
        for (int i = 2; i <= n; i++) {
            f = false;
            for (int j = 18; j >= 0; j--) {
                int b = (i >> j & 1);
                if (!f) {
                    f = b == 1;
                }
                if (f) {
                    res <<= 1;
                    res |= b;
                    res %= MOD;
                }
            }
        }
        return (int) (res % MOD);
    }
}
