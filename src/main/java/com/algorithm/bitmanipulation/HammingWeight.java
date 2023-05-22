package com.algorithm.bitmanipulation;

public class HammingWeight {
    /**
     * #191
     * https://leetcode-cn.com/problems/number-of-1-bits/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(hammingWeight(3));
    }

    public static int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                cnt++;
            }
            n = n >> 1;
        }
        return cnt;
    }
}
