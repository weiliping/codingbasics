package com.algorithm.contest.weeklycontest266;

public class MinimizedMaximum {

    public static void main(String[] args) {
        System.out.println(minimizedMaximum(6, new int[] {11, 6}));
        System.out.println(minimizedMaximum(7, new int[] {15, 10, 10}));
        System.out.println(minimizedMaximum(1, new int[] {100000}));
    }
    public static int minimizedMaximum(int n, int[] quantities) {
        int max = Integer.MIN_VALUE;
        for (int q : quantities) {
            if (max < q) {
                max = q;
            }
        }
        int i = 1, j = max;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            int cnt = countVal(quantities, mid);
            if (cnt <= n) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    static int countVal(int[] quantities, int v) {
        int cnt = 0;
        for (int q : quantities) {
            cnt += q / v;
            if (q % v != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
