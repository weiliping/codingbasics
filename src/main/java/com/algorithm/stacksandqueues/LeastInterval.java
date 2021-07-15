package com.algorithm.stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastInterval {

    /**
     * #621
     * https://leetcode-cn.com/problems/task-scheduler/
     * @param args
     */
    public static void main(String[] args) {
        LeastInterval l = new LeastInterval();
//        System.out.println(Arrays.toString(l.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2).toArray()));
//        System.out.println(Arrays.toString(l.leastInterval(new char[]{'A','A','A','B','B','B'}, 50).toArray()));
//        System.out.println(Arrays.toString(l.leastInterval(new char[]{'A','A'}, 2).toArray()));
//        System.out.println(Arrays.toString(l.leastInterval(new char[]{'A','B', 'C', 'A', 'B'}, 2).toArray()));
//        System.out.println(Arrays.toString(l.leastInterval(new char[]{'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2).toArray()));

        System.out.println(l.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
        System.out.println(l.leastInterval(new char[]{'A','A','A','B','B','B'}, 50));
        System.out.println(l.leastInterval(new char[]{'A','A'}, 2));
        System.out.println(l.leastInterval(new char[]{'A','B', 'C', 'A', 'B'}, 2));
        System.out.println(l.leastInterval(new char[]{'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
//            for (char c : tasks) {
//                res.add(String.valueOf(c));
//            }
//            return res;
            return tasks.length;
        }

        Map<Character, Integer> cnts = new HashMap<>();
        for (char c : tasks) {
            cnts.put(c, cnts.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.v - a.v);

        for (Map.Entry<Character, Integer> m : cnts.entrySet()) {
            queue.offer(new Pair(m.getKey(), m.getValue()));
        }

        int sum = 0;
        int len = Math.max(tasks.length, (queue.peek().v - 1) * (n + 1) + 1);
        int l = len / (n + 1);
        if (len % (n + 1) != 0) {
            l++;
        }

        for (int i = 0; i < l; i++) {
            List<Pair> tmp = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                if (!queue.isEmpty()) {
                    Pair p = queue.poll();
                    sum++;
                    res.add(String.valueOf(p.k));
                    p.v--;
                    if (p.v > 0) {
                        tmp.add(p);
                    }
                } else {
                    if (i != l - 1) {
                        res.add("Nil");
                        sum++;
                    }
                }
            }
            if (tmp.size() != 0) {
                for (Pair p : tmp) {
                    queue.offer(p);
                }
            }
        }
        return sum;
    }

    class Pair {
        char k;
        int v;

        public Pair(char key, int val) {
            k = key;
            v = val;
        }
    }
}
