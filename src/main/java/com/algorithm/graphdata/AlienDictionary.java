package com.algorithm.graphdata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class AlienDictionary {

    public static void main(String[] args) {
        System.out.println(alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
    }

    public static String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        Map<Character, HashSet> graph = new HashMap<>();
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);

        for (String w : words) {
            for (Character c : w.toCharArray()) {
                if (graph.containsKey(c)) {
                    continue;
                }
                graph.put(c, new HashSet<Character>());
                inDegree[c - 'a'] = 0;
            }
        }

        for (int i = 1; i < words.length; i++) {
            String parent = words[i - 1];
            String child = words[i];

            int strLen = Math.min(parent.length(), child.length());
            for (int j = 0; j < strLen; j++) {
                char c1 = parent.charAt(j);
                char c2 = child.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    inDegree[c2 - 'a']++;
                    break;
                }
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int i = queue.poll();
            char c = (char) ('a' + i);
            sb.append(c);
            HashSet<Character> chs = graph.get(c);
            for (Character ch : chs) {
                inDegree[ch - 'a']--;
                if (inDegree[ch - 'a'] == 0) {
                    queue.offer(ch - 'a');
                }
            }
        }
        return sb.toString();
    }
}
