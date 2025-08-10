package com.algorithm.contest.weeklycontest461;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxBalancedShipments {

    public static void main(String[] args) {
        MaxBalancedShipments mbs = new MaxBalancedShipments();
        int[] weight = {2,5,1,4,3};
        System.out.println(mbs.maxBalancedShipments(weight)); // Output: 2
    }
    public int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        int[] firstGreater = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(firstGreater, -1);
        for (int i = n - 1; i > -1; i--) {
            while (!stack.isEmpty() && weight[stack.peek()] < weight[i]) {
                firstGreater[stack.pop()] = i;
            }
            stack.push(i);
        }
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            int j = firstGreater[i];
            if (j != -1) {
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + 1);
            }
        }
        return dp[n];
    }
}
