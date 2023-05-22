package com.algorithm.contest.weeklycontest83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargeGroupPositions {
    public static void main(String[] args) {
        List<List<Integer>> res = largeGroupPositions("abcdddeeeeaabbbcd");
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
        List<List<Integer>> res2 = largeGroupPositions("aa");
        for (List<Integer> r : res2) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, j = 0;
        for (; j < n; j++) {
            if (chrs[i] == chrs[j]) {
                continue;
            }
            if (j - i > 2) {
                res.add(Arrays.asList(i, j - 1));
            }
            i = j;
        }
        if (j - i > 2) {
            res.add(Arrays.asList(i, j - 1));
        }
        return res;
    }
}
