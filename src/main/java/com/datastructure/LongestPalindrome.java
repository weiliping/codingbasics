package com.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        // String s = "b", t = "aaaa";
        // System.out.println(l.longestPalindrome(s, t));
        String s = "abcdedc";
        String t = "ccba";
        // System.out.println(Arrays.toString(maxPalindrome(s)));
        // System.out.println(Arrays.toString(maxRight(t)));
        System.out.println(l.longestPalindrome(s, t));

        String s1 = "abcde";
        String t1 = "ecdba";
        // System.out.println(Arrays.toString(maxPalindrome(s1)));
        // System.out.println(Arrays.toString(maxRight(t1)));
        System.out.println(l.longestPalindrome(s1, t1));

        String s2 = "mlyyy";
        String t2 = "km";
        // System.out.println(Arrays.toString(maxPalindrome(s2)));
        // System.out.println(Arrays.toString(maxRight(t2)));
        System.out.println(l.longestPalindrome(s2, t2));
    }
    public int longestPalindrome(String s, String t) {
        int m = s.length(), n = t.length();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] p = maxPalindrome(s);
        int[] q = maxRight(t);
        int[][] dp = new int[m + 1][n + 1];
        int res = 1;
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = p[i];
            res = Math.max(res, p[i]);
        }

        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = q[j];
            res = Math.max(res, q[j]);
        }

        for (int i = m - 1; i >= 0 ; i--) {
            int k = m - i;
            for (int j = 0; j < n; j++) {
                int tk = j + 1;
                if (sc[i] != tc[j]) {
                    dp[k][tk] = Math.max(p[k], q[tk]);
                } else {
                    dp[k][tk] = Math.max(Math.max(p[k], q[tk]), dp[k - 1][tk - 1] + 2);
                }  
                res = Math.max(res, dp[k][tk]);  
            }
        }
        return res;
    }

    public static int[] maxPalindrome(String s) {
        int n = s.length();
        char[] chrs = s.toCharArray();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        List<Integer>[] conts = new ArrayList[26];
        for (int i = 0; i < n; i++) {
            int ind = chrs[i] - 'a';
            if (conts[ind] == null) {
                conts[ind] = new ArrayList<Integer>();
            }
            conts[ind].add(Integer.valueOf(i));
        }
        for (int i = 0; i < n; i++) {
            int ind = chrs[i] - 'a';
            int k = n - i;
            if (conts[ind].size() > 1) {
                for (int j = conts[ind].size() - 1; j > 0; j--) {
                    int e = conts[ind].get(j).intValue();
                    int l = i + 1, r = e - 1;
                    while (l < r && chrs[l] == chrs[r]) {
                        l++;
                        r--;
                    }
                    if (l == r || r + 1 == l) {
                        dp[k] = Math.max(dp[k], e - i + 1);
                        break;
                    }
                }
                conts[ind].removeFirst();
            }
        }
        return dp;
    }
    public static int[] maxRight(String s) {
        int n = s.length();
        char[] chrs = s.toCharArray();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        List<Integer>[] conts = new ArrayList[26];
        for (int i = 0; i < n; i++) {
            int ind = chrs[i] - 'a';
            if (conts[ind] == null) {
                conts[ind] = new ArrayList<Integer>();
            }
            conts[ind].add(Integer.valueOf(i));
        }
        for (int i = n - 1; i > -1 ; i--) {
            int ind = chrs[i] - 'a';
            if (conts[ind].size() > 1) {
                for (int j = 0; j < conts[ind].size() - 1; j++) {
                    int e = conts[ind].get(j).intValue();
                    int l = e + 1, r = i - 1;
                    while (l < r && chrs[l] == chrs[r]) {
                        l++;
                        r--;
                    }
                    if (l == r || r + 1 == l) {
                        dp[i + 1] = Math.max(dp[i + 1], i - e + 1);
                        break;
                    }
                }
                conts[ind].removeLast();
            }
        }
        return dp;
    }
}
