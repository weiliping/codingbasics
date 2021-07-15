package com.algorithm.greedyalgorithm;

import java.util.Arrays;

public class FindContentChildren {
    public static void main(String[] args) {
        int[] g = new int[] {1, 2, 3};
        int[] s = new int[] {1, 1};
        System.out.println(new FindContentChildren().findContentChildren(g, s));
        int[] g1 = new int[] {1, 1, 2};
        int[] s1 = new int[] {1, 2, 3};
        System.out.println(new FindContentChildren().findContentChildren(g1, s1));
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length, m = s.length;
        int i = 0, j = 0, res = 0;
        while (i < n && j < m) {
            if (g[i] <= s[j]) {
                res++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return res;
    }
}
