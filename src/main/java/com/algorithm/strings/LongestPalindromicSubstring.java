package com.algorithm.strings;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    /**
     * #5
     * https://leetcode-cn.com/problems/longest-palindromic-substring/
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(longestPalindromeI("abbca"));
//        System.out.println(longestPalindromeI("ababca"));
    }

    public static int longestPalindromeI(String s) {
        int[] rPart = new int[26];
        for (char c : s.toCharArray()) {
            rPart[toInd(c)]++;
        }
        int[] lPart = new int[26];
        int c = 0, n = s.length();
        int max = 0;
        while (c < n) {
            int ind = toInd(s.charAt(c));
            lPart[ind]++;
            rPart[ind]--;
            if (c == 0) {
                c++;
                continue;
            }
            int subMax = 0;
            for (int i = 0; i < 2; i++) {
                int tpl = c - i, tpr = c + 1, tStartInd = tpr - 1, tmpMax = 0;
                while (tpl >= 0 && tpr < n) {
                    char lChr = s.charAt(tpl);
                    if (rPart[toInd(lChr)] != 0) {
                        int lInRightInd = tpr;
                        while (lInRightInd < n && lChr != s.charAt(lInRightInd)) {
                            lInRightInd++;
                        }
                        if (tStartInd < lInRightInd) {
                            if (tmpMax == 0 && tpl + 1 != lInRightInd) {
                                tmpMax += 3;
                            } else {
                                tmpMax += 2;
                            }
                            tStartInd = lInRightInd;
                        }
                    }
                    tpl--;
                }
                subMax = Math.max(subMax, tmpMax);
            }
            max = Math.max(max, subMax);
            c++;
        }
        return max;
    }

    static int toInd(char ch) {
        return ch - 'a';
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
    // Find longest palindrome
    static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}
