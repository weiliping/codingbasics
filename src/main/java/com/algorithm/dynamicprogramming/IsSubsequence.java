package com.algorithm.dynamicprogramming;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("ace", "abcde"));
        System.out.println(isSubsequence("aec", "abcde"));
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
    }
    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }
        int tStart = 0, m = s.length(), n = t.length();
        for (int i = 0; i < m; i++) {
            boolean isMatch = false;
            for (int j = tStart; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    isMatch = true;
                    tStart = j + 1;
                    break;
                } else {
                    continue;
                }
            }
            if (!isMatch) {
                return false;
            }
        }
        return true;
    }
}
