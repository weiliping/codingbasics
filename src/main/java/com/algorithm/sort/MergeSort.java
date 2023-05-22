package com.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9, 0, 3, 5, 8, 7, 6 };
        mergeSort(arr, 0, 9, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int arr[], int start, int end, int temp[]) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid, temp);
        mergeSort(arr, mid + 1, end, temp);
        int length = 0;
        int i_start = start;
        int i_end = mid;
        int j_start = mid + 1;
        int j_end = end;
        while (i_start <= i_end && j_start <= j_end) {

            if (arr[i_start] < arr[j_start]) {
                temp[length] = arr[i_start];
                length++;
                i_start++;
            } else {
                temp[length] = arr[j_start];
                length++;
                j_start++;
            }
        }

        while (i_start <= i_end) {
            temp[length] = arr[i_start];
            i_start++;
            length++;
        }

        while (j_start <= j_end) {
            temp[length] = arr[j_start];
            length++;
            j_start++;
        }
        for (int i = 0; i < length; i++) {
            arr[start + i] = temp[i];
        }
    }
}
