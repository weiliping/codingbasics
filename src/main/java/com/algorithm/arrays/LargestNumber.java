package com.algorithm.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    /**
     * #179
     * https://leetcode-cn.com/problems/largest-number/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        String val1 = o1 + o2;
                        String val2 = o2 + o1;
                        return val1.compareTo(val2) > 0 ? -1 : 1;
                    }
                }
        );
        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            res.append(str);
        }

        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return res.toString();
    }
}
