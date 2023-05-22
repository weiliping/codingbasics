package com.algorithm.contest.weeklycontest236;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class MKAverageI {
    private int m;
    private int k;
    private long sum;

    private Queue<Integer> nums = new LinkedList<>();

    private TreeMap<Integer, Integer> lower = new TreeMap<>();
    private TreeMap<Integer, Integer> middle = new TreeMap<>();
    private TreeMap<Integer, Integer> upper = new TreeMap<>();

    private int lowerCnt;
    private int upperCnt;

    public MKAverageI(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        if (!lower.isEmpty() && num <= lower.lastKey()) {
            lower.put(num, lower.getOrDefault(num, 0) + 1);
            lowerCnt++;
        } else if (!upper.isEmpty() && num >= upper.firstKey()) {
            upper.put(num, upper.getOrDefault(num, 0) + 1);
            upperCnt++;
        } else {
            middle.put(num, middle.getOrDefault(num, 0) + 1);
            sum += num;
        }

        if (lowerCnt > k) {
            sum += shiftRight(lower, middle);
            lowerCnt--;
        } else if (upperCnt > k) {
            sum += shiftLeft(middle, upper);
            upperCnt--;
        }

        nums.offer(num);
        if (nums.size() > m) {
            int x = nums.poll();
            if (lower.containsKey(x)) {
                removeOnce(lower, x);
                lowerCnt--;
            } else if (middle.containsKey(x)) {
                removeOnce(middle, x);
                sum -= x;
            } else {
                removeOnce(upper, x);
                upperCnt--;
            }
        }

        if (nums.size() == m) {
            while (lowerCnt < k) {
                sum -= shiftLeft(lower, middle);
                lowerCnt++;
            }
            while (upperCnt < k) {
                sum -= shiftRight(middle, upper);
                upperCnt++;
            }
        }
    }

    public int calculateMKAverage() {
        if (nums.size() < m) {
            return -1;
        }
        return (int) (sum / (m - k * 2));
    }

    private int shiftLeft(TreeMap<Integer, Integer> l, TreeMap<Integer, Integer> r) {
        int x = r.firstKey();
        l.put(x, l.getOrDefault(x, 0) + 1);
        removeOnce(r, x);
        return x;
    }

    private int shiftRight(TreeMap<Integer, Integer> l, TreeMap<Integer, Integer> r) {
        int x = l.lastKey();
        r.put(x, r.getOrDefault(x, 0) + 1);
        removeOnce(l, x);
        return x;
    }

    private void removeOnce(Map<Integer, Integer> map, int x) {
        if (map.get(x) == 1) {
            map.remove(x);
        } else {
            map.put(x, map.get(x) - 1);
        }
    }
}
