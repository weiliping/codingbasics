package com.algorithm.contest.weeklycontest225;

public class MinCharacters {
    public static void main(String[] args) {
        System.out.println(minCharacters("aba", "caa"));
        System.out.println(minCharacters("dabadd", "cda"));
    }
    public static int minCharacters(String a, String b) {
        int n = a.length(), m = b.length();

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (char c : a.toCharArray()) {
            cnt1[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            cnt2[c - 'a']++;
        }
        int aSum = 0, bSum = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < 25; i++) {
            aSum += cnt1[i];
            bSum += cnt2[i];
            int left = aSum + m - bSum;
            int right = bSum + n - aSum;
            res = Math.min(res, Math.min(left, right));
            res = Math.min(res, n - cnt1[i] + m - cnt2[i]);
        }
        res = Math.min(res, n - cnt1[25] + m - cnt2[25]);
        return res;
    }
}
