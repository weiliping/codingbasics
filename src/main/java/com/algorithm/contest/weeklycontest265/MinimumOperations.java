package com.algorithm.contest.weeklycontest265;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class MinimumOperations {

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 3}, 6, 4));
        System.out.println(minimumOperations(new int[]{2, 4, 12}, 2, 12));
        System.out.println(minimumOperations(new int[]{3, 5, 7}, 0, -4));
        System.out.println(minimumOperations(new int[]{2, 8, 16}, 0, 1));
        System.out.println(minimumOperations(new int[]{1}, 0, 3));
    }
    public static int minimumOperations(int[] nums, int start, int goal) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int n = nums.length;
        queue.offer(new int[]{start, 0});
        Set<Integer> sets = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] > 1000 || cur[0] < 0 || (cur[0] == start && cur[1] != 0)) {
                continue;
            }
            int currSteps = cur[1] + 1;
            for (int i = 0; i < n; i++) {
                int[] curVals = new int[] {cur[0] + nums[i], cur[0] - nums[i], cur[0] ^ nums[i]};
                if (curVals[0] == goal || curVals[1] == goal || curVals[2] == goal) {
                    return currSteps;
                }
                for (int j = 0; j < 3; j++) {
                    if (curVals[j] >= 0 && curVals[j] <= 1000 && !sets.contains(curVals[j])) {
                        queue.offer(new int[] { curVals[j], currSteps });
                        sets.add(curVals[j]);
                    }
                }
            }
        }
        return -1;
    }
}


