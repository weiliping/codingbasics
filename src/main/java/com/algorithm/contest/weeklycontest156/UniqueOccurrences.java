package com.algorithm.contest.weeklycontest156;

import java.util.HashMap;
import java.util.Map;

public class UniqueOccurrences {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[] {2, 3, 2, 1, 2, 1}));
    }
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        boolean[] dp = new boolean[1001];
        for (Integer v : mp.values()) {
            if (!dp[v]) {
                dp[v] = true;
                continue;
            }
            return false;
        }
        return true;
    }
}
