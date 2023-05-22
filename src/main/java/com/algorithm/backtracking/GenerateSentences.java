package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/synonymous-sentences/
 * 给你一个近义词表 synonyms 和一个句子 text ， synonyms 表中是一些近义词对 ，你可以将句子 text
 * 中每个单词用它的近义词来替换。
 * 请你找出所有用近义词替换后的句子，按 字典序排序 后返回。
 *  
 * 示例 1：
 * 输入：
 * synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
 * text = "I am happy today but was sad yesterday"
 * 输出：
 * ["I am cheerful today but was sad yesterday",
 * "I am cheerful today but was sorrow yesterday",
 * "I am happy today but was sad yesterday",
 * "I am happy today but was sorrow yesterday",
 * "I am joy today but was sad yesterday",
 * "I am joy today but was sorrow yesterday"]
 *  
 * 提示：
 * 0 <= synonyms.length <= 10
 * synonyms[i].length == 2
 * synonyms[0] != synonyms[1]
 * 所有单词仅包含英文字母，且长度最多为 10 。
 * text 最多包含 10 个单词，且单词间用单个空格分隔开。
 */
public class GenerateSentences {
    public static void main(String[] args) {
        GenerateSentences g = new GenerateSentences();
        List<List<String>> sub = new ArrayList<>();

        sub.add(Arrays.asList("happy", "joy"));
        sub.add(Arrays.asList("sad", "sorrow"));
        sub.add(Arrays.asList("joy", "cheerful"));
        // sub.add(Arrays.asList("a","QrbCl"));

        // String text = "d QrbCl ya ya NjZQ";
        String text = "I am happy today but was sad yesterday";
        List<String> strs = g.generateSentencesI(sub, text);
        List<String> strs2 = g.generateSentencesII(sub, text);
        for (String s : strs) {
            System.out.println(s);
        }

        for (String s : strs2) {
            System.out.println(s);
        }
    }

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Set<String> sub = new HashSet<>();
        dfs(synonyms, sub, 0, synonyms.size(), text.split(" "));
        List<String> res = new ArrayList<>(sub);
        Collections.sort(res);
        return res;
    }

    void dfs(List<List<String>> synonyms, Set<String> res, int s, int n, String[] strs) {
        if (s == n) {
            res.add(String.join(" ", strs));
            return;
        }
        List<String> syn = synonyms.get(s);
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(syn.get(0))) {
                strs[i] = syn.get(1);
            }
        }
        dfs(synonyms, res, s + 1, n, strs);
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(syn.get(1))) {
                strs[i] = syn.get(0);
            }
        }
        dfs(synonyms, res, s + 1, n, strs);
    }

    public List<String> generateSentencesI(List<List<String>> synonyms, String text) {
        // 根据近义词对建立无向图
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : synonyms) {
            graph.computeIfAbsent(pair.get(0), unused -> new LinkedList<>()).add(pair.get(1));
            graph.computeIfAbsent(pair.get(1), unused -> new LinkedList<>()).add(pair.get(0));
        }

        // 进行回溯
        List<String> result = new LinkedList<>();
        backtrack(result, graph, text.split(" "), 0, new LinkedList<>());
        result.sort(null);
        return result;
    }

    private void backtrack(List<String> result, Map<String, List<String>> graph, String[] words, int index,
            LinkedList<String> path) {
        // 构造完成
        if (index == words.length) {
            result.add(String.join(" ", path));
            return;
        }

        // 使用栈进行DFS, 保存访问过的单词,防止存在环
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new LinkedList<>();
        stack.push(words[index]);
        while (!stack.isEmpty()) {
            String word = stack.pop();

            path.add(word);
            backtrack(result, graph, words, index + 1, path);
            path.remove(path.size() - 1);

            visited.add(word);

            List<String> neighbors = graph.get(word);
            if (neighbors != null) {
                for (String nei : neighbors) {
                    if (visited.add(nei)) {
                        stack.push(nei);
                    }
                }
            }
        }
    }

    private DSU dsu;
    private Map<String, HashSet<String>> dicMap = new HashMap<>();

    public List<String> generateSentencesII(List<List<String>> synonyms, String text) {
        List<String> result = new ArrayList<>();
        if (null == synonyms) {
            result.add(text);
            return result;
        }
        if (text == null || text.length() == 0) {
            return result;
        }
        dsu = new DSU(synonyms);
        for (List<String> stringList : synonyms) {
            String str1 = stringList.get(0);
            String str2 = stringList.get(1);
            dsu.union(str1, str2);
        }
        for (List<String> stringList : synonyms) {
            String parent = dsu.find(stringList.get(0));
            dicMap.putIfAbsent(parent, new HashSet<>());
            dicMap.get(parent).add(stringList.get(0));
            dicMap.get(parent).add(stringList.get(1));
        }

        String[] sentenceArray = text.split(" ");
        dfs(result, sentenceArray, 0, "");
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return result;
    }

    private void dfs(List<String> result, String[] sentenceArray, int index, String sentence) {
        if (index == sentenceArray.length) {
            result.add(sentence.trim());
            return;
        }
        if (!dsu.parent.containsKey(sentenceArray[index])) {
            dfs(result, sentenceArray, index + 1, sentence + " " + sentenceArray[index]);
        } else {
            String tempParent = dsu.find(sentenceArray[index]);
            HashSet<String> allWords = dicMap.get(tempParent);
            for (String word : allWords) {
                dfs(result, sentenceArray, index + 1, sentence + " " + word);
            }
        }
    }

    class DSU {
        Map<String, String> parent;

        /**
         * @param synonyms
         */
        DSU(List<List<String>> synonyms) {
            parent = new HashMap<>();
            init(synonyms);
        }

        public void init(List<List<String>> synonyms) {
            for (List<String> stringList : synonyms) {
                for (String str : stringList) {
                    parent.put(str, str);
                }
            }
        }

        public void union(String x, String y) {
            String parent1 = find(x);
            String parent2 = find(y);
            if (parent1.equals(parent2)) {
                return;
            }
            parent.put(y, parent1);
        }

        public String find(String x) {
            if (parent.get(x).equals(x)) {
                return x;
            }
            parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }
    }
}
