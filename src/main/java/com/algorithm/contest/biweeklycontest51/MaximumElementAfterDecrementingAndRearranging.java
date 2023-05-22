package com.algorithm.contest.biweeklycontest51;

import java.util.Arrays;

public class MaximumElementAfterDecrementingAndRearranging {

    public static void main(String[] args) {
        MaximumElementAfterDecrementingAndRearranging m = new MaximumElementAfterDecrementingAndRearranging();
        System.out.println(m.maximumElementAfterDecrementingAndRearranging(new int[] { 2, 2, 1, 2, 1 }));
        System.out.println(m.maximumElementAfterDecrementingAndRearranging(new int[] { 100, 1, 1000 }));
        System.out.println(m.maximumElementAfterDecrementingAndRearranging(new int[] { 1,2,3,4,5 }));
    }
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            int num = Math.min(arr[i], i + 1);
            cnt = Math.min(num, cnt + 1);
        }
        return cnt;
    }
}
