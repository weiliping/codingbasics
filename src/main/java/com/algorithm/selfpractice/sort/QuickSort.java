package com.algorithm.selfpractice.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9, 0, 3, 5, 8, 7, 6 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int i = l, j = r, baseVal = a[i];

        while (i < j) {
            while (i < j && a[j] >= baseVal) {
                j--;
            }

            if (i < j) {
                a[i] = a[j];
                i++;
            }

            while (i < j && a[i] < baseVal) {
                i++;
            }

            if (i < j) {
                a[j] = a[i];
                j--;
            }

            a[i] = baseVal;

            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);
        }
    }
}
