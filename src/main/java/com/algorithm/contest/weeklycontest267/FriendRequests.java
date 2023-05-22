package com.algorithm.contest.weeklycontest267;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FriendRequests {

    public static void main(String[] args) {
        int n = 3, restrictions[][] = new int[][] { { 0, 1 } }, requests[][] = new int[][] { { 0, 2 }, { 2, 1 } };
        System.out.println(Arrays.toString(friendRequests(n, restrictions, requests)));

        int n2 = 3, rest2[][] = new int[][] { { 0, 1 } }, req2[][] = new int[][] { { 1, 2 }, { 0, 2 } };
        System.out.println(Arrays.toString(friendRequests(n2, rest2, req2)));

        int n3 = 5, rest3[][] = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 } }, req3[][] =
                new int[][] { { 0, 4 }, { 1, 2 }, { 3, 1 }, { 3, 4 } };
        System.out.println(Arrays.toString(friendRequests(n3, rest3, req3)));
    }

    public static boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        Set<Integer>[] restriSet = new HashSet[n];
        for (int i = 0; i < n; i++) {
            restriSet[i] = new HashSet<>();
        }

        for (int[] res : restrictions) {
            restriSet[res[0]].add(res[1]);
            restriSet[res[1]].add(res[0]);
        }

        int[] union = new int[n];
        Arrays.setAll(union, i -> i);

        int m = requests.length;
        boolean[] friends = new boolean[m];
        for (int i = 0; i < m; i++) {
            int[] req = requests[i];
            int p = find(union, req[0]);
            int q = find(union, req[1]);
            if (p == q || !restriSet[p].contains(q)) {
                friends[i] = true;
                if (p != q) {
                    union[q] = p;
                    if (!restriSet[q].isEmpty()) {
                        restriSet[p].addAll(restriSet[q]);
                        for (int k : restriSet[q]) {
                            restriSet[k].remove(q);
                            restriSet[k].add(p);
                        }
                        restriSet[q] = new HashSet<>();
                    }
                }
            }
        }
        return friends;
    }

    static int find(int[] union, int x) {
        if (union[x] != x) {
            union[x] = find(union, union[x]);
        }
        return union[x];
    }
}
