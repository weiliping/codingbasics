package com.algorithm.bitmanipulation;

public class SingleNumber {

    /**
     * #136
     * https://leetcode-cn.com/problems/single-number/
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] {2, 3, 3, 2, 1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res = res ^ n;
        }
        return res;
    }
}
