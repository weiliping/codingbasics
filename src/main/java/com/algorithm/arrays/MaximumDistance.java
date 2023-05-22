package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumDistance {

    /**
     * https://www.interviewbit.com/problems/max-distance/
     *
     * Description:
     * A : [3 5 4 2]
     *
     * Output : 2
     * for the pair (3, 4)
     *
     * @param args
     */
    public static void main(String[] args) {
        MaximumDistance maxDis = new MaximumDistance();
        int maxDist = maxDis.maximumDistance(new int[] { 3, 5, 4, 2 });
        System.out.println(maxDist);
    }

    public int maximumDistance(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        List<Helper> helpers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            helpers.add(new Helper(i, nums[i]));
        }
        Collections.sort(helpers);

        int maxValue = Integer.MIN_VALUE;
        int[] rightMax = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            maxValue = Math.max(maxValue, helpers.get(i).index);
            rightMax[i] = maxValue;
        }

        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, rightMax[i] - helpers.get(i).index);
        }
        return maxDiff;
    }

    class Helper implements Comparable<Helper> {

        public int index;
        public int value;

        public Helper(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Helper helper) {
            if (value > helper.value) {
                return 1;
            } else if (value < helper.value) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int maxDiff = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] >= nums[i] && maxDiff < j - i) {
                    maxDiff = j - i;
                }
            }
        }
        return maxDiff;
    }
}
