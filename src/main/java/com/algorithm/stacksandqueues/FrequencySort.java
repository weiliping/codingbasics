package com.algorithm.stacksandqueues;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static void main(String[] args) {
        FrequencySort sort = new FrequencySort();
        System.out.println(sort.frequencySort("tree"));
    }

    class Pair {
        int v;
        char k;

        public Pair(char key, int val) {
            v = val;
            k = key;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.v - a.v);
        Iterator<Map.Entry<Character, Integer>> it = frequency.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Character, Integer> e = it.next();
            queue.offer(new Pair(e.getKey(), e.getValue()));
        }

        StringBuilder str = new StringBuilder();
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.v > 1) {
                int n = p.v;
                while (n > 0) {
                    str.append(p.k);
                    n--;
                }
            } else {
                str.append(p.k);
            }
        }
        return str.toString();
    }
}
