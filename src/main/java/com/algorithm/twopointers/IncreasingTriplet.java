package com.algorithm.twopointers;

public class IncreasingTriplet {
    /**
     * #334
     * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(increasingTripletI(new int[] { 1, 2, 3, 4, 5 }));
    }

    public static boolean increasingTripletI(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= a) {
                a = nums[i];
            } else if (nums[i] <= b) {
                b = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean increasingTriplet(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            int j = i - 1, k = i + 1;
            while (j >= 0 && k < nums.length) {
                if (nums[i] > nums[j] && nums[i] < nums[k]) {
                    return true;
                }
                if (nums[i] <= nums[j]) {
                    j--;
                }
                if (nums[i] >= nums[k]) {
                    k++;
                }
            }
        }
        return false;
    }

}
