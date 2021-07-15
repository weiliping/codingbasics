package com.algorithm.strings;

public class ValidPalindrome {

    /**
     * #125
     * https://leetcode-cn.com/problems/valid-palindrome/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int si = 0, ei = s.length() - 1;
        while (si <= ei) {
            char sChar = Character.toLowerCase(s.charAt(si));
            if (!isValiChar(sChar)) {
                si++;
                continue;
            }
            char eChar = Character.toLowerCase(s.charAt(ei));
            if (!isValiChar(eChar)) {
                ei--;
                continue;
            }
            if (isValiChar(sChar) && isValiChar(eChar) && sChar != eChar) {
                return false;
            } else {
                si++;
                ei--;
            }
        }
        return true;
    }

    static boolean isValiChar(int a) {
        if (a >= 97 && a <= 122) {
            return true;
        }
        return a >= 48 && a <= 57;
    }
}
