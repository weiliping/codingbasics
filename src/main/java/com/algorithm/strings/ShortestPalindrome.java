package com.algorithm.strings;

public class ShortestPalindrome {

    /**
     * #214
     * https://leetcode-cn.com/problems/shortest-palindrome
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
        System.out.println(shortestPalindrome("abbacd"));
        System.out.println(shortestPalindrome("aabba"));
        System.out.println(shortestPalindromeII("aacecaaa"));
        System.out.println(shortestPalindromeII("abcd"));
        System.out.println(shortestPalindromeII("abbacd"));
        System.out.println(shortestPalindromeII("aabba"));
    }

    public static String shortestPalindrome(String s) {
        int l = 0, n = s.length();
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(l) == s.charAt(j)) {
                l++;
            }
        }
        if (l == n) {
            return s;
        }

        String post = s.substring(l);
        String prefix = new StringBuilder(post).reverse().toString();
        return prefix + shortestPalindrome(s.substring(0, l)) + post;
    }

    public static String shortestPalindromeII(String s) {
        int i = 0, end = s.length() - 1, j = end;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (arr[i] == arr[j]) {
                ++i;
                --j;
            } else {
                i = 0;
                --end;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
