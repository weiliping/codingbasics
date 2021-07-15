package com.algorithm.math;

public class Atoi {

    /**
     * #8 字符串转换整数 (atoi)
     * https://leetcode-cn.com/problems/string-to-integer-atoi
     *
     * @param args
     */
    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("42"));
        System.out.println(atoi.myAtoi("  -42"));
        System.out.println(atoi.myAtoi("4193 with words"));
        System.out.println(atoi.myAtoi("words and 987"));
        System.out.println(atoi.myAtoi("-91283472332"));
    }

    public int myAtoi(String str) {
        if (str == null || str.trim().length() < 1) {
            return 0;
        }

        // trim white spaces
        str = str.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }
}
