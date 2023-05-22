package com.algorithm.contest.weeklycontest192;

import java.util.Arrays;

public class Shuffle {
    public static void main(String[] args) {
        Shuffle s = new Shuffle();
        System.out.println(Arrays.toString(s.shuffle(new int[]{2,5,1,3,4,7}, 3)));
    }
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            if ((i & 1) == 0) {
                res[i] = nums[(i >> 1)];
            } else {
                res[i] = nums[(i >> 1) + n];
            }
        }
        return res;
    }
}
