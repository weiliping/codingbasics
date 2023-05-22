package com.algorithm.cyclicsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates {
    /**
     * #442
     * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }).toArray()));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] > 0) {
                nums[j] = -nums[j];
                continue;
            }
            res.add(j + 1);
        }
        return res;
    }
}
