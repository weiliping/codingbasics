package com.algorithm.bitmanipulation;

public class BitwisefnumbersRange {

    /**
     * #201
     * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(8, 10));
        System.out.println(rangeBitwiseAnd(0, 1));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++i;
        }
        return (m << i);
    }
}
