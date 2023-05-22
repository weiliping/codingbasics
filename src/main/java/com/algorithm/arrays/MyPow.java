package com.algorithm.arrays;

public class MyPow {

    /**
     * #50
     * https://leetcode-cn.com/problems/powx-n/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(myPow(2.000, 10));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x = x * x;
        }
        return n < 0 ? 1 / res : res;
    }
}
