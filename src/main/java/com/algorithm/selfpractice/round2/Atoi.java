package com.algorithm.selfpractice.round2;

public class Atoi {

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("42"));
        System.out.println(atoi.myAtoi("  -42"));
        System.out.println(atoi.myAtoi("4193 with words"));
        System.out.println(atoi.myAtoi("words and 987"));
        System.out.println(atoi.myAtoi("-91283472332"));
    }

    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        str = str.trim();
        int i = 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            i++;
        }

        int len = str.length();

        double res = 0;
        while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (str.charAt(0) == '-') {
            res = -res;
        }

        if (res < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }

        if (res > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }

        return (int) res;
    }
}
