package com.algorithm.math;

public class MissingNumber {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sumExpect = (n + 1) * n / 2;

        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return sumExpect - res;
    }
}
