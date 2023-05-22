package com.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9, 0, 3, 5, 8, 7, 6 };
        quickSort(arr, 0, 9);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int baseval = arr[start];
        while (i < j) {
            while (i < j && arr[j] >= baseval) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < baseval) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = baseval;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
}
