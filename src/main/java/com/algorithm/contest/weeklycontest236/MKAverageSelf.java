package com.algorithm.contest.weeklycontest236;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class MKAverageSelf {
    public static void main(String[] args) {
        MKAverageSelf mk = new MKAverageSelf(3, 1);
        mk.addElement(17612);
        mk.addElement(74607);
        System.out.println(mk.calculateMKAverage());
        mk.addElement(8272);
        mk.addElement(33433);
        System.out.println(mk.calculateMKAverage());
        mk.addElement(15456);
        mk.addElement(64938);
        System.out.println(mk.calculateMKAverage());
        mk.addElement(99741);
    }
    static final int MOD = (int) 1e9 + 7;
    int m;
    int k;
    long sum = 0l;
    Queue<Integer> queue = new LinkedList<>();
    TreeMap<Integer, Integer> lower = new TreeMap<>();
    TreeMap<Integer, Integer> middle = new TreeMap<>();
    TreeMap<Integer, Integer> upper = new TreeMap<>();

    int lowCnt = 0;
    int upperCnt = 0;

    public MKAverageSelf(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        if (!lower.isEmpty() && num <= lower.lastKey()) {
            lower.put(num, lower.getOrDefault(num, 0) + 1);
            lowCnt++;
        } else if (!upper.isEmpty() && num >= upper.firstKey()) {
            upper.put(num, upper.getOrDefault(num, 0) + 1);
            upperCnt++;
        } else {
            middle.put(num, middle.getOrDefault(num, 0) + 1);
            sum += num;
        }

        if (lowCnt > k) {
            sum += moveRight(lower, middle);
            lowCnt--;
        } else if (upperCnt > k) {
            sum += moveLeft(middle, upper);
            upperCnt--;
        }
        queue.offer(num);
        if (queue.size() > m) {
            int f = queue.poll();
            if (lower.containsKey(f)) {
                removeFromMap(lower, f);
                lowCnt--;
            } else if (upper.containsKey(f)) {
                removeFromMap(upper, f);
                upperCnt--;
            } else {
                removeFromMap(middle, f);
                sum -= f;
            }
        }

        if (queue.size() == m) {
            while (lowCnt < k) {
                sum -= moveLeft(lower, middle);
                lowCnt++;
            }

            while (upperCnt < k) {
                sum -= moveRight(middle, upper);
                upperCnt++;
            }
        }
    }

    private void removeFromMap(TreeMap<Integer, Integer> m, int key) {
        if (m.get(key) == 1) {
            m.remove(key);
            return;
        }
        m.put(key, m.get(key) - 1);
    }

    private int moveLeft(TreeMap<Integer, Integer> l, TreeMap<Integer, Integer> r) {
        Integer k = r.firstKey();
        l.put(k, l.getOrDefault(k, 0) + 1);
        removeFromMap(r, k);
        return k;
    }

    private int moveRight(TreeMap<Integer, Integer> l, TreeMap<Integer, Integer> r) {
        Integer k = l.lastKey();
        r.put(k, r.getOrDefault(k, 0) + 1);
        removeFromMap(l, k);
        return k;
    }

    public int calculateMKAverage() {
        if (queue.size() < m) {
            return -1;
        }
        return (int)(sum / (m - 2 * k) % MOD);
    }
}
