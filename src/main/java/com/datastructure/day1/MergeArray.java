package com.datastructure.day1;

public class MergeArray {

    public int[] merge(int a[], int b[]) {
        if (a == null || a.length == 0) {
            return b;
        }

        if (b == null || b.length == 0) {
            return a;
        }
        int n = a.length, m = b.length;
        int[] res = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }

        while (i < n) {
            res[k++] = a[i++];
        }

        while (j < n) {
            res[k++] = a[j++];
        }
        return res;
    }
}
