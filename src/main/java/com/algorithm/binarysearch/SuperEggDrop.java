package com.algorithm.binarysearch;

public class SuperEggDrop {
    /**
     * #887
     * https://leetcode-cn.com/problems/super-egg-drop/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(superEggDrop(1, 2));
        System.out.println(superEggDrop(2, 6));
        System.out.println(superEggDrop(3, 14));
    }

    public static int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int res = 0;
        for (; dp[K] < N; res++) {
            for (int i = K; i > 0; i--) {
                dp[i] = dp[i] + dp[i - 1] + 1;
            }
        }
        return res;
    }
}
