package com.algorithm.contest.weeklycontest185;

import java.util.HashMap;
import java.util.Map;

public class MinNumberOfFrogs {

    public static void main(String[] args) {
        MinNumberOfFrogs m = new MinNumberOfFrogs();
        System.out.println(m.minNumberOfFrogs("croakcroak"));
        System.out.println(m.minNumberOfFrogs("crcoakroak"));
        System.out.println(m.minNumberOfFrogs("croakcrook"));
        System.out.println(m.minNumberOfFrogs("croakcroa"));

    }

    static Map<Character, Integer> mp = new HashMap<>();

    static {
        mp.put('c', 0);
        mp.put('r', 1);
        mp.put('o', 2);
        mp.put('a', 3);
        mp.put('k', 4);
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] cnt = new int[5];

        char[] chrs = croakOfFrogs.toCharArray();
        int availFrogs = 0, res = 0;
        for (char c : chrs) {
            int ind = mp.get(c);
            cnt[ind]++;

            if (ind == 0) {
                if (availFrogs > 0) {
                    availFrogs--;
                } else {
                    res++;
                }
                continue;
            }
            if (cnt[ind - 1] < cnt[ind]) {
                return -1;
            }

            if (ind == 4) {
                for (int i = 0; i < 5; i++) {
                    cnt[i]--;
                }
            }
        }
        return res;
    }
}
