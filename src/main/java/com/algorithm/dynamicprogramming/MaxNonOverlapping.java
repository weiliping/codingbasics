package com.algorithm.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class MaxNonOverlapping {
    public static void main(String[] args) {
        int[] nums = new int[] {-2,6,6,3,5,4,1,2,8};
        int target = 10;
        System.out.println(maxNonOverlapping(nums, target));
    }

    public static int maxNonOverlapping(int[] nums, int target) {
        int size = nums.length;
        int ret = 0;
        int i = 0;
        while (i < size) {
            Set<Integer> set = new HashSet<Integer>() {{
                add(0);
            }};
            int sum = 0;
            while (i < size) {
                sum += nums[i];
                if (set.contains(sum - target)) {
                    ret++;
                    break;
                } else {
                    set.add(sum);
                    i++;
                }
            }
            i++;
        }
        return ret;
    }
}
