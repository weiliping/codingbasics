package com.algorithm.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class MincostTickets {

    /**
     * #983
     * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 }));
        System.out.println(mincostTickets(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, new int[] { 2, 7, 15 }));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daysArray = new HashSet<>();
        for (int i : days) {
            daysArray.add(i);
        }
        Integer[] dp = new Integer[366];
        return cost(1, costs, dp, daysArray);
    }

    static int cost(int i, int[] costs, Integer[] dp, Set<Integer> daysArray) {
        if (i > 365) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }

        if (daysArray.contains(i)) {
            int minCost = Math.min(cost(i + 1, costs, dp, daysArray) + costs[0],
                    cost(i + 7, costs, dp, daysArray) + costs[1]);
            dp[i] = Math.min(minCost, cost(i + 30, costs, dp, daysArray) + costs[2]);
        } else {
            dp[i] = cost(i + 1, costs, dp, daysArray);
        }
        return dp[i];
    }
}
