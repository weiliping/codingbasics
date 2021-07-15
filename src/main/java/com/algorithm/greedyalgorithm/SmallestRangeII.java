package com.algorithm.greedyalgorithm;

import java.util.Arrays;

public class SmallestRangeII {

    public static void main(String[] args) {
//        System.out.println(smallestRangeII(new int[] {1}, 0));
//        System.out.println(smallestRangeII(new int[] {0, 10}, 2));
//        System.out.println(smallestRangeII(new int[] {1, 3, 6}, 3));
//        System.out.println(smallestRangeII(new int[] {7, 8, 8}, 5));
//        System.out.println(smallestRangeII(new int[] {9, 10, 5, 9}, 5));
        System.out.println(smallestRangeII(new int[] {7, 8, 8, 5, 2}, 4));
    }
    public static int smallestRangeII(int[] A, int K) {
        int n = A.length, max, min;
        Arrays.sort(A);
        int ans = A[n - 1] - A[0];
        for (int i = 0; i < n - 1; i++) {
            int a = A[i], b = A[i + 1];
            max = Math.max(A[n - 1] - K, a + K);
            min = Math.min(A[0] + K, b - K);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}
