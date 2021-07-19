package com.algorithm.contest.biweeklycontest55;

public class CanBeIncreasing {
    public static void main(String[] args) {
        CanBeIncreasing c = new CanBeIncreasing();
        System.out.println(c.canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(c.canBeIncreasing(new int[] { 2, 3, 4, 5, 6, 1, 2 }));
        System.out.println(c.canBeIncreasing(new int[] { 2, 3, 1, 5, 6, 8, 2 }));
        System.out.println(c.canBeIncreasing(new int[] { 2, 3, 9, 5, 6, 8, 2 }));
        System.out.println(c.canBeIncreasing(new int[] { 3, 5, 1, 6, 7, 8 }));
        System.out.println(c.canBeIncreasing(new int[] { 100, 21, 100}));
        System.out.println(c.canBeIncreasing(new int[] { 100, 120, 101}));
    }
    public boolean canBeIncreasing(int[] nums) {
        boolean hasDecrease = false;
        int n = nums.length, max = nums[0];
        for (int j = 1; j < n; j++) {
            if (max < nums[j]) {
                max = nums[j];
                continue;
            }
            if (hasDecrease) {
                return false;
            }
            hasDecrease = true;
            if ((j > 1 && nums[j - 2] < nums[j]) || j == 1) {
                max = nums[j];
                continue;
            }
            if (j < n - 1 && nums[j - 1] < nums[j + 1]) {
                j++;
                max = nums[j];
            }
        }
        return true;
    }
}
