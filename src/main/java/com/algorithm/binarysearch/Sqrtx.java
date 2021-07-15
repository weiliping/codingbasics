package com.algorithm.binarysearch;

public class Sqrtx {

    /**
     * #69
     * https://leetcode-cn.com/problems/sqrtx/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrt(5));
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 0, r = x;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (x / m >= m) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return r - 1;
    }
}
