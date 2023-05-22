package com.algorithm.contest.weeklycontest226;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 *
 * 你按照如下规则进行一场游戏：
 *
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，用以给出 queries 中每一项的对应答案。此数组满足：
 *
 * answer.length == queries.length 。answer[i] 是 queries[i] 的答案。
 * answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。
 * 注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 *
 * 请你返回得到的数组 answer 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 * 示例 2：
 *
 * 输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * 输出：[false,true,true,false,false]
 *  
 *
 * 提示：
 *
 * 1 <= candiesCount.length <= 10^5
 * 1 <= candiesCount[i] <= 10^5
 * 1 <= queries.length <= 10^5
 * queries[i].length == 3
 * 0 <= favoriteTypei < candiesCount.length
 * 0 <= favoriteDayi <= 10^9
 * 1 <= dailyCapi <= 10^9
 *
 */
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
