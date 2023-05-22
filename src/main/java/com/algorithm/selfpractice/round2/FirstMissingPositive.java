package com.algorithm.selfpractice.round2;

public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] { 1, 2, 0 }));
        System.out.println(firstMissingPositive(new int[] { 3, 4, -1, 1 }));
        System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] - 1 < len && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
