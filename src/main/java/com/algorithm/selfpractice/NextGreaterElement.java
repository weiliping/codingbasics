package com.algorithm.selfpractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] nums = {4, 4};
        System.out.println(Arrays.toString(nge.nextGreaterElement(nums))); // Output: [5, 10, 10, -1, -1]
    }
    public int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        for (int i = n - 1; i > -1; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return result;
    }
}
