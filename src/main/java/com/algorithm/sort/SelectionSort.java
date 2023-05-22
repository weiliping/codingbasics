package com.algorithm.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9, 0, 3, 5, 8, 7, 6 };
        selectionSort(arr, 10);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int arr[], int length) {
        for (int i = 0; i < length; i++) {
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index == i) {
                continue;
            }
            int temp;
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}
