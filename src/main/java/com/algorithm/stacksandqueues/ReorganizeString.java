package com.algorithm.stacksandqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        String s = "Programming";
        System.out.println(new ReorganizeString().reorganizeString(s));
    }

    class Pair {
        int v;
        char c;

        public Pair(char ch, int val) {
            c = ch;
            v = val;
        }
    }
    public String reorganizeString(String S) {
        Map<Character, Integer> cnts = new HashMap<>();
        for (char c : S.toCharArray()) {
            cnts.put(c, cnts.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.v - a.v);

        for(Map.Entry<Character, Integer> m : cnts.entrySet()) {
            queue.offer(new Pair(m.getKey(), m.getValue()));
        }

        Character prevChar = null;
        int prevCnt = -1;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (prevChar != null && prevCnt > 0) {
                queue.offer(new Pair(prevChar, prevCnt));
            }
            sb.append(pair.c);
            prevChar = pair.c;
            prevCnt = pair.v - 1;
        }

        return sb.length() == S.length() ? sb.toString() : "";
    }
}
