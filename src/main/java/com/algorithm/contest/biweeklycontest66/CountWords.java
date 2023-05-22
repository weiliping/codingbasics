package com.algorithm.contest.biweeklycontest66;

import java.util.HashMap;
import java.util.Map;

public class CountWords {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String w : words1) {
            cnt.put(w, cnt.getOrDefault(w, 0) + 1);
        }

        for (String w : words2) {
            int v = cnt.getOrDefault(w, 0);

            if (v > 1) {
                cnt.put(w, -1);
                continue;
            }
            if (v == 1) {
                cnt.put(w, 0);
                continue;
            }
            cnt.put(w, --v);
        }

        int ans = 0;
        for (String k : cnt.keySet()) {
            if (cnt.get(k) == 0) {
                ans++;
            }
        }
        return ans;
    }
}
