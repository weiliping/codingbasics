package com.algorithm.selfpractice.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9, 0, 3, 5, 8, 7, 6 };
        int[] sortArr = new int[arr.length];
        mergeSort(arr, 0, 9, sortArr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] a, int start, int end, int[] tmp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(a, start, mid, tmp);
        mergeSort(a, mid + 1, end, tmp);

        int ind = 0;
        int sInd = start, sEnd = mid, lInd = mid + 1, lEnd = end;

        while (sInd <= sEnd && lInd <= lEnd) {
            if (a[sInd] < a[lInd]) {
                tmp[ind++] = a[sInd++];
            } else {
                tmp[ind++] = a[lInd++];
            }
        }

        while (sInd <= sEnd) {
            tmp[ind++] = a[sInd++];
        }

        while (lInd <= lEnd) {
            tmp[ind++] = a[lInd++];
        }

        for (int i = 0; i < ind; i++) {
            a[start + i] = tmp[i];
        }
    }
}
