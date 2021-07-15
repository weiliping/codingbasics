package com.algorithm.contest.weeklycontest216;

public class WaysToMakeFair {

    public static void main(String[] args) {
        WaysToMakeFair w = new WaysToMakeFair();
        int[] nums = new int[] {6, 1, 7, 4, 1};
        System.out.println(w.waysToMakeFair(nums));
        int[] nums2 = new int[] {2, 1, 6, 4};
        System.out.println(w.waysToMakeFair(nums2));
//
        int[] nums3 = new int[] {1, 1, 1};
        System.out.println(w.waysToMakeFair(nums3));
//
        int[] nums4 = new int[] {1, 2, 3};
        System.out.println(w.waysToMakeFair(nums4));

        int[] nums5 = new int[] {1, 1, 1, 1, 1};
        System.out.println(w.waysToMakeFair(nums5));
    }
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] evenSum = new int[n];
        evenSum[0] = nums[0];
        int[] oddSum = new int[n];
        for (int i = 1; i < n; i++) {
            if ((i & 1) == 0) {
                evenSum[i] = evenSum[i - 1] + nums[i];
                oddSum[i] = oddSum[i - 1];
                continue;
            }
            evenSum[i] = evenSum[i - 1];
            oddSum[i] = oddSum[i - 1] + nums[i];
        }
        int cnt = 0, lSum, rSum;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                lSum = oddSum[n - 1] - oddSum[0];
                rSum = evenSum[n - 1] - evenSum[0];
                if (lSum == rSum) {
                    cnt++;
                }
                continue;
            }
            if (i == n - 1) {
                if (oddSum[n - 2] == evenSum[n - 2]) {
                    cnt++;
                }
                continue;
            }
            if ((i & 1) == 0) {
                lSum = evenSum[i - 1] + oddSum[n - 1] - oddSum[i];
                rSum = oddSum[i - 1] + evenSum[n - 1] - evenSum[i + 1];

                if (lSum == rSum) {
                    cnt++;
                }
                continue;
            }
            lSum = evenSum[i - 1] + oddSum[n - 1] - oddSum[i + 1];
            rSum = oddSum[i - 1] + evenSum[n - 1] - evenSum[i];

            if (lSum == rSum) {
                cnt++;
            }
        }
        return cnt;
    }
}
