package com.algorithm.twopointers;

public class RemoveDuplicates {

    /**
     * https://github.com/weiliping/Grokking-the-Coding-Interview-Patterns-for-Coding-Questions/blob/master/2.%20Pattern%20Two%20Pointers/Remove%20Duplicates%20(easy).py
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 3, 3, 6, 9, 9};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int l = 0, r = 1, n = nums.length;
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                l = r;
                r++;
                continue;
            }
            r++;
            n--;
        }
        return n;
    }
}
