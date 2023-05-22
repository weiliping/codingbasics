package com.algorithm.arrays;

public class FirstMissingPositive {

    /**
     * #41
     * https://leetcode-cn.com/problems/first-missing-positive/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums4 = new int[] { 1000, -1 };
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums4));

        int[] nums = new int[] { 1, 2, 0 };
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
        int[] nums1 = new int[] { 3, 4, -1, 1 };
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums1));
        int[] nums2 = new int[] { 7, 8, 9, 11, 12 };
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums2));
    }

    int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return 1;
        }
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
