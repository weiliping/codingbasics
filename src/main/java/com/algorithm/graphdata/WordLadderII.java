package com.algorithm.graphdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderII {

    /**
     * #126
     * https://leetcode-cn.com/problems/word-ladder-ii
     * https://wdxtub.com/interview/14520607221562.html
     *
     * @param args
     */
    public static void main(String[] args) {
        String bWord = "hit", eWord = "cog";
        String[] dicts = new String[] { "hot", "dot", "dog", "lot", "log", "cog" };
        List<List<String>> res = findLadders(bWord, eWord, Arrays.asList(dicts));
        for (List<String> s : res) {
            System.out.println(Arrays.toString(s.toArray()));
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();

        if (beginWord.equals(endWord)) {
            return res;
        }
        Set<String> dicts = new HashSet<>(wordList);

        Set<String> visited = new HashSet<>();
        Set<String> cur = new HashSet<>();

        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        graph.put(endWord, new ArrayList<>());
        cur.add(beginWord);

        boolean found = false;

        while (!cur.isEmpty() && !found) {
            Set<String> queue = new HashSet<>();
            for (String s : cur) {
                visited.add(s);
            }
            for (String s : cur) {
                char[] chs = s.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char ch = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (ch != c) {
                            chs[i] = c;
                            String newS = new String(chs);
                            if (!dicts.contains(newS)) {
                                continue;
                            }
                            if (found && !endWord.equals(newS)) {
                                continue;
                            }
                            if (endWord.equals(newS)) {
                                found = true;
                                (graph.get(endWord)).add(s);
                                continue;
                            }
                            if (!visited.contains(newS)) {
                                queue.add(newS);
                                if (!graph.containsKey(newS)) {
                                    ArrayList<String> l = new ArrayList<>();
                                    l.add(s);
                                    graph.put(newS, l);
                                } else {
                                    (graph.get(newS)).add(s);
                                }
                            }
                        }
                    }
                    chs[i] = ch;
                }
            }
            cur = queue;
        }
        if (found) {
            ArrayList<String> path = new ArrayList<>();
            trace(res, graph, path, beginWord, endWord);
        }
        return res;
    }

    private static void trace(List<List<String>> res, HashMap<String, ArrayList<String>> graph, ArrayList<String> path,
            String start, String now) {
        path.add(now);
        if (now.equals(start)) {
            ArrayList<String> ans = new ArrayList<>(path);
            Collections.reverse(ans);
            res.add(ans);
            path.remove(path.size() - 1);
            return;
        }
        ArrayList<String> cur = graph.get(now);
        for (int i = 0; i < cur.size(); ++i) {
            trace(res, graph, path, start, cur.get(i));
        }
        path.remove(path.size() - 1);
    }
}
