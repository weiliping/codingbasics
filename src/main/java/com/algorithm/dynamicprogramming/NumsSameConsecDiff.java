package com.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumsSameConsecDiff {

    /**
     * #967
     * https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(numsSameConsecDiff(2, 1)));
//        System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(numsSameConsecDiff(4, 4)));
    }

    public static int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> cur = new HashSet<>();

        for (int i = 1; i < 10; i++) {
            cur.add(i);
        }

        for (int s = 1; s < N; s++) {
            Set<Integer> cur2 = new HashSet<>();

            for (int x : cur) {
                int d = x % 10;

                if (d - K >= 0) {
                    cur2.add(10 * x + (d - K));
                }

                if (d + K <= 9) {
                    cur2.add(10 * x + (d + K));
                }
            }

            cur = cur2;
        }

        if (N == 1) {
            cur.add(0);
        }

        int[] ans = new int[cur.size()];
        int i = 0;
        for (int x : cur) {
            ans[i++] = x;
        }
        return ans;
    }
}
