package com.algorithm.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9, 0, 3, 5, 8, 7, 6 };
        shellSort(arr, 10);
        System.out.println(Arrays.toString(arr));
    }

    static void shellSort(int arr[], int length) {
        int increasement = length;
        int i, j, k;
        while (increasement > 1) {
            increasement = increasement / 3 + 1;
            for (i = 0; i < increasement; i++) {
                for (j = i + increasement; j < length; j += increasement) {
                    if (arr[j] < arr[j - increasement]) {
                        int temp = arr[j];
                        for (k = j - increasement; k >= 0 && temp < arr[k]; k -= increasement) {
                            arr[k + increasement] = arr[k];
                        }
                        arr[k + increasement] = temp;
                    }
                }
            }
        }
    }
}
