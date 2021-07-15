package com.algorithm.twopointers;

import java.util.Arrays;

public class RemoveDuplicatedII {
    /**
     * #80
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        //        System.out.println(new RemoveDuplicatedII().removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(new RemoveDuplicatedII().removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int k = 1, t = 1, curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curr == nums[i] && t > 1) {
                continue;
            }
            if (curr != nums[i]) {
                curr = nums[i];
                t = 1;
            } else {
                t++;
            }
            nums[k] = nums[i];
            k++;
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }
}
