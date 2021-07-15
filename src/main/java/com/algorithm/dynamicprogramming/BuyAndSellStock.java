package com.algorithm.dynamicprogramming;

public class BuyAndSellStock {

    /**
     * 121. 买卖股票的最佳时机
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int n = prices.length, res = Integer.MIN_VALUE, minVal = prices[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, prices[i] - minVal);
            minVal = Math.min(prices[i], minVal);
        }

        return res < 0 ? 0 : res;
    }
}
