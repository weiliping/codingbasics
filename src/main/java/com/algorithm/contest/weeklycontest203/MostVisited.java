package com.algorithm.contest.weeklycontest203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostVisited {

    /**
     *
     * https://leetcode-cn.com/problems/most-visited-sector-in-a-circular-track/
     * @param args
     */
    public static void main(String[] args) {
        int n = 4;
        int[] rounds = new int[] {1, 3, 1, 2};
        System.out.println(Arrays.toString(mostVisited(n, rounds).toArray()));
        int n1 = 2;
        int[] rounds1 = new int[] {2, 1, 2, 1, 2, 1, 2, 1, 2};
        System.out.println(Arrays.toString(mostVisited(n1, rounds1).toArray()));
        int n2 = 7;
        int[] rounds2 = new int[] {1,3,5,7};
        System.out.println(Arrays.toString(mostVisited(n2, rounds2).toArray()));
    }
    public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int[] dp = new int[n + 1];
        dp[rounds[0]]++;
        for (int i = 1; i < rounds.length; i++) {
            int t = rounds[i - 1];
            int end = rounds[i] < t ? rounds[i] + n : rounds[i];
            while(t <= end) {
                if (t == rounds[i - 1]) {
                    t++;
                    continue;
                }
                int round = t > n ? t - n : t;
                dp[round]++;
                max = Math.max(max, dp[round]);
                t++;
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}
