package com.algorithm.cyclicsort;

import java.util.Arrays;

public class FindCorruptPair {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findCorruptNumbers(new int[] { 3, 1, 2, 5, 2 })));
        System.out.println(Arrays.toString(findCorruptNumbers(new int[] { 3, 1, 2, 3, 6, 4 })));
    }

    public static int[] findCorruptNumbers(int[] nums) {
        int[] res = new int[2];
        int i = 0, n = nums.length;

        while (i < n) {
            int j = nums[i] - 1;
            if (i != j) {
                if (nums[i] != nums[j]) {
                    int t = nums[j];
                    nums[j] = nums[i];
                    nums[i] = t;
                } else {
                    res[0] = nums[i];
                    i += 1;
                }
                continue;
            }
            i += 1;
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] - 1 != j) {
                res[1] = j + 1;
            }
        }
        return res;
    }
}
