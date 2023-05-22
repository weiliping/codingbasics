package com.algorithm.contest.biweeklycontest64;

import java.util.Arrays;

public class MaxTwoEvents {
    public static void main(String[] args) {
        int[][] events = new int[][] {{1,3,2},{4,5,2},{2,4,3}};
        System.out.println(maxTwoEvents(events));
//
        int[][] events2 = new int[][] {{1,3,2},{4,5,2},{1,5,5}};
//
        System.out.println(maxTwoEvents(events2));
        int[][] events3 = new int[][] {{1,5,3},{1,5,1},{6,6,5}};
        System.out.println(maxTwoEvents(events3));

        int[][] events4 = new int[][] {{10,83,53},{63,87,45},{97,100,32},{51,61,16}};
        System.out.println(maxTwoEvents(events4));
    }
    public static int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] maxNum = new int[n];
        maxNum[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            maxNum[i] = Math.max(maxNum[i + 1], events[i][2]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] event = events[i];
            int ind = getMax(events, event[1], i, n - 1);
            int cur = event[2];
            if (ind != -1) {
                cur += maxNum[ind];
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    static int getMax(int[][] events, int val, int l, int r) {
        int i = l, j = r;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (events[mid][0] > val) {
                if (mid == l || events[mid - 1][0] <= val) {
                    return mid;
                }
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
}
