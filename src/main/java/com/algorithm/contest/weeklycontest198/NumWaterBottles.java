package com.algorithm.contest.weeklycontest198;

class NumWaterBottles {

    /**
     * #1518
     * https://leetcode-cn.com/problems/water-bottles/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int sum = 0, count = 0;
        while (numBottles > 0) {
            sum += numBottles;
            count += numBottles;
            numBottles = count / numExchange;
            count %= numExchange;
        }
        return sum;
    }
}