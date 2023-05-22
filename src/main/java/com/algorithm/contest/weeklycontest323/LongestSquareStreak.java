package com.algorithm.contest.weeklycontest323;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSquareStreak {

    public static void main(String[] args) {
        int[] nums = new int[99985];
        for (int i = 0; i < 99985; i++) {
            int j = i;
            nums[i] = j + 15;
        }
        System.out.println(longestSquareStreak(new int[] { 4, 3, 6, 16, 8, 2 }));
        System.out.println(longestSquareStreak(new int[] { 3, 9, 81, 6561 }));
        System.out.println(longestSquareStreak(nums));
        Map<Integer, Integer> map = new HashMap<>();

    }

    public static int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, max = nums[n - 1];
        int[] cnts = new int[max + 1];
        for (int i = 0; i < n; i++) {
            cnts[nums[i]]++;
        }
        int half = (int) Math.ceil(Math.sqrt((double) max));
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > half) {
                break;
            }
            int cnt = 1;
            int sub = nums[i] * nums[i];
            while (sub <= max && cnts[sub] > 0) {
                cnt++;
                if (sub > half) {
                    break;
                }
                sub *= sub;
            }
            if (cnt >= 2 && res < cnt) {
                res = cnt;
            }
        }
        return res;
    }
}
