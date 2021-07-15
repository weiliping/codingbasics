package com.algorithm.math;

import java.util.Arrays;

public class CountPrimes {

    /**
     * #204
     * https://leetcode-cn.com/problems/count-primes/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        int cnt = 0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                continue;
            }
            cnt++;
            for (int j = 2; i * j < n; j++) {
                prime[i * j] = false;
            }
        }
        return cnt;
    }
}
