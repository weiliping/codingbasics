package com.algorithm.contest.weeklycontest202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistance {
    public static void main(String[] args) {
        int[] position = new int[] {1,2,3,4,7};
        maxDistance(position, 3);
    }

    public static int maxDistance(int[] position, int m) {
        List<Integer> diff = new ArrayList<>();

        int n = position.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                diff.add(Math.abs(position[i] - position[j]));
            }
        }
        System.out.println(Arrays.toString(diff.toArray()));
        return 0;
    }
}
