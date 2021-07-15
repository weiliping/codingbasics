package com.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9, 0, 3, 5, 8, 7, 6 };
        bubbleSort(arr, 10);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int arr[], int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
