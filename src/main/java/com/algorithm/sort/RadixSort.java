package com.algorithm.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = { 63, 157, 189, 51, 101, 47, 141, 121, 157, 156,
                194, 117, 98, 139, 67, 133, 181, 12, 28, 0, 109 };
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        int exp;

        for (int anArr : arr) {
            if (anArr > max) {
                max = anArr;
            }
        }

        for (exp = 1; max / exp > 0; exp *= 10) {
            int[] temp = new int[arr.length];
            int[] buckets = new int[10];
            for (int value : arr) {
                buckets[(value / exp) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
                buckets[(arr[i] / exp) % 10]--;
            }

            System.arraycopy(temp, 0, arr, 0, arr.length);
        }
    }
}
