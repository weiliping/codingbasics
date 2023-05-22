package com.algorithm.others;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerNumbers {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 6, 4, 10, 2, 5 };
        NearestSmallerNumbers sNum = new NearestSmallerNumbers();
        System.out.println(Arrays.toString(sNum.nearestSmallerNumbers(nums)));
    }

    public int[] nearestSmallerNumbers(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int[] nestNums = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!s.empty() && s.peek() >= nums[i]) {
                s.pop();
            }
            if (s.empty()) {
                nestNums[i] = -1;
            } else {
                nestNums[i] = s.peek();
            }
            s.push(nums[i]);
        }
        return nestNums;
    }
}
