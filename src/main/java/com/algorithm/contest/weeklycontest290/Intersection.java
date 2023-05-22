package com.algorithm.contest.weeklycontest290;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

    public static List<Integer> intersection(int[][] nums) {
        int[] cnts = new int[1001];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int num : nums[i]) {
                cnts[num]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            if (cnts[i] == n) {
                res.add(i);
            }
        }
        return res;
    }
}
