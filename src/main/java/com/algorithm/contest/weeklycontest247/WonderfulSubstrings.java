package com.algorithm.contest.weeklycontest247;

import java.util.HashMap;
import java.util.Map;

public class WonderfulSubstrings {

    public static void main(String[] args) {
        System.out.println(wonderfulSubstrings("aba"));
        System.out.println(wonderfulSubstrings("aabb"));
        System.out.println(wonderfulSubstrings("he"));
    }

    public static long wonderfulSubstrings(String word) {
        long cnt = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        char[] chrs = word.toCharArray();
        int mask = 0;
        for (char ch : chrs) {
            int idx = ch - 'a';
            mask ^= (1 << idx);
            if (freq.containsKey(mask)) {
                cnt += freq.get(mask);
            }
            for (int i = 0; i < 10; i++) {
                int maskPre = mask ^ (1 << i);
                if (freq.containsKey(maskPre)) {
                    cnt += freq.get(maskPre);
                }
            }
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);
        }
        return cnt;
    }

    public static long wonderfulSubstringsII(String word) {
        int n = word.length();
        long res = 0;
        int[] base = new int[11];
        for (int i = 0; i < 10; i++) {
            base[i + 1] = (1 << i);
        }
        long[] arr = new long[1 << 10];
        arr[0] = 1;
        int v = 0;
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            v ^= base[index + 1];
            for (int j = 0; j < 11; j++) {
                res += arr[v ^ base[j]];
            }
            arr[v] += 1;
        }
        return res;
    }
}
