package com.algorithm.contest.weeklycontest152;

public class NumPrimeArrangements {

    public static void main(String[] args) {
        NumPrimeArrangements n = new NumPrimeArrangements();
        System.out.println(n.numPrimeArrangements(5));
        System.out.println(n.numPrimeArrangements(100));
    }
    static long[] multiples = new long[101];
    private static final int MOD = (int) 1e9 + 7;

    public long[] getMultiples() {
        if (multiples[100] == 0l) {
            multiples[0] = 1l;
            for (int i = 1; i <= 100; i++) {
                multiples[i] = ((multiples[i - 1] * i) % MOD);
            }
        }
        return multiples;
    }
    public int numPrimeArrangements(int n) {
        if (n == 1) {
            return 1;
        }
        int primeCnts = 0;
        for (int i = 2; i<= n; i++) {
            if (isPrime(i)) {
                primeCnts++;
            }
        }
        long mutiples[] = getMultiples();
        return (int)((mutiples[primeCnts] * mutiples[n - primeCnts]) % MOD);
    }

    static boolean isPrime(int i) {
        int half = (i >> 1);
        for (int j = 2; j <= half; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
