package com.algorithm.contest.weeklycontest179;

import java.util.ArrayList;
import java.util.List;

public class NumOfMinutes {
    public static void main(String[] args) {
        int n = 1, headID = 0, manager[] = new int[] { -1 }, informTime[] = { 0 };
        System.out.println(toInformAll(n, headID, manager, informTime));

        int n1 = 6, headID1 = 2, manager1[] = new int[] { 2, 2, -1, 2, 2, 2 }, informTime1[] = { 0, 0, 1, 0, 0, 0 };
        System.out.println(toInformAll(n1, headID1, manager1, informTime1));

        int n3 = 7, headID3 = 6, manager3[] = new int[] { 1, 2, 3, 4, 5, 6, -1 }, informTime3[] =
                new int[] { 0, 6, 5, 4, 3, 2, 1 };
        System.out.println(toInformAll(n3, headID3, manager3, informTime3));

        int n2 = 15, headID2 = 0, manager2[] = new int[] { -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 }, informTime2[
                ] = new int[] { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
        System.out.println(toInformAll(n2, headID2, manager2, informTime2));

        int n4 = 4, headID4 = 2, manager4[] = new int[] { 3, 3, -1, 2 }, informTime4[] = new int[] { 0, 0, 162, 914 };
        System.out.println(toInformAll(n4, headID4, manager4, informTime4));
    }

    public static int toInformAll(int n, int headID, int[] managers, int[] informTime) {
        List<Integer>[] childs = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            childs[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (managers[i] == -1) {
                continue;
            }
            childs[managers[i]].add(i);
        }
        return dfs(childs, headID, informTime);
    }

    static int dfs(List<Integer>[] childs, int parentId, int[] informTime) {
        int pTime = informTime[parentId];

        if (childs[parentId].isEmpty()) {
            return pTime;
        }

        Integer subTime = Integer.MIN_VALUE;
        for (int c : childs[parentId]) {
            int childTime = dfs(childs, c, informTime);
            if (subTime < childTime) {
                subTime = childTime;
            }
        }
        return pTime + subTime;
    }
}
