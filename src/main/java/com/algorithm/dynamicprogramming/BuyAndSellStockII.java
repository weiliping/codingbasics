package com.algorithm.dynamicprogramming;

public class BuyAndSellStockII {

    /**
     * 122. 买卖股票的最佳时机II
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; ++i) {
            res += Math.max(0, prices[i] - prices[i-1]);
        }
        return res;
    }
}
