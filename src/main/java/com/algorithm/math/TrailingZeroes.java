package com.algorithm.math;

public class TrailingZeroes {

    /**
     * #172
     * https://leetcode-cn.com/problems/factorial-trailing-zeroes
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(3));
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        for (long i = 5; n / i >= 1; i *= 5){
            count += n / i;
        }
        return count;
    }
}
