package com.algorithm.arrays;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * #16
     * https://leetcode-cn.com/problems/3sum-closest/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { -1, 2, 1, -4 };
        System.out.println(threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] * 3 > target) {
                return Math.min(closest, nums[i] + nums[i + 1] + nums[i + 2]);
            }
            int l = i + 1, r = n - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int newDiff = Math.abs(sum - target);
                if (diff > newDiff) {
                    diff = newDiff;
                    closest = sum;
                }
                if ((sum < target)) {l++;} else {r--;}
            }
        }
        return closest;
    }

    public int threeSumClosestSelf(int[] nums, int target) {
        int sum = 0, closest = Integer.MAX_VALUE, n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sumSub = nums[i] + nums[j] + nums[k];
                    int sub = Math.abs(sumSub - target);
                    if (closest > sub) {
                        sum = sumSub;
                        closest = sub;
                    }
                }
            }
        }
        return sum;
    }
}
