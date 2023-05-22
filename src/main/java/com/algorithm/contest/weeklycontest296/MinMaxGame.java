package com.algorithm.contest.weeklycontest296;

public class MinMaxGame {
    public static void main(String[] args) {
        System.out.println(minMaxGame(new int[] { 1, 3, 5, 2, 4, 8, 2, 2 }));
        System.out.println(minMaxGame(new int[] { 3 }));
    }

    public static int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            int h = n >> 1;
            for (int i = 0; i < h; i++) {
                int ind = i << 1;
                if ((i & 1) == 0) {
                    nums[i] = Math.min(nums[ind], nums[ind + 1]);
                } else {
                    nums[i] = Math.max(nums[ind], nums[ind + 1]);
                }
            }
            n = h;
        }
        return nums[0];
    }
}
