package com.algorithm.contest.weeklycontest297;

import java.util.HashMap;
import java.util.Map;

public class DistinctNames {
    public static void main(String[] args) {
        String[] ideas = new String[] { "coffee", "donuts", "time", "toffee" };
        System.out.println(distinctNames(ideas));
        String[] ideas1 = new String[] { "aaa", "baa", "caa", "bbb", "cbb", "dbb" };
        System.out.println(distinctNames(ideas1)); // 2
    }

    public static long distinctNames(String[] ideas) {
        long res = 1l;
        int[] cnts = new int[26];
        Map<String, Boolean[]> mp = new HashMap<>();
        int n = ideas.length;
        for (String idea : ideas) {
            char ch = idea.charAt(0);
            int ind = ch - 'a';
            cnts[ind]++;
            String k = idea.substring(1);
            Boolean[] chrs = mp.getOrDefault(k, new Boolean[26]);
            chrs[ind] = true;
            mp.put(k, chrs);
        }

        res *= n;
        res *= n - 1;
        for (int i = 0; i < 26; i++) {
            if (cnts[i] > 1) {
                res -= cnts[i] * (cnts[i] - 1);
            }
        }
        for (Map.Entry<String, Boolean[]> m : mp.entrySet()) {
            Boolean[] vals = m.getValue();
            boolean[] sameLetters = new boolean[26];
            int cnt = 0;
            for (int i = 0; i < 26; i++) {
                sameLetters[i] = vals[i] != null && vals[i];
                if (sameLetters[i]) {
                    cnt++;
                }
            }

            if (cnt > 1) {
                for (int i = 0; i < 26; i++) {
                    if (sameLetters[i]) {
                        for (int j = 0; j < 26; j++) {
                            if (i != j && sameLetters[j] && cnts[j] > 0) {
                                res -= cnts[j] * 2;
                            }
                        }
                        cnts[i]--;
                    }
                }
            }
        }
        return res;
    }
}
