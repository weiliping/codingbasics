package com.algorithm.math;

public class Palindrome {

    /**
     * #9 回文数
     * https://leetcode-cn.com/problems/palindrome-number/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(-10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverseNum = 0, y = x;

        while (y > 0) {
            reverseNum = reverseNum * 10 + y % 10;
            y = y / 10;
        }
        return x == reverseNum;
    }
}
