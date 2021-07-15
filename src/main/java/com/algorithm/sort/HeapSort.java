package com.algorithm.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9, 0, 3, 5, 8, 7, 6 };
        heapSort(arr, 10);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int arr[], int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, length);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp;
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapAdjust(arr, 0, i);
        }
    }

    static void heapAdjust(int arr[], int i, int length) {
        int max = i, lchild = i * 2 + 1, rchild = i * 2 + 2;
        if (lchild < length && arr[lchild] > arr[max]) {
            max = lchild;
        }
        if (rchild < length && arr[rchild] > arr[max]) {
            max = rchild;
        }
        if (max != i) {
            int temp;
            temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapAdjust(arr, max, length);
        }
    }
}
