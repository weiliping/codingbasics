package com.algorithm.contest.weeklycontest245;

public class MaximumRemovals {

    public static void main(String[] args) {
        MaximumRemovals m = new MaximumRemovals();
        System.out.println(m.maximumRemovals("abcacb", "ab", new int[] { 3, 1, 0 }));
        System.out.println(m.maximumRemovals("abcbddddd", "abcd", new int[] { 3, 2, 1, 4, 5, 6 }));
        System.out.println(m.maximumRemovals("abcab", "abc", new int[] { 0, 1, 2, 3, 4 }));
    }
    public int maximumRemovals(String s, String p, int[] removable) {
        int[] del = new int[100001];
        int l = 0, r = removable.length;
        char[] sChrs = s.toCharArray(), pChrs = p.toCharArray();
        int n = sChrs.length, m = pChrs.length;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;

            for (int i = 0; i < mid; i++) {
                del[removable[i]] = 1;
            }

            int j = 0;
            for (int i = 0; i < n; i++) {
                if (del[i] == 1) {
                    continue;
                }
                if (j < m && sChrs[i] == pChrs[j]) {
                    j++;
                }
            }

            for (int i = 0; i < mid; i++) {
                del[removable[i]] = 0;
            }

            if (j == m) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
