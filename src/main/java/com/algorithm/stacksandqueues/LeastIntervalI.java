package com.algorithm.stacksandqueues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeastIntervalI {

    /**
     * https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode-solution-ur9w/
     * @param args
     */
    public static void main(String[] args) {
        LeastIntervalI l = new LeastIntervalI();
        System.out.println(l.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
        System.out.println(l.leastInterval(new char[]{'A','A','A','B','B','B'}, 50));
        System.out.println(l.leastInterval(new char[]{'A','A'}, 2));
        System.out.println(l.leastInterval(new char[]{'A','B', 'C', 'A', 'B'}, 2));
        System.out.println(l.leastInterval(new char[]{'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2));

        System.out.println("------------------------");
        System.out.println(l.leastIntervalII(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
        System.out.println(l.leastIntervalII(new char[]{'A','A','A','B','B','B'}, 50));
        System.out.println(l.leastIntervalII(new char[]{'A','A'}, 2));
        System.out.println(l.leastIntervalII(new char[]{'A','B', 'C', 'A', 'B'}, 2));
        System.out.println(l.leastIntervalII(new char[]{'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

    public int leastIntervalII(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int m = freq.size();
        List<Integer> nextValid = new ArrayList<Integer>();
        List<Integer> rest = new ArrayList<Integer>();
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }

        int time = 0;
        for (int i = 0; i < tasks.length; ++i) {
            ++time;
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            int best = -1;
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                    if (best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }

        return time;
    }
}
