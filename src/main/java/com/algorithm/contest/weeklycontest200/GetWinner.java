package com.algorithm.contest.weeklycontest200;

public class GetWinner {
    public static void main(String[] args) {
        System.out.println(getWinner(new int[] { 2, 1, 3, 5, 4, 6, 7 }, 2));
        System.out.println(getWinner(new int[] { 3,2,1}, 10));
        System.out.println(getWinner(new int[] { 1,11,22,33,44,55,66,77,88,99}, 1000000000));
        System.out.println(getWinner(new int[] { 1,25,35,42,68,70}, 1));
    }

    public static int getWinner(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        int[] dp = new int[max + 1];
        int[] compare = new int[2];
        compare[0] = arr[0];
        compare[1] = arr[1];
        int s = 2;
        while (s <= arr.length) {
            if (compare[0] < compare[1]) {
                compare[0] = compare[1];
                dp[compare[1]]++;
                if (dp[compare[1]] == k) {
                    return compare[1];
                }
            } else {
                dp[compare[0]]++;
                if (dp[compare[0]] == k) {
                    return compare[0];
                }
            }
            if (s < arr.length) {
                compare[1] = arr[s];
                s++;
            }
            if (compare[0] == max) {
                return compare[0];
            }
        }
        return 0;
    }
}
