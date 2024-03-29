package com.algorithm.contest.weeklycontest390;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Pair {
    long v;
    int k;
    public Pair(long v, int k) {
        this.v = v;
        this.k = k;
    }
}
public class MostFrequentIds {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,4,3,10};
        int[] freq = new int[] {4,-4,3,1,2};
        long[] res = new MostFrequentIds().mostFrequentIDs(nums, freq);
        System.out.println(Arrays.toString(res));
    }
    public long[] mostFrequentIDsII(int[] nums, int[] freq) {
        int n = nums.length;
        long[] res = new long[n];

        Map<Integer, Long> mp = new HashMap<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Long.compare(b.v, a.v));

        for (int i = 0; i < n; i++) {
            int k = nums[i];
            long v = mp.getOrDefault(k, 0l) + freq[i];
            mp.put(k, v);
            queue.add(new Pair(v, k));
            while (!queue.isEmpty() && queue.peek().v != mp.get(queue.peek().k)) {
                queue.poll();
            }
            res[i] = queue.peek().v;
        }
        return res;
    }
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] res = new long[n];
        
        Map<Integer, Long> mp = new HashMap<>();
        TreeMap<Long, Integer> cnts = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int k = nums[i];
            if (mp.containsKey(k)) {
                long v = mp.get(k);
                if (cnts.containsKey(v)) {  
                    int cnt = cnts.get(v);
                    if (cnt == 1) {
                        cnts.remove(v);
                    } else {
                        cnts.put(v, cnts.get(v) - 1);
                    }
                }
                v += freq[i];
                if (v == 0) {
                    mp.remove(k);
                } else {
                    mp.put(k, v);
                }
                cnts.put(v, cnts.get(v) + 1);
                res[i] = cnts.lastKey();
                continue;
            }
            long v = (long) freq[i];
            mp.put(k, v);
            cnts.put(v, cnts.getOrDefault(v, 0) + 1);
            res[i] = cnts.lastKey();
        }
        return res;
    }
}