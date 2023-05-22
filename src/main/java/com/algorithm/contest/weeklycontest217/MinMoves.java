package com.algorithm.contest.weeklycontest217;

import java.util.HashMap;
import java.util.Map;

public class MinMoves {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2, 1};
        int n = nums.length, h = n / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < h; i++) {
            int sum = nums[i] + nums[n - i - 1];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("as");
    }

    public int minMoves(int[] nums, int limit) {
        return 0;
    }
}
