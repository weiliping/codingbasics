package com.algorithm.contest.weeklycontest325;

public class TakeCharacters {

    public static void main(String[] args) {
        // String s = "aabaaaacaabc";
        // int k = 2;
        // System.out.println(takeCharacters(s, k));

        // String s1 = "caaa";
        // int k1 = 1;
        // System.out.println(takeCharacters(s1, k1));

        String s2 = "ccbabcc";
        int k2 = 1;
        System.out.println(takeCharacters(s2, k2));
    }

    public static int takeCharacters(String s, int k) {
        int res = -1, n = s.length();
        int minLen = k * 3;
        if (n < minLen) {
            return res;
        }

        int[] cnt = new int[3];
        int right = -1;
        char[] chrs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            cnt[chrs[i] - 'a']++;
            if (cnt[0] >= k && cnt[1] >= k && cnt[2] >= k) {
                right = i;
                res = right + 1;
                break;
            }
        }

        if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
            return res;
        }

        int[] cnt1 = new int[3];
        int left = -1;
        for (int i = n - 1; i >= 0; i--) {
            cnt1[chrs[i] - 'a']++;
            if (cnt1[0] >= k && cnt1[1] >= k && cnt1[2] >= k) {
                left = i;
                int r = n - left + 1;
                if (res > r) {
                    res = r;
                }
                break;
            }
        }
        int j = 0, len = n - left + right + 1;
        while (cnt[0] >= k && cnt[1] >= k && cnt[2] >= k) {
            int ind = right - j;
            cnt[chrs[ind] - 'a']--;
            j++;
        }

        for (int i = right + 1; i < len; i++) {
            int ind = right - i;
            if (ind < 0) {
                ind = n + ind;
            }
            cnt[chrs[ind] - 'a']++;

            while (cnt[0] >= k && cnt[1] >= k && cnt[2] >= k) {
                int sub = i - j + 1;
                if (sub < res) {
                    res = sub;
                }
                int ind1 = right - j;
                if (ind1 < 0) {
                    ind1 = n + ind1;
                }
                cnt[chrs[ind1] - 'a']--;
                j++;
                if (j > right + 1) {
                    break;
                }
            }
        }
        return res;
    }
}
