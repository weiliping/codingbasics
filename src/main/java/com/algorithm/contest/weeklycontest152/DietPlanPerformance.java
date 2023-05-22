package com.algorithm.contest.weeklycontest152;

public class DietPlanPerformance {
    public static void main(String[] args) {
        System.out.println(dietPlanPerformance(new int[] { 1, 2, 3, 4, 5 }, 1, 3, 3));
    }

    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int n = calories.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + calories[i - 1];
        }
        int ans = 0;
        for (int i = 0; i <= n - k; i++) {
            int cal = sums[i + k] - sums[i];
            if (cal > upper) {
                ans++;
            } else if (cal < lower) {
                ans--;
            }
        }
        return ans;
    }
}
