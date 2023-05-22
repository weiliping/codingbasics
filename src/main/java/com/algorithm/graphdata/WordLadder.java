package com.algorithm.graphdata;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    /**
     * #127
     * http://zxi.mytechroad.com/blog/searching/leetcode-126-word-ladder-ii/
     * https://leetcode-cn.com/problems/word-ladder/
     *
     * @param args
     */
    public static void main(String[] args) {
        String bWord = "hit", eWord = "cog";
        String[] dicts = new String[] { "hot", "dot", "dog", "lot", "log", "cog" };
        System.out.println(ladderLength(bWord, eWord, Arrays.asList(dicts)));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        int l = beginWord.length();
        int steps = 1;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                String w = q.poll();
                char[] chs = w.toCharArray();
                for (int i = 0; i < l; i++) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (ch != c) {
                            chs[i] = c;
                            String s = new String(chs);
                            if (s.equals(endWord)) {
                                return steps + 1;
                            }
                            if (dict.contains(s)) {
                                dict.remove(s);
                                q.offer(s);
                            }
                        }
                    }
                    chs[i] = ch;
                }
            }
            steps++;
        }
        return 0;
    }
}
