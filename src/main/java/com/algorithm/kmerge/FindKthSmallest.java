package com.algorithm.kmerge;

public class FindKthSmallest {

    public static void main(String[] args) {
        int[][] martix = new int[][] { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        System.out.println(kthSmallest(martix, 5));
    }

    public static int kthSmallest(int[][] martix, int k) {
        int n = martix.length;
        int s = martix[0][0], e = martix[n - 1][n - 1];
        while (s < e) {
            int mid = s + (e - s) / 2, smaller = martix[0][0], larger = martix[n - 1][n - 1];
            int[] res = countLessEqual(martix, mid, smaller, larger);

            if (res[0] == k) {
                return res[1];
            }

            if (res[0] < k) {
                s = res[2];
            } else {
                e = res[1];
            }
        }
        return s;
    }

    static int[] countLessEqual(int[][] martix, int mid, int smaller, int larger) {
        int count = 0, n = martix.length, row = n - 1, col = 0;
        while (row >= 0 && col < n) {
            if (martix[row][col] > mid) {
                larger = Math.min(martix[row][col], larger);
                row--;
                continue;
            }
            smaller = Math.max(martix[row][col], smaller);
            count += row + 1;
            System.out.println(count);
            col++;
        }
        return new int[] {count, smaller, larger};
    }
}
