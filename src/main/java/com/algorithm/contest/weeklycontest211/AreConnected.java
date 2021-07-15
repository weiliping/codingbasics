package com.algorithm.contest.weeklycontest211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AreConnected {
    public static void main(String[] args) {
        AreConnected a = new AreConnected();
        int n = 6, threshold = 2, queries[][] = new int[][]{{1,4}, {2,5}, {3,6}};
        System.out.println(Arrays.toString(a.areConnected(n, threshold, queries).toArray()));

        int n1 = 6, threshold1 = 0, queries1[][] = new int[][]{{4,5}, {3,4}, {3,2}, {2,6}, {1,3}};
        System.out.println(Arrays.toString(a.areConnected(n1, threshold1, queries1).toArray()));

        int n2 = 5, threshold2 = 1, queries2[][] = {{4,5}, {4,5}, {3,2}, {2,3}, {3,4}};
        System.out.println(Arrays.toString(a.areConnected(n2, threshold2, queries2).toArray()));
        
        int n3 = 9, threshold3 = 1, queries3[][] = {{6,8}, {6,9}, {8,9}};
        System.out.println(Arrays.toString(a.areConnectedI(n3, threshold3, queries3).toArray()));

        System.out.println("111");
    }


    public List<Boolean> areConnectedI(int n, int threshold, int[][] queries) {
        UnionFind uf = new UnionFind(n);
        for (int i = threshold + 1; i * 2 <= n; i++) {
            for (int j = 2; i * j <= n; j++) {
                uf.union(i, i * j);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            ans.add(uf.find(query[0]) == uf.find(query[1]));
        }
        return ans;
    }

    class UnionFind {
        int[] f;

        UnionFind(int n) {
            f = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                f[i] = i;
            }
        }

        int find(int x) {
            if (f[x] != x) f[x] = find(f[x]);
            return f[x];
        }

        void union(int x, int y) {
            x = find(x);
            y = find(y);
            f[x] = y;
        }
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> res = new ArrayList<>();

        Boolean[][] dp = new Boolean[n + 1][n + 1];
        int len = queries.length;
        for (int i = 0; i < len; i++) {
            res.add(i, isValid(queries[i], dp, threshold));
        }
        return res;
    }

    public static Boolean isValid(int[] q, Boolean[][] dp, int threshold) {
        int c = q[0], r = q[1];
        if (c > r) {
            int t = c;
            c = r;
            r = t;
        }
        if (dp[r][c] != null) {
            return dp[r][c];
        }
        dp[r][c] = Boolean.valueOf(gcd(r, c) > threshold);
        return dp[r][c];
    }

    public static int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return gcd(m, n % m);
    }
}
