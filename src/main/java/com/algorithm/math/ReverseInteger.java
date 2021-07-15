package com.algorithm.math;

public class ReverseInteger {

    /**
     * #7
     * https://leetcode-cn.com/problems/reverse-integer/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

    public static int reverse(int x) {
        long reverseNum = 0;
        boolean isNegative = false;
        if (x < 0) {
            x = - x;
            isNegative = true;
        }
        while (x > 0) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }
        if (reverseNum > Integer.MAX_VALUE) {
            return 0;
        }
        return isNegative ? -(int) reverseNum : (int) reverseNum;
    }
}
