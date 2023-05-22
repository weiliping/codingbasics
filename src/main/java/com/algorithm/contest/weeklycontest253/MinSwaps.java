package com.algorithm.contest.weeklycontest253;

public class MinSwaps {

    public static void main(String[] args) {
        MinSwaps m = new MinSwaps();
        System.out.println(m.minSwaps("][]["));
        System.out.println(m.minSwaps("]]][[["));
        System.out.println(m.minSwaps("[]"));
    }

    public int minSwaps(String s) {
        int cnt = 0;
        char[] chrs = s.toCharArray();
        for (char c : chrs) {
            if (c == '[') {
                cnt++;
                continue;
            }
            if (cnt > 0) {
                cnt--;
            }
        }
        if (cnt == 0) {
            return 0;
        }
        int res = cnt >> 1;
        return (cnt & 1) == 0 ? res : (res + 1);
    }
}
