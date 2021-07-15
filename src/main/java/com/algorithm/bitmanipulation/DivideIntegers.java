package com.algorithm.bitmanipulation;

public class DivideIntegers {

    /**
     * #29
     * https://leetcode-cn.com/problems/divide-two-integers
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = dividend < 0 ^ divisor < 0 ? -1 : 1;
        long m = Math.abs((long) dividend), n = Math.abs((long) divisor), res = 0;
        if (n == 1) {
            return (int) (sign > 0 ? m : -m);
        }

        while (m >= n) {
            long t = n, p = 1;
            while (m >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }
        return (int) (sign > 0 ? res : -res);
    }
}
