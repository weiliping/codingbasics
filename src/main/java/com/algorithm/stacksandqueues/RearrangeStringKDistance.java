package com.algorithm.stacksandqueues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringKDistance {

    public static void main(String[] args) {
        RearrangeStringKDistance d = new RearrangeStringKDistance();
        System.out.println(d.reorganize("aabbcc", 3));
        System.out.println(d.reorganize("aaabc", 3));
        System.out.println(d.reorganize("aaadbbcc", 2));
    }

    public String reorganize(String S, int k) {
        if (k == 0) {
            return S;
        }
        int len = S.length();

        Map<Character, Integer> cnts = new HashMap<>();

        for (char c : S.toCharArray()) {
            cnts.put(c, cnts.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.v - a.v);

        for (Map.Entry<Character, Integer> m : cnts.entrySet()) {
            queue.offer(new Pair(m.getKey(), m.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            List<Pair> tmp = new ArrayList<>();
            int d = Math.min(k, len);

            for (int i = 0; i < d; i++) {
                if (queue.isEmpty()) {
                    return "";
                }
                Pair p = queue.poll();

                sb.append(p.k);
                p.v--;
                if (p.v > 0) {
                    tmp.add(p);
                }
                len--;
            }

            for (Pair p : tmp) {
                queue.offer(p);
            }
        }
        return sb.toString();
    }

    class Pair {
        char k;
        int v;

        Pair(char key, int val) {
            k = key;
            v = val;
        }
    }
}
