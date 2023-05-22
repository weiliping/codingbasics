package com.algorithm.contest.weeklycontest252;

public class NumberOfWeeks {

    public static void main(String[] args) {
        NumberOfWeeks n = new NumberOfWeeks();
        System.out.println(n.numberOfWeeks(new int[] {1, 2, 3}));
        System.out.println(n.numberOfWeeks(new int[] {5, 2, 1}));
        System.out.println(n.numberOfWeeks(new int[] { 5, 7, 5, 7, 9, 7 }));
        System.out.println(n.numberOfWeeks(new int[] { 4,5,5,2}));
    }
    public long numberOfWeeks(int[] milestones) {
        int n = milestones.length, max = milestones[0];
        long sum = 0l;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, milestones[i]);
            sum += milestones[i];
        }
        sum -= max;
        if (max > sum + 1) {
            return ((sum << 1) + 1);
        }
        return sum + max;
    }
}
