package com.algorithm.dynamicprogramming;

public class KConcatenationMaxSum {
    /**
     * #1191
     * https://leetcode-cn.com/problems/k-concatenation-maximum-sum/
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        //664859242
        System.out.println(kConcatenationMaxSum(arr, 3));
        System.out.println(kConcatenationMaxSumII(arr, 3));
        System.out.println(kConcatenationMaxSumI(arr, 3));
    }

    public static int kConcatenationMaxSumII(int[] arr, int k) {
        int n = arr.length;
        int[] s = new int[n + 1], d = new int[n];
        for (int i = 1; i < n; i++) {
            s[i + 1] = s[i] + arr[i];
            d[i] = Math.max((i > 0 ? d[i - 1] : 0) + arr[i], 0);
        }
        if (k == 1) {
            return maxArray(d);
        }
        return Math.max(maxArray(d), Math.max(s[n], 0) * (k - 2) + s[n] - minArray(s) + maxArray(s)) % 1000000007;
    }

    static int maxArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    static int minArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            min = Math.min(min, i);
        }
        return min;
    }
    public static int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;
        int r = Math.min(2, k);
        int[] nums = new int[n * r];
        for (int i = 0; i < r; i++) {
            System.arraycopy(arr, 0, nums, i * n, n);
        }
        long s = 0, max = 0;

        for (int a : nums) {
            s = s < 0 ? a : s + a;
            max = Math.max(s, max);
        }

        if (k <= 2) {
            return (int) max % 1000000007;
        }

        long sum = 0;
        for (int i : arr) {
            sum += i;
        }
        while (sum > 0 && --k >= 2) {
            max = (max + sum) % 1000000007;
        }
        return (int) max;
    }

    public static int kConcatenationMaxSumI(int[] arr, int k) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        long maxOfEnd = arr[0] > 0 ? arr[0] : 0L, maxSoFar = maxOfEnd, sum = arr[0];
        for (int i = 1; i < Math.min(k, 2) * arr.length; i++) {
            maxOfEnd = Math.max(maxOfEnd + arr[i % arr.length], arr[i % arr.length]);
            maxSoFar = Math.max(maxOfEnd, maxSoFar);
            if (i < arr.length){
                sum += arr[i];
            }
        }
        while (sum > 0 && --k >= 2) {
            maxSoFar = (maxSoFar + sum) % 1000000007;
        }
        return (int) maxSoFar;
    }
}
