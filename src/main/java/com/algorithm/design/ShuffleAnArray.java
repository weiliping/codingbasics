package com.algorithm.design;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

    /**
     * #384
     * https://leetcode-cn.com/problems/shuffle-an-array/
     * @param args
     */
    public static void main(String[] args) {
        ShuffleAnArray s = new ShuffleAnArray(new int[] {1, 2, 3});
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
        System.out.println(Arrays.toString(s.shuffle()));
    }

    int[] nums;
    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = Arrays.copyOfRange(nums, 0, nums.length);
        Random rd = new Random();
        int n = res.length;
        for (int i = 0; i < n; i++) {
            int t = i + Math.abs(rd.nextInt() % (n - i));
            int tmp = res[t];
            res[t] = res[i];
            res[i] = tmp;
        }
        return res;
    }
}
