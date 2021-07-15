package com.algorithm.contest.weeklycontest226;

import java.util.Arrays;

public class FavoriteCandies {

    public static void main(String[] args) {
//        int[] candiesCount = new int[] {7, 4, 5, 3, 8};
//        int[][] queries = new int[][] {{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}};
//        System.out.println(Arrays.toString(haveFavoriteCandies(candiesCount, queries)));
//
//        int[] candiesCount1 = new int[] {5, 2, 6, 4, 1};
//        int[][] queries1 = new int[][] {{3, 1, 2}, {4, 10, 3}, {3, 10, 100}, {4, 100, 30}, {1, 3, 1}};
//        System.out.println(Arrays.toString(haveFavoriteCandies(candiesCount1, queries1)));

//        int[] candiesCount1 = new int[] {5215,14414,67303,93431,44959,34974,22935,64205,28863,3436,45640,34940,38519,5705,14594,30510,4418,87954,8423,65872,79062,83736,47851,64523,15639,19173,88996,97578,1106,17767,63298,8620,67281,76666,50386,97303,26476,95239,21967,31606,3943,33752,29634,35981,42216,88584,2774,3839,81067,59193,225,8289,9295,9268,4762,2276,7641,3542,3415,1372,5538,878,5051,7631,1394,5372,2384,2050,6766,3616,7181,7605,3718,8498,7065,1369,1967,2781,7598,6562,7150,8132,1276,6656,1868,8584,9442,8762,6210,6963,4068,1605,2780,556,6825,4961,4041,4923,8660,4114};
//        int[][] queries1 = new int[][] {{91,244597,840227137}};
//        System.out.println(Arrays.toString(haveFavoriteCandies(candiesCount1, queries1)));
        int[] candiesCount2 = new int[] {46,5,47,48,43,34,15,26,11,25,41,47,15,25,16,50,32,42,32,21,36,34,50,45,46,15,46,38,50,12,3,26,26,16,23,1,4,48,47,32,47,16,33,23,38,2,19,50,6,19,29,3,27,12,6,22,33,28,7,10,12,8,13,24,21,38,43,26,35,18,34,3,14,48,50,34,38,4,50,26,5,35,11,2,35,9,11,31,36,20,21,37,18,34,34,10,21,8,5};
        int[][] queries2 = new int[][] {{86,608,4}};
        System.out.println(Arrays.toString(haveFavoriteCandies(candiesCount2, queries2)));
    }

    public static boolean[] haveFavoriteCandies(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + candiesCount[i];
        }
        int m = queries.length;
        boolean[] res = new boolean[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            long eS = sums[q[0]];
            long eE = sums[q[0] + 1];
            long s = q[1] + 1;
            long e = s * q[2];
            if (eS < e && s <= eE) {
                res[i] = true;
            }
        }
        return res;
    }
}
