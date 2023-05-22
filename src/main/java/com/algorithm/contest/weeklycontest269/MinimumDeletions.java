package com.algorithm.contest.weeklycontest269;

public class MinimumDeletions {
    public static void main(String[] args) {
        MinimumDeletions m = new MinimumDeletions();
        //        System.out.println(m.minimumDeletions(new int[]{2,10,7,5,4,1,8,6}));
        //        System.out.println(m.minimumDeletions(new int[]{0,-4,19,1,8,-2,-3,5}));
        //        System.out.println(m.minimumDeletions(new int[]{101}));
        //        System.out.println(m.minimumDeletions(new int[]{-1,-53,93,-42,37,94,97,82,46,42,-99,56,-76,-66,-67,-13,10,66,85,-28}));
        System.out.println(m.minimumDeletions(new int[] { 52724, 12510, 62112 }));
    }

    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, minInd = -1, maxInd = -1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxInd = i;
            }
            if (min > nums[i]) {
                min = nums[i];
                minInd = i;
            }
        }

        if (maxInd == minInd) {
            return Math.max(maxInd + 1, n - maxInd);
        }

        int half = (n >> 1);
        if ((n & 1) == 1) {
            half++;
        }
        if (maxInd < half && minInd < half) {
            return Math.max(maxInd, minInd) + 1;
        }
        boolean isMaxInd = maxInd >= half;
        if (isMaxInd && minInd >= half) {
            return n - Math.min(maxInd, minInd);
        }
        int sameDir = Math.max(maxInd + 1, minInd + 1);
        sameDir = Math.min(sameDir, Math.max(n - minInd, n - maxInd));

        if (isMaxInd) {
            return Math.min(sameDir, minInd + 1 + n - maxInd);
        }

        return Math.min(sameDir, maxInd + 1 + n - minInd);
    }
}
