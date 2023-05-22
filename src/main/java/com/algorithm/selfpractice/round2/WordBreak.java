package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList(Arrays.asList(new String[] { "cat", "cats", "and", "sand", "dog" }));
        System.out.println(Arrays.toString(wordBreak(s, wordDict).toArray()));
    }

    public static List<String> wordBreak(String s, List<String> dicts) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        int len = s.length();

        boolean[] dp = new boolean[len + 1];

        dp[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (dicts.contains(s.substring(i, j + 1)) && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        if (!dp[0]) {
            return res;
        }
        wordBreakHelper(s, 0, "", res, dicts);
        return res;
    }

    static void wordBreakHelper(String s, int start, String path, List<String> res, List<String> dicts) {
        if (start == s.length()) {
            res.add(path);
            return;
        }

        if (path != null && path.length() > 0) {
            path += " ";
        }

        for (int j = start; j < s.length(); j++) {
            String word = s.substring(start, j + 1);
            if (!dicts.contains(word)) {
                continue;
            }
            wordBreakHelper(s, j + 1, path + word, res, dicts);
        }
    }
}
