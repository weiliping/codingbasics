package com.datastructure.day1;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        sort(new int[] { 2, 5, 3, 0, 2, 3, 0, 3 }, 8);
    }

    public static void sort(int[] a, int n) {
        if (a == null || n == 0) {
            return;
        }

        int max = a[0];

        for (int i = 1; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] numSum = new int[max + 1];

        for (int i = 0; i < n; i++) {
            int cnt = a[i];
            numSum[cnt]++;
        }

        for (int j = 1; j <= max; j++) {
            numSum[j] += numSum[j - 1];
        }

        int[] r = new int[n];

        for (int i = 0; i < n; i++) {
            int num = a[i];
            r[numSum[num] - 1] = num;
            numSum[num]--;
        }

        System.out.println(Arrays.toString(r));
    }
}
