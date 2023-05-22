package com.algorithm.contest.weeklycontest227;

/**
 *
 */
public class SortArrayRotated {
    public static void main(String[] args) {
        System.out.println(check(new int[] {3, 4, 5, 1, 2}));
        System.out.println(check(new int[] {2, 1, 3, 4}));
        System.out.println(check(new int[] {1, 2, 3}));
        System.out.println(check(new int[] {1, 1, 1}));
        System.out.println(check(new int[] {2, 1}));
    }
    public static boolean check(int[] nums) {
        int n = nums.length, x = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                x = i + 1;
                break;
            }
        }
        if (x == -1) {
            return true;
        }
        for (int j = 0; j < n - 1; j++) {
            int ind = (x + j) % n;
            if (nums[ind] > nums[(ind + 1) % n]) {
                return false;
            }
        }
        return true;
    }
}
