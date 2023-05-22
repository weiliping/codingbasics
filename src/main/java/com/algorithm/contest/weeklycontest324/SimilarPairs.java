package com.algorithm.contest.weeklycontest324;

import java.util.HashMap;
import java.util.Map;

public class SimilarPairs {

    public static void main(String[] args) {
        String[] words = new String[] { "aba", "aabb", "abcd", "bac", "aabc" };
        System.out.println(similarPairs(words));
    }

    public static int similarPairs(String[] words) {
        Map<Integer, Integer> keys = new HashMap<>();
        for (String word : words) {
            int k = toKey(word);
            keys.put(k, keys.getOrDefault(k, 0) + 1);
        }
        int cnt = 0;
        for (Integer k : keys.keySet()) {
            if (keys.get(k) > 1) {
                int v = keys.get(k);
                cnt += ((v * (v - 1)) >> 1);
            }
        }
        return cnt;
    }

    public static int toKey(String word) {
        int[] cnts = new int[26];
        for (char ch : word.toCharArray()) {
            cnts[ch - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (cnts[i] != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
