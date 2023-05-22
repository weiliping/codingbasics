package com.algorithm.contest.weeklycontest151;

import java.util.Arrays;

public class NumSmallerByFrequency {

    public static void main(String[] args) {
//        String[] queries1 = new String[] { "bbb", "cc" };
//        String[] words1 = new String[] { "a", "aa", "aaa", "aaaa" };
//        System.out.println(Arrays.toString(numSmallerByFrequency(queries1, words1)));

        String[] queries2 = new String[]{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};
        String[] words2 = new String[] {"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};
//        [6,1,1,2,3,3,3,1,3,2]
        System.out.println(Arrays.toString(numSmallerByFrequency(queries2, words2)));
    }
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int m = queries.length, n = words.length;
        int[] wordMins = new int[n];
        for (int i = 0; i < n; i++) {
            wordMins[i] = minFrequency(words[i]);
        }
        Arrays.sort(wordMins);

        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int freq = minFrequency(queries[i]);

            if (freq < wordMins[0]) {
                res[i] = n;
                continue;
            }
            if (freq >= wordMins[n - 1]) {
                continue;
            }
            int ind = findInd(wordMins, freq);
            if (ind != -1) {
                res[i] = n - ind;
            }
        }
        return res;
    }

    static int findInd(int[] wordMins, int target) {
        int n = wordMins.length, i = 0, j = n - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (wordMins[mid] <= target) {
                if (mid == n - 1) {
                    return -1;
                }
                if (wordMins[mid + 1] > target) {
                    return mid + 1;
                }
                i = mid + 1;
                continue;
            }
            if (mid == 0) {
                return -1;
            }
            if (wordMins[mid - 1] <= target) {
                return mid;
            }
            j = mid - 1;
        }
        return -1;
    }
    static int minFrequency(String str) {
        int cnt = 0;
        Character c = null;
        char[] chrs = str.toCharArray();
        for (char ch : chrs) {
            if (c == null || c > ch) {
                c = ch;
                cnt = 1;
                continue;
            }
            if (c == ch) {
                cnt++;
                continue;
            }
        }
        return cnt;
    }
}
