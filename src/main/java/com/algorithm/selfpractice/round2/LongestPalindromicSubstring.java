package com.algorithm.selfpractice.round2;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int l, r, start = 0, maxLen = 0, sLen = s.length();

        for (int i = 0; i < sLen; i++) {
            l = i - 1;
            r = i;
            while (l >= 0 && r < sLen && s.charAt(l) == s.charAt(r)) {
                int subLength = r - l + 1;
                if (subLength > maxLen) {
                    start = l;
                    maxLen = subLength;
                }
                l--;
                r++;
            }

            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < sLen && s.charAt(l) == s.charAt(r)) {
                int subLength = r - l + 1;
                if (subLength > maxLen) {
                    start = l;
                    maxLen = subLength;
                }
                l--;
                r++;
            }
        }
        return s.substring(start, maxLen + start);
    }
}
