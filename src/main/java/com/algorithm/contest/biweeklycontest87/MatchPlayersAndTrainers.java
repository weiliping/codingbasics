package com.algorithm.contest.biweeklycontest87;

import java.util.Arrays;

public class MatchPlayersAndTrainers {
    public static void main(String[] args) {
//        int[] players = new int[] { 4, 7, 9 }, trainers = new int[] { 8, 2, 5, 8 };
//        System.out.println(matchPlayersAndTrainers(players, trainers));

        int[] players2 = new int[] { 1, 1000000000 }, trainers2 = new int[] { 1000000000, 1 };
        System.out.println(matchPlayersAndTrainers(players2, trainers2));
    }

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length, i = 0, j = 0;
        int cnt = 0;
        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                i++;
                j++;
                cnt++;
                continue;
            }
            j++;
        }
        return cnt;
    }
}
