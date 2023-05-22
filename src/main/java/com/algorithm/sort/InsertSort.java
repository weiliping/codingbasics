package com.algorithm.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9, 0, 3, 5, 8, 7, 6 };
        insertSort(arr, 10);
        System.out.println(Arrays.toString(arr));
    }

    static void insertSort(int arr[], int length) {
        for (int i = 1; i < length; i++) {
            int j;
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }
}
