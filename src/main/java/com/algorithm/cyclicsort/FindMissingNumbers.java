package com.algorithm.cyclicsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMissingNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 }).toArray()));
    }

    public static List<Integer> findMissingNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int j = nums[i] - 1, t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
