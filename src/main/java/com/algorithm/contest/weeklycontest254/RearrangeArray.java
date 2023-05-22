package com.algorithm.contest.weeklycontest254;

import java.util.ArrayDeque;
import java.util.Arrays;

public class RearrangeArray {
    public static void main(String[] args) {
        RearrangeArray r = new RearrangeArray();
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(r.rearrangeArray(nums)));

        int[] nums2 = new int[] { 1, 2, 3 };
        System.out.println(Arrays.toString(r.rearrangeArray(nums2)));
    }

    public int[] rearrangeArray(int[] nums) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.sort(nums);
        queue.addFirst(nums[0]);
        queue.addFirst(nums[1]);
        int n = nums.length, j = n - 1, i = 2;

        while (i <= j) {
            int curr = queue.pollFirst();
            if (queue.peekFirst() + nums[i] != (curr << 1)) {
                queue.addFirst(curr);
                queue.addFirst(nums[i++]);
                continue;
            }
            queue.addFirst(curr);
            if (nums[i] != nums[j]) {
                queue.addFirst(nums[j]);
                queue.addFirst(nums[i++]);
                j--;
                continue;
            }
            queue.addFirst(queue.pollLast());
            queue.addFirst(nums[i++]);
        }

        int[] res = new int[n];
        int k = 0;
        while (!queue.isEmpty()) {
            res[k] = queue.pollLast();
            k++;
        }
        return res;
    }
}
