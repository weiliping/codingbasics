package com.algorithm.contest.biweeklycontest63;

import java.util.Arrays;

public class MinMovesToSeat {
    public static void main(String[] args) {
        MinMovesToSeat m = new MinMovesToSeat();
        System.out.println(m.minMovesToSeat(new int[]{12,14,19,19,12}, new int[]{19,2,17,20,7}));
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        int sum = 0, n = seats.length;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < n; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }
        return sum;
    }
}
