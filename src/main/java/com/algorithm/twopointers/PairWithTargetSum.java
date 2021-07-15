package com.algorithm.twopointers;

import java.util.Arrays;

public class PairWithTargetSum {

    /**
     * https://github.com/weiliping/Grokking-the-Coding-Interview-Patterns-for-Coding-Questions/blob/master/2.%20Pattern%20Two%20Pointers/Pair%20with%20Target%20Sum%20(easy).py
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 6};
        int target = 6;
        System.out.println(Arrays.toString(pairWithTargetSum(nums, target)));
    }

    public static int[] pairWithTargetSum(int[] nums, int target) {
        int[] pair = new int[] { -1, -1 };

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            if (nums[l] + nums[r] == target) {
                pair[0] = l;
                pair[1] = r;
                return pair;
            }
            if (nums[l] + nums[r] > target) {
                r--;
                continue;
            }
            l++;
        }
        return pair;
    }
}
