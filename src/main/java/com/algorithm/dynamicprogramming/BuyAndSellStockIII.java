package com.algorithm.dynamicprogramming;

public class BuyAndSellStockIII {

    /**
     * 123. 买卖股票的最佳时机III
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
        System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int[] l = new int[3], g = new int[3];
        for (int i = 1; i < prices.length; ++i) {
            int diff = prices[i] - prices[i-1];
            for (int j = 2; j > 0; j--) {
                l[j] = Math.max(g[j - 1] + Math.max(0, diff), l[j] + diff);
                g[j] = Math.max(g[j], l[j]);
            }
        }
        return g[2];
    }
}
