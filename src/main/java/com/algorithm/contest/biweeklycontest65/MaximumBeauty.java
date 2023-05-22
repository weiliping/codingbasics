package com.algorithm.contest.biweeklycontest65;

import java.util.Arrays;

public class MaximumBeauty {

    public static void main(String[] args) {
        MaximumBeauty m = new MaximumBeauty();
        int items1[][] = new int[][] { {1,2},{3,2},{2,4},{5,6},{3,5}}, queries1[] = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(m.maximumBeauty(items1, queries1)));

        int[][] items = new int[][]{{1,2},{1,2},{1,3},{1,4}};
        int[] queries = new int[]{1};
        System.out.println(Arrays.toString(m.maximumBeauty(items, queries)));
        int[][] items2 = new int[][]{{10,1000}};
        int[] queries2 = new int[]{5};
        System.out.println(Arrays.toString(m.maximumBeauty(items2, queries2)));
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int n = items.length, m = queries.length;
        int[] maxV = new int[n];
        maxV[0] = items[0][1];
        for (int i = 1; i < n; i++) {
            maxV[i] = Math.max(maxV[i - 1], items[i][1]);
        }

        int[] res = new int[m];
        int l = 0, r = n - 1;
        for (int i = 0; i < m; i++) {
            int ind = binarySearch(items, queries[i], l, r);
            if (ind == -1) {
                continue;
            }
            res[i] = maxV[ind];
        }
        return res;
    }

    int binarySearch(int[][] items, int v, int l, int r) {
        int i = l, j = r;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (items[mid][0] > v) {
                if (mid == l) {
                    return -1;
                }
                if (items[mid - 1][0] <= v) {
                    return mid - 1;
                }
                j = mid - 1;
                continue;
            }
            if (mid == r) {
                return mid;
            }
            if (items[mid + 1][0] > v) {
                return mid;
            }
            i = mid + 1;
        }
        return -1;
    }
}
