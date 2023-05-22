package com.algorithm.contest.weeklycontest193;

public class MinDays {

    public static void main(String[] args) {
        MinDays m = new MinDays();
        System.out.println(m.minDays(new int[] {1,10,3,10,2}, 3, 1));
        System.out.println(m.minDays(new int[] {1,10,3,10,2}, 3, 2));
        System.out.println(m.minDays(new int[] {7,7,7,7,12,7,7}, 2, 3));
        System.out.println(m.minDays(new int[] {1000000000,1000000000}, 1, 1));
        System.out.println(m.minDays(new int[] {1,10,2,9,3,8,4,7,5,6}, 4, 2));
    }
    public int minDays(int[] bloomDay, int m, int k) {

        int res = Integer.MAX_VALUE, n = bloomDay.length, i = 1;

        if (m * k > n) {
            return -1;
        }

        int max = maxNum(bloomDay, 0, n - 1) + 1;
        int mid;
        while (i < max) {
            mid = i + ((max - i) >> 1);
            int cnt = 0, j = 0, subRes = 0;
            while (j < n) {
                if (bloomDay[j] <= mid) {
                    cnt++;
                    if (cnt == k) {
                        subRes++;
                        cnt = 0;
                    }
                    j++;
                    continue;
                }
                j++;
                if (cnt > 0) {
                    cnt = 0;
                }
            }
            if (subRes < m) {
                i = mid + 1;
            } else {
                if (res > mid) {
                    res = mid;
                }
                max = mid;
            }
        }
        return res;
    }

    static int maxNum(int[] bloomDay, int i, int j) {
        if (i > j) {
            return Integer.MIN_VALUE;
        }
        if (i == j) {
            return bloomDay[i];
        }
        if (i + 1 == j) {
            return Math.max(bloomDay[i], bloomDay[j]);
        }
        int mid = i + ((j - i) >> 1);
        return Math.max(maxNum(bloomDay, i, mid - 1), maxNum(bloomDay, mid, j));
    }
}
