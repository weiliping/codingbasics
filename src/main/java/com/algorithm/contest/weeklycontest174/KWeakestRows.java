package com.algorithm.contest.weeklycontest174;

import java.util.Arrays;

public class KWeakestRows {
    public static void main(String[] args) {
        KWeakestRows kw = new KWeakestRows();
        int mat[][] = {{1,1,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1}}, k = 3;
        System.out.println(Arrays.toString(kw.kWeakestRows(mat, k)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int[][] res = new int[n][2];

        for (int i = 0; i < n; i++) {
            res[i][0] = i;
            for (int num : mat[i]) {
                if (num == 1) {
                    res[i][1]++;
                }
            }
        }

        Arrays.sort(res, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int[] cnt = new int[k];
        for (int i = 0; i < k; i++) {
            cnt[i] = res[i][0];
        }
        return cnt;
    }
}
