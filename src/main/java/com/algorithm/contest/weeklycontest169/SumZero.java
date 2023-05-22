package com.algorithm.contest.weeklycontest169;

import java.util.Arrays;

public class SumZero {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(3)));
        System.out.println(Arrays.toString(sumZero(5)));
        System.out.println(Arrays.toString(sumZero(1)));
        System.out.println(Arrays.toString(sumZero(6)));
    }

    public static int[] sumZero(int n) {
        if (n == 1) {
            return new int[]{0};
        }
        int[] arr = new int[n];
        int l = (n >> 1);
        for (int i = 1; i <= l; i++) {
            arr[i - 1] = -i;
            arr[n - i] = i;
        }
        if ((n & 1) != 0) {
            arr[l] = 0;
        }
        return arr;
    }
}
