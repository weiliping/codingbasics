package com.algorithm.dynamicprogramming;

import java.util.Arrays;

public class CountBits {

    /**
     * #338
     * https://leetcode-cn.com/problems/counting-bits/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            res[i] = countNum(i);
        }
        return res;
    }

    static int countNum(int n) {
        int r = 0;

        while (n != 0) {
            r++;
            n &= (n - 1);
        }
        return r;
    }
}
