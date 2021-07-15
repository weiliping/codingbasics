package com.algorithm.greedyalgorithm;

public class WiggleMaxLength {

    public static void main(String[] args) {
        System.out.println(wiggleMaxLengthIII(new int[] {1,17,5,10,13,15,10,5,16,8}));
        System.out.println(wiggleMaxLengthII(new int[] {1,17,5,10,13,15,10,5,16,8}));
        System.out.println(wiggleMaxLengthI(new int[] {1,17,5,10,13,15,10,5,16,8}));
    }

    public static int wiggleMaxLengthI(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n < 2) {
            return n;
        }

        int preDiff = nums[1] - nums[0];

        int count = preDiff != 0 ? 2 : 1;

        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((preDiff <= 0 && diff > 0) || (preDiff >= 0 && diff < 0)) {
                count++;
                preDiff = diff;
            }
        }
        return count;
    }

    public static int wiggleMaxLengthII(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int down = 1, up = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                up = down + 1;
            } else if (nums[i - 1] > nums[i]) {
                down = up + 1;
            }
        }
        return Math.max(down, up);
    }

    public static int wiggleMaxLengthIII(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] down = new int[n], up = new int[n];
        down[0] = up[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i - 1] > nums[i]) {
                up[i] = up[i - 1];
                down[i] = up[i - 1] + 1;
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(down[n - 1], up[n - 1]);
    }
}
