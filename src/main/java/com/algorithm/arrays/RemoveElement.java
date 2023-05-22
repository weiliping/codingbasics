package com.algorithm.arrays;

public class RemoveElement {

    /**
     * #27
     * https://leetcode-cn.com/problems/remove-element
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] els = new int[] { 3, 2, 2, 3 };
        System.out.println(new RemoveElement().removeElement(els, 3));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (val != nums[i]) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
