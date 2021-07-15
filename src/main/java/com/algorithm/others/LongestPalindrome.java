package com.algorithm.others;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int maxLenght = 1, start = 0, low = 0, high = 0, len = s.length();
        for (int i = 0; i < len; ++i) {
            low = i - 1;
            high = i;

            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                int subLength = high - low + 1;
                if (subLength > maxLenght) {
                    start = low;
                    maxLenght = subLength;
                }
                --low;
                ++high;
            }

            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                int subLength = high - low + 1;
                if (subLength > maxLenght) {
                    start = low;
                    maxLenght = subLength;
                }
                --low;
                ++high;
            }
        }
        return s.substring(start, start + maxLenght);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
