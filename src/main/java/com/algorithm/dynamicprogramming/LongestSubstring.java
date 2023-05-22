package com.algorithm.dynamicprogramming;

import java.util.Arrays;

public class LongestSubstring {

    /**
     * #395
     * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(longestSubstring("aaabb", 3));
//        System.out.println(longestSubstring("ababbc", 2));
//        System.out.println(longestSubstringII("aaabb", 3));
//        System.out.println(longestSubstringII("ababbc", 2));
//        System.out.println(longestSubstringIII("aaabb", 3));
//
//        System.out.println(longestSubstringIII("ababbc", 2));
//        System.out.println(longestSubstringIV("aaabb", 3));
//        System.out.println(longestSubstringIV("ababbc", 2));
        System.out.println(longestSubstringIV("aaabcccceececcdffeeessss", 2));
    }

    public static int longestSubstringIV(String s, int k) {
        return dfsHelper(s, 0, s.length() - 1, k);
    }

    private static int dfsHelper(String s, int l, int r, int k) {
        int[] chs = new int[26];
        for (int i = l; i <= r; i++) {
            chs[s.charAt(i) - 'a']++;
        }

        char split = 0;

        for (int i = 0; i < 26; i++) {
            if (chs[i] > 0 && chs[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }

        if (split == 0) {
            return r - l + 1;
        }

        int i = l, cnt = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }

            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }
            int ret = dfsHelper(s, start, i - 1, k);
            cnt = Math.max(cnt, ret);
        }
        return cnt;
    }

    public static int longestSubstringII(String s, int k) {
        return findlength(s, s.length(), k);
    }

    static boolean atLeastK(int freq[], int k) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0 && freq[i] < k) {
                return false;
            }
        }
        return true;
    }

    static int findlength(String str, int n, int k) {
        int maxLen = 0;
        int freq[] = new int[26];
        for (int i = 0; i < n; i++) {
            Arrays.fill(freq, 0);
            for (int j = i; j < n; j++) {
                freq[str.charAt(j) - 'a']++;
                if (atLeastK(freq, k)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static int longestSubstring(String s, int k) {
        int[] chs = new int[26];
        char[] chrs = s.toCharArray();
        for (char a : chrs) {
            chs[a - 'a']++;
        }

        int[] dp = new int[s.length() + 1];
        int cnt = Integer.MIN_VALUE;
        for (int i = 0; i < chrs.length; i++) {
            if (chs[chrs[i] - 'a'] >= k) {
                dp[i + 1] = dp[i] + 1;
            }
            cnt = Math.max(dp[i + 1], cnt);
        }
        return cnt;
    }

    public static int longestSubstringIII(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public static int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }
        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }
            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }
}
