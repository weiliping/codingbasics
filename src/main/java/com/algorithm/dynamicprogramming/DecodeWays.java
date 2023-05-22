package com.algorithm.dynamicprogramming;

public class DecodeWays {

    /**
     * #91
     * https://leetcode-cn.com/problems/decode-ways
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12"));
    }

    public int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0') {
            return 0;
        }
        int f0 = 1, f1 = 1, n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                f1 = 0;
            }
            int num = charToInt(s.charAt(i)) + charToInt(s.charAt(i - 1)) * 10;
            if (num < 10 || num > 26) {
                f0 = 0;
            }
            int tmp = f1;
            f1 = f1 + f0;
            f0 = tmp;
        }
        return f1;
    }

    private int charToInt(char ch) {
        return ch - '0';
    }
}
