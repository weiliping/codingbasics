package com.algorithm.contest.weeklycontest257;

public class CountQuadruplets {
    public static void main(String[] args) {
        System.out.println(countQuadruplets(new int[]{1,1,1,3,5}));
    }

    public static int countQuadruplets(int[] nums) {
        int n = nums.length;
        int cns = 0;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            cns++;
                        }
                    }
                }
            }
        }
        return cns;
    }
}
