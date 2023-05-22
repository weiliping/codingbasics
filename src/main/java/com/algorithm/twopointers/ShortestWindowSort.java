package com.algorithm.twopointers;

public class ShortestWindowSort {
    /**
     * #581
     * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
     * https://github.com/weiliping/Grokking-the-Coding-Interview-Patterns-for-Coding-Questions/blob/master/2.%20Pattern%20Two%20Pointers/Problem%20Challenge%203%20-%20Minimum%20Window%20Sort%20(medium).py
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(shortestWindowSort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
    }

    public static int shortestWindowSort(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l]) {
                break;
            }
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r]) {
                break;
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
