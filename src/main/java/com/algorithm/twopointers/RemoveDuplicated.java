package com.algorithm.twopointers;

public class RemoveDuplicated {

    /**
     * #26
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicated().removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int k = 1, n = nums.length - 1, baseInt = nums[0];
        for (int i = 1; i <= n; i++) {
            if (baseInt == nums[i]) {
                continue;
            }
            nums[k] = nums[i];
            baseInt = nums[k];
            k++;
        }
        return k;
    }
}
