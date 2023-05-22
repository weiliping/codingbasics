package com.algorithm.contest.weeklycontest308;

import java.util.Arrays;

public class AnswerQueries {
    public static void main(String[] args) {
        int[] nums = new int[] { 4, 5, 2, 1 }, queries = new int[] { 3, 10, 21 };
        System.out.println(Arrays.toString(answerQueries(nums, queries)));
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int m = queries.length;
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            res[i] = binarySearch(sums, queries[i], n);
        }
        return res;
    }

    static int binarySearch(int[] sums, int val, int n) {
        int l = 0, r = n;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (sums[mid] == val) {
                return mid;
            }

            if (sums[mid] > val) {
                r = mid - 1;
            } else {
                if (mid == n || sums[mid + 1] > val) {
                    return mid;
                }
                l = mid + 1;
            }
        }
        return 0;
    }
}
