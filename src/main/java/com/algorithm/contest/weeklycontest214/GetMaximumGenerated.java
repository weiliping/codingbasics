package com.algorithm.contest.weeklycontest214;

public class GetMaximumGenerated {
    public static void main(String[] args) {
        GetMaximumGenerated g = new GetMaximumGenerated();
        System.out.println(g.getMaximumGenerated(0));
        System.out.println(g.getMaximumGenerated(1));
        System.out.println(g.getMaximumGenerated(2));
        System.out.println(g.getMaximumGenerated(100));
    }
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        return max;
    }
}
