package com.algorithm.contest.weeklycontest184;

import java.util.Arrays;

public class ProcessQueries {

    public static void main(String[] args) {

        ProcessQueries p = new ProcessQueries();
//        int[] queries = new int[] {4, 1, 2, 2};
//        int m = 4;
//        System.out.println(Arrays.toString(p.processQueries(queries, m)));
        int queries2[] = new int[]{7,5,5,8,3}, m2 = 8;
        System.out.println(Arrays.toString(p.processQueries(queries2, m2)));
        int queries3[] = new int[]{3, 1, 2, 1}, m3 = 5;
        System.out.println(Arrays.toString(p.processQueries(queries3, m3)));
    }
    public int[] processQueries(int[] queries, int m) {
        int[] queried = new int[m + 1];
        Arrays.setAll(queried, i -> i - 1);
        int n = queries.length;
        for (int i = 0; i < n; i++) {
            int k = queries[i];
            queries[i] = queried[k];
            int ind = queried[k];
            queried[k] = 0;
            int c = 0;
            for (int j = 1; j <= m; j++) {
                if (j != k && queried[j] < ind) {
                    c++;
                    queried[j]++;
                }
                if (c == ind) {
                    break;
                }
            }
        }
        return queries;
    }
}
