package com.algorithm.leetcode;

import java.math.BigInteger;

class Solution2939 {
    public static void main(String[] args) {
        Solution2939 s = new Solution2939();
        // System.out.println(s.maximumXorProduct(12, 5, 4));
        // System.out.println(s.maximumXorProduct(6, 7, 5));
        // System.out.println(s.maximumXorProduct(1, 6, 3));
        // //231850918
        // System.out.println(s.maximumXorProduct(53449611838892l, 712958946092406l, 6));
        // 977474591
        // System.out.println(s.maximumXorProduct(919266192685640l, 877724646011187l, 11));
        // 4832893
        System.out.println(s.maximumXorProduct(570713374625622l, 553376364476768l, 35));
    }
    private static final int MOD = (int) 1e9 + 7;
    public int maximumXorProduct(long a, long b, int n) {
        long aPrex = ((a >> n) << n);
        long bPrex = ((b >> n) << n);
        BigInteger[] res = new BigInteger[]{BigInteger.ZERO};
        dfsHelper(a, b, aPrex, bPrex, n - 1, res, 0);
        return res[0].mod(BigInteger.valueOf(MOD)).intValue();
    }
    private static void dfsHelper(long a, long b, long aPrex, long bPrex, int n, BigInteger[] res, int k) {
        if (n == -1) {
            BigInteger a1 = BigInteger.valueOf(aPrex);
            BigInteger b1 = BigInteger.valueOf(bPrex);
            BigInteger c1 = a1.multiply(b1);
            System.out.println(c1 + " c1 " + c1.mod(BigInteger.valueOf(MOD)).intValue());
            if (c1.compareTo(res[0]) > 0) {
                res[0] = c1;
            }
            return;
        }
        int i = (int)((a >> n) & 1);
        int j = (int)((b >> n) & 1);
        long v = 1 << n;
        int nxt = n - 1;
        if (i == j) {
            dfsHelper(a, b, aPrex|v, bPrex|v, nxt, res, k|(i==0?(1<<n):0));
        } else {
            dfsHelper(a, b, aPrex|v, bPrex, nxt, res, k|(j==0?(1<<n):0));
            dfsHelper(a, b, aPrex, bPrex|v, nxt, res, k|(j==0?(1<<n):0));
        }
    }
}
