package com.algorithm.contest.weeklycontest315;

public class FindMaxK {
    public static void main(String[] args) {
        System.out.println(findMaxK(new int[] { -1, 2, -3, 3 }));
        System.out.println(findMaxK(new int[] { -1, 10, 6, 7, -7, 1 }));
    }

    public static int findMaxK(int[] nums) {
        boolean[] cnt = new boolean[2001];
        for (int num : nums) {
            if (num < 0) {
                cnt[1000 + num] = true;
            }
        }
        int res = -1;
        for (int num : nums) {
            if (num > 0) {
                if (cnt[1000 - num] && res < num) {
                    res = num;
                }
            }
        }
        return res;
    }
}
