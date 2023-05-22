package com.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {

    /**
     * #140
     * https://leetcode-cn.com/problems/word-break-ii/
     * @param args
     */
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList(Arrays.asList(new String[] { "cat", "cats", "and", "sand", "dog" }));
        System.out.println(Arrays.toString(wordBreak(s, wordDict).toArray()));
    }

    static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        int n = s.length();

        boolean[] canBreak = new boolean[n + 1];
        canBreak[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (wordDict.contains(s.substring(i, j + 1)) && canBreak[j + 1]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }

        if (!canBreak[0]) {
            return res;
        }
        wordBreakRe(s, wordDict, "", 0, res);
        return res;
    }

    static void wordBreakRe(String s, List<String> dict, String path, int start, List<String> res) {
        if (start == s.length()) {
            res.add(path);
            return;
        }

        if (path.length() != 0) {
            path = path + " ";
        }

        for (int i = start; i < s.length(); i++) {
            String word = s.substring(start, i + 1);
            if (!dict.contains(word)) {
                continue;
            }
            wordBreakRe(s, dict, path + word, i + 1, res);
        }
    }
}
