package com.algorithm.dynamicprogramming;

public class RegularExpressionMatch {

    /**
     * #10
     * https://leetcode-cn.com/problems/regular-expression-matching/
     * https://www.interviewbit.com/problems/regular-expression-ii/
     * https://xiaokangstudynotes.com/2017/01/21/dynamic-programming-regular-expression-matching/
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatchDP("mississippi", "mis*is*p*."));
    }

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean isFirstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (isFirstMatch && isMatch(s.substring(1), p));
        }
        return isFirstMatch && isMatch(s.substring(1), p.substring(1));
    }

    public static boolean isMatchDP(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] match = new boolean[len1 + 1][len2 + 1];
        match[0][0] = true;
        for (int i = 0; i < len2; i++) {
            if (p.charAt(i) == '*' && match[0][i - 1]) {
                match[0][i + 1] = true;
            }
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    match[i + 1][j + 1] = match[i][j];
                }

                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i)) {
                        match[i + 1][j + 1] = match[i + 1][j - 1];
                    } else {
                        match[i + 1][j + 1] = match[i + 1][j] || match[i][j + 1] || match[i + 1][j - 1];
                    }
                }
            }
        }
        return match[len1][len2];
    }
}
