package com.algorithm.contest.weeklycontest170;

import java.util.Arrays;

public class XorQueries {
    public static void main(String[] args) {
        XorQueries x = new XorQueries();
        int[] arr1 = new int[] {1,3,4,8};
        int[][] queries1 = new int[][] {{0,1},{1,2},{0,3},{3,3}};
        System.out.println(Arrays.toString(x.xorQueries(arr1, queries1)));

        int[] arr2 = new int[] {4,8,2,10};
        int[][] queries2 = new int[][] {{2,3},{1,3},{0,0},{0,3}};
        System.out.println(Arrays.toString(x.xorQueries(arr2, queries2)));
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] sums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] ^ arr[i - 1];
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            res[i] = sums[q[0]] ^ sums[q[1] + 1];
        }
        return res;
    }
}
