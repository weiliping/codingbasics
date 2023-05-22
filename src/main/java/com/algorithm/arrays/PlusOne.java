package com.algorithm.arrays;

import java.util.Arrays;

public class PlusOne {

    /**
     * #66. 加一
     * https://leetcode-cn.com/problems/plus-one
     * @param args
     */
    public static void main(String[] args) {
        int[] digits = new int[] {1, 2, 3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
