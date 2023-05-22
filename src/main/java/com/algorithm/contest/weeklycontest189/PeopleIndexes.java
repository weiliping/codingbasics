package com.algorithm.contest.weeklycontest189;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PeopleIndexes {
    public static void main(String[] args) {
        PeopleIndexes p = new PeopleIndexes();
        List<List<String>> fav = new ArrayList<>();
        List<String> fa = new ArrayList<>();
        fa.add("leetcode");
        fa.add("google");
        fa.add("facebook");
        fav.add(fa);
        List<String> fa3 = new ArrayList<>();
        fa3.add("google");
        fa3.add("microsoft");
        fav.add(fa3);
        List<String> fa1 = new ArrayList<>();
        fa1.add("google");
        fa1.add("facebook");
        fav.add(fa1);
        List<String> fa2 = new ArrayList<>();
        fa2.add("google");
        fav.add(fa2);

        List<String> fa5 = new ArrayList<>();
        fa5.add("amazon");
        fav.add(fa5);
        System.out.println(Arrays.toString(p.peopleIndexes(fav).toArray()));
    }
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        int[][] inds = new int[n][2];

        for (int i = 0; i < n; i++) {
            inds[i] = new int[] {favoriteCompanies.get(i).size(), i};
        }
        Arrays.sort(inds, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Set<Integer> con = new HashSet<>();
        HashSet[] comps = new HashSet[n];
        for (int i = n -1; i >= 0; i--) {
            comps[i] = new HashSet<>(favoriteCompanies.get(inds[i][1]));
        }
        con.add(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            boolean isSub = false;
            for (int j : con) {
                if (comps[j].containsAll(comps[i])) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                con.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int ind : con) {
            res.add(inds[ind][1]);
        }
        Collections.sort(res);
        return res;
    }
}
