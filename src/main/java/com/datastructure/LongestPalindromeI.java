package com.datastructure;

public class LongestPalindromeI {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a", "a"));
    }
    public static int longestPalindrome(String s, String t) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = t.length() - 1; j >= 0; j--) {
                res = Math.max(res, maxPLen(s.substring(0, i + 1)+ t.substring(j)));
            }
        }
        return res;
    }
    
    public static int maxPLen(String s) {
        int n = s.length();
        if (n < 2) {
            return n;
        }
        
        int max = 1;
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            max = Math.max(max, Math.max(len1, len2));
        }
        return max;
    }
    private static int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
