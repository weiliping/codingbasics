package com.algorithm.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * #217
     * https://leetcode-cn.com/problems/contains-duplicate/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 1 }));
        System.out.println(containsDuplicateII(new int[] { 1, 2, 3, 1 }));
        System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 }));
        System.out.println(containsDuplicateII(new int[] { 1, 2, 3, 4 }));
        System.out.println(containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
        System.out.println(containsDuplicateII(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();

        for (int n : nums) {
            if (unique.contains(n)) {
                return true;
            }
            unique.add(n);
        }
        return false;
    }

    public static boolean containsDuplicateII(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (++i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
