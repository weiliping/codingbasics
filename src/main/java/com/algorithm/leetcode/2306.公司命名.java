package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2306 lang=java
 *
 * [2306] 公司命名
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final int C = (int) 'a';
    public long distinctNames(String[] ideas) {
        long res = 0;
        Set<String>[] mp = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            mp[i] = new HashSet<>();
        }

        for (String idea : ideas) {
            mp[idea.charAt(0) - C].add(idea.substring(1));
        }
        for (int i = 0; i < 25; i++) {
            Set<String> iStrs = mp[i];
            int l = iStrs.size();
            for (int j = i + 1; j < 26; j++) {
                Set<String> jStrs = mp[j];
                int m = 0;
                for (String s : jStrs) {
                    if (iStrs.contains(s)) {
                        m++;
                    }
                }
                res += (1l * (l - m) * (jStrs.size() - m));
            }
        }
        return (res << 1);
    }
}
// @lc code=end

