package com.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreak {

    /**
     * #139
     * https://leetcode-cn.com/problems/word-break/
     * @param args
     */
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList(new String[] {"leet", "code"}));
        System.out.println(wordBreak(s, wordDict));

        String s1 = "applepenapple";
        List<String> wordDict1 = new ArrayList<>(Arrays.asList(new String[] {"apple", "pen"}));
        System.out.println(wordBreak(s1, wordDict1));

        String s2 = "catsandog";
        List<String> wordDict2 = new ArrayList<>(Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat"}));
        System.out.println(wordBreak(s2, wordDict2));


        String s3 = "leetcode";
        List<String> wordDict3 = new ArrayList<>(Arrays.asList(new String[] {"leet", "code"}));
        System.out.println(wordBreakBFS(s3, wordDict3));

        String s4 = "applepenapple";
        List<String> wordDict4 = new ArrayList<>(Arrays.asList(new String[] {"apple", "pen"}));
        System.out.println(wordBreakBFS(s4, wordDict4));

        String s5 = "catsandog";
        List<String> wordDict5 = new ArrayList<>(Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat"}));
        System.out.println(wordBreakBFS(s5, wordDict5));
    }

    static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (wordDict.contains(s.substring(i, j + 1)) && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    static boolean wordBreakBFS(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!dp[start]) {
                for (int i = start + 1; i <= len; i++) {
                    if (wordDict.contains(s.substring(start, i))) {
                        queue.offer(i);
                        if (i == len) {
                            return true;
                        }
                    }
                }
                dp[start] = true;
            }
        }
        return false;
    }
}
