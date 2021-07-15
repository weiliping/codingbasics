package com.algorithm.arrays;

import java.util.Arrays;

public class ProductExceptSelf {

    /**
     * #238
     * https://leetcode-cn.com/problems/product-of-array-except-self
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        int left = 1, right = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                left = left * nums[i - 1];
            }
            res[i] = left;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                right = right * nums[i + 1];
            }
            res[i] = res[i] * right;
        }
        return res;
    }
}
