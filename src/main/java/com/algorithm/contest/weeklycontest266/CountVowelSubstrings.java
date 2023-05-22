package com.algorithm.contest.weeklycontest266;

import java.util.HashMap;
import java.util.Map;

public class CountVowelSubstrings {
    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("duuebuaeeeeeeuaoeiueaoui"));
    }
    static Map<Character, Integer> mp = new HashMap<>();
    static {
        mp.put('a', 0);
        mp.put('e', 1);
        mp.put('i', 2);
        mp.put('o', 3);
        mp.put('u', 4);
    }
    public static int countVowelSubstrings(String word) {
        char[] chrs = word.toCharArray();
        int n = chrs.length;
        int cnt = 0;
        for (int i = 0; i < n - 4; i++) {
            boolean[] cnts = new boolean[5];
            if (mp.containsKey(chrs[i])) {
                cnts[mp.get(chrs[i])] = true;
                boolean isFull = false;
                for (int j = i + 1; j < n; j++) {
                    if (!mp.containsKey(chrs[j])) {
                        break;
                    }

                    if (!cnts[mp.get(chrs[j])]) {
                        cnts[mp.get(chrs[j])] = true;
                        boolean full = true;
                        for (int k = 0; k < 5; k++) {
                            if (!cnts[k]) {
                                full = false;
                                break;
                            }
                        }
                        if (full) {
                            isFull = true;
                        }
                    }
                    if (isFull) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
