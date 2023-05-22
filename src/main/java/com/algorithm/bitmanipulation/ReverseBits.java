package com.algorithm.bitmanipulation;

public class ReverseBits {

    /**
     * #190
     * https://leetcode-cn.com/problems/reverse-bits/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res = (res << 1) + 1;
            } else {
                res = res << 1;
            }
            n = n >> 1;
        }
        return res;
    }
}
