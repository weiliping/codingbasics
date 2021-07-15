package com.algorithm.contest.weeklycontest203;

import java.util.Arrays;

public class FindLatestStep {

    public static void main(String[] args) {
        int[] arr1 = new int[] {3,1,5,4,2};
        int m1 = 1;
        System.out.println(findLatestStep(arr1, m1));

        int[] arr = new int[] {3,1,5,4,2};
        int m = 2;
        System.out.println(findLatestStep(arr, m));

        int[] arr2 = new int[] {1};
        int m2 = 1;
        System.out.println(findLatestStep(arr2, m2));

        int[] arr3 = new int[] {2,1};
        int m3 = 2;
        System.out.println(findLatestStep(arr3, m3));
    }

    public static int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (n == m) {
            return n;
        }
        int[] p = new int[n];
        Arrays.fill(p, 1);
        for (int i = n - 1; i >= 0; i--) {
            p[arr[i] - 1] = 0;
            if (isStep(p, m)) {
                return i;
            }
        }
        return -1;
    }

    static boolean isStep(int[] p, int m) {
        int countOne = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == 1) {
                countOne++;
            } else {
                if (countOne == m) {
                    return true;
                }
                countOne = 0;
            }
        }
        if (countOne == m) {
            return true;
        }
        return false;
    }
}
