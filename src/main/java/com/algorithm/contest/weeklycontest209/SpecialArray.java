package com.algorithm.contest.weeklycontest209;

import java.util.Arrays;

public class SpecialArray {

    public static void main(String[] args) {
        SpecialArray s = new SpecialArray();
        int[] nums1 = new int[]{3, 5};
        int[] nums2 = new int[]{0, 0};
        int[] nums3 = new int[]{0, 4, 3, 0, 4};
        System.out.println(s.specialArray(nums1));
        System.out.println(s.specialArray(nums2));
        System.out.println(s.specialArray(nums3));
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 && nums[i] >= n) {
                return n;
            }
            if (nums[i] >= n - i && nums[i - 1] < n - i) {
                return n - i;
            }
        }
        return -1;
    }
}
