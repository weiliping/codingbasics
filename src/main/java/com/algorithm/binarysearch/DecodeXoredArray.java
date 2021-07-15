package com.algorithm.binarysearch;

import java.util.Arrays;

public class DecodeXoredArray {
    /**
     * #1720
     * https://leetcode-cn.com/problems/decode-xored-array/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[] {1, 2, 3}, 1)));
        System.out.println(Arrays.toString(decode(new int[] {6, 2, 7, 3}, 4)));
    }

    public static int[] decode(int[] encoded, int first) {
        int[] nums = new int[encoded.length + 1];
        nums[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            nums[i + 1] = nums[i] ^ encoded[i];
        }
        return nums;
    }
}
