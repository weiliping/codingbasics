package com.algorithm.sort;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        sort(new int[] { 2, 5, 3, 0, 2, 3, 0, 3 }, 8);
    }

    public static void sort(int[] a, int n) {
        int max = a[0];

        for (int i = 1; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] numSum = new int[max + 1];

        for (int i = 0; i < n; i++) {
            numSum[a[i]]++;
        }

        for (int j = 1; j <= max; j++) {
            numSum[j] += numSum[j - 1];
        }

        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            tmp[numSum[a[i]] - 1] = a[i];
            numSum[a[i]]--;
        }
        System.out.println(Arrays.toString(tmp));
    }
}
