package com.algorithm.contest.weeklycontest293;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveAnagrams {
    public static void main(String[] args) {
        String[] words = new String[] { "abba", "baba", "bbaa", "cd", "cd" };
        System.out.println(removeAnagrams(words));
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        int[] pre = new int[26], cur = new int[26];
        toNum(pre, words[0]);
        res.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            Arrays.fill(cur, 0);
            toNum(cur, words[i]);
            if (isEqual(pre, cur)) {
                continue;
            }
            res.add(words[i]);
            pre = Arrays.copyOfRange(cur, 0, 26);
        }
        return res;
    }

    public static void toNum(int[] chs, String word) {
        for (char c : word.toCharArray()) {
            chs[c - 'a']++;
        }
    }

    public static boolean isEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static String toKey(String word) {
        int[] chs = new int[26];
        for (char c : word.toCharArray()) {
            chs[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (chs[i] != 0) {
                sb.append((char) (i + 'a')).append(chs[i]);
            }
        }
        return sb.toString();
    }
}
