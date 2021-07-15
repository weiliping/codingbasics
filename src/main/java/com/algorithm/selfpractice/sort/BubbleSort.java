package com.algorithm.selfpractice.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String args[]) {
        int[] a = new int[] {2, 1, 4, 9, 0, 3, 5, 8, 7, 6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        if (a == null) {
            return;
        }
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }
}
