package com.algorithm.contest.weeklycontest325;

import java.util.Arrays;

public class MaximumTastiness {
    public static void main(String[] args) {

    }

    public static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int l = 0, r = ((price[n - 1] - price[0]) / (k - 1) + 1);

        while (l + 1 < r) {
            int mid = l + ((r - l) >> 1);
            if (isValid(price, mid, k)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static boolean isValid(int[] prices, int d, int k) {
        int cnt = 1, x = prices[0];
        for (int p : prices) {
            if (p >= x + d) {
                cnt++;
                x = p;
            }
        }
        return cnt >= k;
    }
}
