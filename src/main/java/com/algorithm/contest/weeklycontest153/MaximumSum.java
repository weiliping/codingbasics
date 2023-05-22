package com.algorithm.contest.weeklycontest153;

public class MaximumSum {

    public static void main(String[] args) {
//        int[] nums = new int[] { 1,-2,0,3};
//        System.out.println(maximumSum(nums));

//        int[] nums1 = new int[] { 10, -11, 13, -8, 17 };
//        System.out.println(maximumSum(nums1));

        int[] nums2 = new int[] { 10, -11, 13, -20, 17 };
        System.out.println(maximumSum(nums2));
    }
    private static final int MIN_INT = -10001;
    public static int maximumSum(int[] arr) {
        int dp1 = MIN_INT, dp2 = MIN_INT, max = MIN_INT;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            dp2 = Math.max(dp1, dp2 + arr[i]);
            dp1 = Math.max(dp1 + arr[i], arr[i]);
            max = Math.max(max, Math.max(dp1, dp2));
        }
        return max;
    }
}
