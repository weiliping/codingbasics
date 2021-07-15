package com.algorithm.arrays;

import java.util.Arrays;

public class TriangleNumber {

    /**
     * #611
     * https://leetcode-cn.com/problems/valid-triangle-number/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[] { 2, 2, 3, 4 }));
    }

    public static int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
