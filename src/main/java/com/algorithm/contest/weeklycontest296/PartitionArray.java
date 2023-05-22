package com.algorithm.contest.weeklycontest296;

import java.util.Arrays;

public class PartitionArray {
    public static void main(String[] args) {
        System.out.println(partitionArray(new int[] { 3, 6, 1, 2, 5 }, 2));
        System.out.println(partitionArray(new int[] { 1, 2, 3 }, 1));
        System.out.println(partitionArray(new int[] { 2, 2, 4, 5 }, 0));
    }

    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 1;
        int base = nums[0], n = nums.length;
        for (int i = 1; i < n; i++) {
            int diff = nums[i] - base;
            if (diff <= k) {
                continue;
            }
            cnt++;
            base = nums[i];
        }
        return cnt;
    }
}
