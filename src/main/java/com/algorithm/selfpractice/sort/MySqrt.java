package com.algorithm.selfpractice.sort;

public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
//        System.out.println(mySqrt(4));
    }
    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int i = 0, j = x;
        while (i < j) {
            int mid = (i + j) / 2;
            if (mid * mid > x) {
                j = mid;
            } else{
                i = mid + 1;
            }
        }
        return i - 1;
    }
}
