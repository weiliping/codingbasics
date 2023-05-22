package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    /**
     * #1
     * https://leetcode-cn.com/problems/two-sum/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumII(new int[] { 2, 7, 11, 15 }, 9)));
    }

    static int[] twoSumII(int[] nums, int target){
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int lNum = target - nums[i];
            if (res.containsKey(nums[i])) {
                return new int[] {res.get(nums[i]), i};
            }
            res.put(lNum, i);
        }
        return new int[0];
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {};
        }

        Map<Integer, Integer> values = new HashMap<>();
        List<int[]> sums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int sumMinus = target - nums[i];
            if (values.get(sumMinus) != null) {
                sums.add(new int[] { i, values.get(sumMinus) });
            }
            values.put(nums[i], i);
        }
        if (sums.size() != 0) {
            Arrays.sort(sums.get(0));
            return sums.get(0);
        }
        return new int[] {};
    }
}
