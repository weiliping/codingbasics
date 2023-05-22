package com.algorithm.contest.weeklycontest331;

import java.util.Arrays;

public class MinCapability {
    public static void main(String[] args) {

    }

    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        Integer[] indes = new Integer[n];

        Arrays.setAll(indes, i -> i);

        Arrays.sort(indes, (a, b) -> nums[a] - nums[b]);
        return 0;
    }
}
