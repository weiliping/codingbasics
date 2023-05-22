package com.algorithm.contest.weeklycontest152;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanMakePaliQueries {

    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries = new int[][]{{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        CanMakePaliQueries c = new CanMakePaliQueries();
        System.out.println(Arrays.toString(c.canMakePaliQueries(s, queries).toArray()));
        System.out.println(Arrays.toString(c.canMakePaliQueriesI(s, queries).toArray()));
    }
    public List<Boolean> canMakePaliQueriesI(String s, int[][] queries) {
        char[] chrs = s.toCharArray();
        int[] cnts = new int[26];
        List<Boolean> res = new ArrayList<>();
        int cnt;
        for (int[] q : queries) {
            if (q[0] == q[1]) {
                res.add(true);
                continue;
            }
            Arrays.fill(cnts, 0);
            cnt = 0;
            for (int i = q[0]; i <= q[1]; i++) {
                int ind = chrs[i] - 'a';
                if ((cnts[ind] & 1) == 0) {
                    cnts[ind]++;
                    cnt++;
                    continue;
                }
                cnts[ind]--;
                cnt--;
            }
            res.add((cnt >> 1) <= q[2]);
        }
        return res;
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] chsMap = new int[n + 1][26];
        char[] chrs = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            int[] currs = Arrays.copyOf(chsMap[i - 1], 26);
            currs[(chrs[i - 1] - 'a')]++;
            chsMap[i] = currs;
        }

        List<Boolean> res = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == q[1]) {
                res.add(true);
                continue;
            }
            int[] currs = Arrays.copyOf(chsMap[q[1] + 1], 26);
            int oddCnt = 0;
            int[] pres = chsMap[q[0]];
            for (int i = 0; i < 26; i++) {
                if (((currs[i] - pres[i]) & 1) != 0) {
                    oddCnt++;
                }
            }
            res.add((oddCnt >> 1) <= q[2]);
        }
        return res;
    }
}
