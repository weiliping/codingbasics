package com.algorithm.contest.weeklycontest332;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubstringXorQueries {

    public static void main(String[] args) {
        String s1 = "101101";
        int[][] queries1 = new int[][] { { 0, 5 }, { 1, 2 } };
        int[][] res = substringXorQueries(s1, queries1);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }

        String s2 = "0101";
        int[][] queries2 = new int[][] { { 12, 8 } };
        int[][] res2 = substringXorQueries(s2, queries2);
        for (int[] r : res2) {
            System.out.println(Arrays.toString(r));
        }

        String s3 = "1";
        int[][] queries3 = new int[][] { { 4, 5 } };
        int[][] res3 = substringXorQueries(s3, queries3);
        for (int[] r : res3) {
            System.out.println(Arrays.toString(r));
        }

        String s4 = "111010110";
        int[][] queries4 = new int[][] { { 4, 2 }, { 3, 3 }, { 6, 4 }, { 9, 9 }, {
                10, 28 }, { 0, 470 }, { 5, 83 },
                { 10, 28 }, { 8, 15 }, { 6, 464 }, { 0, 3 }, { 5, 8 }, { 7, 7 }, { 8, 8 }, {
                        6, 208 },
                { 9, 15 },
                { 2, 2 }, { 9, 95 } };
        int[][] res4 = substringXorQueries(s4, queries4);
        for (int[] r : res4) {
            System.out.println(Arrays.toString(r));
        }

        String s5 = "01010011000111011011100010111";
        int[][] queries5 = new int[][] { { 2, 1 }, { 10, 11 }, { 1, 0 }, { 6, 243473 }, { 2, 2340629 }, { 4, 787 },
                { 5, 3801 } };
        int[][] res5 = substringXorQueries(s5, queries5);
        for (int[] r : res5) {
            System.out.println(Arrays.toString(r));
        }
    }

    public static int[][] substringXorQueries(String s, int[][] queries) {
        int n = queries.length;

        int[][] res = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], -1);
        }
        int[] vals = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] q = queries[i];
            int v = q[0] ^ q[1];
            vals[i] = v;
            if (max < v) {
                max = v;
            }
        }

        int len = Integer.toBinaryString(max).length();

        Map<Integer, int[]> mp = new HashMap<>();
        char[] chrs = s.toCharArray();
        int m = chrs.length;
        for (int i = 0; i < m; i++) {
            if (chrs[i] == '0') {
                if (!mp.containsKey(Integer.valueOf(0))) {
                    mp.put(0, new int[] { i, i });
                }
                continue;
            }

            int ind = 1, j = 1;
            if (!mp.containsKey(Integer.valueOf(ind))) {
                mp.put(ind, new int[] { i, i });
            }
            while (j < len && i + j < m) {
                ind = (ind << 1) + (chrs[i + j] - '0');
                if (!mp.containsKey(Integer.valueOf(ind))) {
                    mp.put(ind, new int[] { i, i + j });
                }
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (mp.containsKey(Integer.valueOf(vals[i]))) {
                res[i] = mp.get(vals[i]);
            } else {
                res[i] = new int[] { -1, -1 };
            }
        }
        return res;
    }
}
