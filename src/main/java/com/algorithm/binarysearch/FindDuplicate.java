package com.algorithm.binarysearch;

public class FindDuplicate {

    /**
     * #287
     * https://leetcode-cn.com/problems/find-the-duplicate-number/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
        System.out.println(findDuplicateI(new int[] { 1, 3, 4, 2, 2 }));
    }

    public static int findDuplicate(int[] nums) {
        boolean[] duplicates = new boolean[nums.length];
        for (int num : nums) {
            if (!duplicates[num]) {
                duplicates[num] = true;
                continue;
            }
            return num;
        }
        return -1;
    }

    public static int findDuplicateI(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] > 0) {
                nums[j] = - nums[j];
            } else {
                return j + 1;
            }
        }
        return -1;
    }
}
