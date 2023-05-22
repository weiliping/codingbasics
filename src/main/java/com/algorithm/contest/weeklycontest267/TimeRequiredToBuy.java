package com.algorithm.contest.weeklycontest267;

public class TimeRequiredToBuy {
    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[] {5, 1, 1, 1}, 0));
    }
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int total = 0, n = tickets.length, lessK = tickets[k] - 1;
        for (int i = 0; i < n; i++) {
            if (i <= k) {
                total += Math.min(tickets[i], tickets[k]);
            } else {
                total += Math.min(tickets[i], lessK);
            }
        }
        return total;
    }
}
