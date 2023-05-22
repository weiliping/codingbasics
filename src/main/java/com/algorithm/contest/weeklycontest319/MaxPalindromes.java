package com.algorithm.contest.weeklycontest319;

public class MaxPalindromes {

    public static void main(String[] args) {
        String s = "abaccdbbd";
        int k = 3;
        System.out.println(maxPalindromes(s, k));
        String s1 = "abaccdbbd";
        int k1 = 3;
        System.out.println(maxPalindromes(s1, k1));
    }

    public static int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] res = new int[n + 1];
        char[] chrs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            res[l + 1] = Math.max(res[l + 1], res[l]);
            while (l >= 0 && r < n && chrs[l] == chrs[r]) {
                if (r - l + 1 >= k) {
                    res[r + 1] = Math.max(res[r + 1], res[l] + 1);
                    break;
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && chrs[l] == chrs[r]) {
                if (r - l + 1 >= k) {
                    res[r + 1] = Math.max(res[r + 1], res[l] + 1);
                    break;
                }
                l--;
                r++;
            }
        }
        return res[n];
    }
}
