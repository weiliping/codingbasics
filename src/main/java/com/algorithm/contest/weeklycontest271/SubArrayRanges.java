package com.algorithm.contest.weeklycontest271;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SubArrayRanges {
    public static void main(String[] args) {
//        System.out.println(subArrayRanges(new int[]{1, 2, 3}));
//        System.out.println(subArrayRanges(new int[]{1, 3, 3}));
//        System.out.println(subArrayRanges(new int[] { 4, -2, -3, 4, 1 }));
//        System.out.println(subArrayRanges(new int[] { -3, -2, 1, 4 }));
//        dfs(new int[] { 4, -2, -3, 4, 1 }, new ArrayList<>(), 0, 5);
    }
    public static long subArrayRanges(int[] nums) {
        long sum = 0l;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int max = nums[i], min = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                if (nums[j] < min) {
                    min = nums[j];
                }
                sum += max - min;
            }
        }
        return sum;
    }
}
