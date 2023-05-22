package com.algorithm.dynamicprogramming;

public class NumArray {
    static int sum;
    static int[] nums;

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }

    public NumArray(int[] numArray) {
        nums = numArray;
    }

    public int sumRange(int i, int j) {
        sum = 0;
        for (int s = i; s <= j && s < nums.length; s++) {
            sum += nums[s];
        }
        return sum;
    }
}
